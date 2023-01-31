/*
 * 如图所示，3 x 3 的格子中填写了一些整数。

我们沿着图中的红色线剪开，得到两个部分，每个部分的数字和都是60。

本题的要求就是请你编程判定：对给定的m x n 的格子中的整数，是否可以分割为两个部分，使得这两个区域的数字和相等。
　　如果存在多种解答，请输出包含左上角格子的那个区域包含的格子的最小数目。
　　如果无法分割，则输出 0

程序输入输出格式要求：
　　程序先读入两个整数 m n 用空格分割 (m,n<10)
　　表示表格的宽度和高度
　　接下来是n行，每行m个正整数，用空格分开。每个整数不大于10000
　　程序输出：在所有解中，包含左上角的分割区可能包含的最小的格子数目。

例如：
　　用户输入：
　　3 3
　　10 1 52
　　20 30 1
　　1 2 3

则程序输出：
　　3

再例如：
　　用户输入：
　　4 3
　　1 1 1 1
　　1 30 80 2
　　1 1 1 100

则程序输出：
　　10

 * */

package com.xiaomaotongzhi.test;

import java.util.Scanner;

public class pro7 {
	//定义一个二维数组存放迷宫数据
	static int arr[][] ;
	//总步数
	static int sum = 0;
	//列数
	static int m = 0;
	//行数
	static int n = 0;
	//最小步数。因为题目中说了最大是100，所以定义最小步数为100，根据后面的实际情况进行调整
	static int min = 100 ;
	//定义一个二维数组存放已走过的路的数据
	static int isOver[][] ;
	static int check[][] ;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in) ;
		m = scanner.nextInt() ;
		n = scanner.nextInt() ;
		arr = new int[n][m] ;
		check = new int[n][m] ;
		isOver = new int[n][m] ;
		 
		
		for(int i = 0 ; i<n ; i++) {
			for(int j = 0 ; j<m ; j++) {
				arr[i][j] = scanner.nextInt() ;
				sum += arr[i][j] ;
			}
		}
		
		if(sum % 2 == 1 ) {
			System.out.println(0);
			return ;
		}
		
		//调用递归函数
		//使用循环调用递归函数，以每一个点为初始点来调用，这样就能够把所有情况都包含进去
		for(int i = 0 ; i<n ; i++) {
			for(int j = 1 ; j<m ;j++ ) {
				move(i,j,0,0) ;
			}
		}
		
		//判断min是否发生过改变，发生过改变，那么就直接输出min，否则就是没有发生改变，则直接输出0
		System.out.println(min == 100 ? 0 : min);
		
		scanner.close();
	}
	
	public static void move(int row ,int col , int step ,int count) {
		//递归调用的终止条件。
		//1.判断数组是否发生了越界行为，发生了越界行为，停止调用。
		//2.判断总步数是否超过了一半，超过了，停止调用。
		//3.判断这一步是否走过了.如果不判断，就会陷入死循环
		if(row < 0 || col < 0 || row > n-1 || col > m-1 ||  step > sum/2 || isOver[row][col]==1  ) {
			return ; 
		}
		
		if(step==sum/2 && isOver[0][0]==1) {
			int x = 0,y = 0 ;
			//将检查走过哪些位置的数据进行拷贝
			for(int i = 0 ; i<n ; i++) {
				for(int j = 0 ; j<m ; j++) {
					if(isOver[i][j]==0) {
						x=i ; y=j ;
					}
					check[i][j] = isOver[i][j] ;
				}
			}
			
			//调用checkIsOk对check[i][j]进行检查
			checkIsOk(x,y,check) ;
			
			//对现在走过的路进行统计，如果 "1" + "2" != n*m ，那么就说明被分成的份数恰好是三份
			int step1 = 0 ;
			for(int i = 0 ; i<n ;i++) {
				for (int j = 0 ; j<m ; j++) {
					if (check[i][j] == 2 ) step1++ ;
				}
			}
			
			//三目运算符
			if(step1 + count != n*m) return ; 
			
			min = count < min ? count : min ;
		}
		
		//之前没有走过，现在走过了，进行标志
		isOver[row][col] = 1 ;
		//向上走
		move(row-1,col,step+arr[row][col],count+1) ;
		//向下走
		move(row+1,col,step+arr[row][col],count+1) ;
		//向左走
		move(row,col-1,step+arr[row][col],count+1) ;
		//向右走
		move(row,col+1,step+arr[row][col],count+1) ;
		//调用到最后，就说明没有通路，对标志进行取消
		isOver[row][col] = 0 ;
	}
	
	public static void checkIsOk(int x ,int y ,int[][] check) {
		int dir[][] =new int[][] {{-1,0},{1,0},{0,-1},{0,1}} ;
		check[x][y] = 2 ;
		for(int i = 0 ; i<4 ; i++) {
			int x1 = x + dir[i][0] ;
			int y1 = y + dir[i][1] ;
			if(x1<0 || x1>n-1 || y1<0 || y1>m-1 ) continue ;
			if(check[x1][y1]==0) checkIsOk(x1,y1,check) ;
		}
	}
	
}
