/*
 * 2013年Java的C组第八题：打印十字架
 */

package com.xiaomaotongzhi.test;

import java.util.Scanner;

public class pro5 {
	public static int layer ;
	public static int sideLength ;
	public static char[][] arr ;
	
	public static void main(String[] args) {
		//创建一个新的数组，以及输入函数
		Scanner scanner = new Scanner(System.in) ;
		layer = scanner.nextInt() ;
		
		//确定边长,第一层边长为9，第二层边长为13，第三层边长为17
		sideLength = 9+4*(layer-1) ; 
		arr = new char[sideLength][sideLength] ;
		replaceAll() ;
		// layer而不是layer-1，layer应该表示层数
		for(int i = layer ; i>=1 ; i--) replace$(i) ;
		replaceTen() ;
		print() ;
		scanner.close();
	}
	
	public static void replaceAll() {
		for(int i = 0 ; i<arr.length ; i++) {
			for(int j = 0 ; j<arr[i].length ;j++) {
				arr[i][j] = '.' ;
			}
		}
	}
	
	
	//这个地方问题出的最多，我的理解是要用start和end来表示整体规律
	public static void replace$( int nowSide) {
		//第四层的起始位置（0，0）、（20，20）
		//第三层的起始位置（2，2）、（18，18）
		//第二层的起始位置（4，4）、（16，16）
		//第一层的起始位置（6，6）、（14，14）
		int start = 2*(layer - nowSide) ;
		int end   = sideLength - 1 - start ;
		
		//打印第一层和倒数第一层
		for(int i = start+2 ; i<=end-2 ; i++ ) {
			 arr[start][i] = '$' ; arr[end][i] = '$' ;
		}
		
		//打印第二层和倒数第二层
		arr[start+1][start+2] = '$' ;
		arr[start+1][end-2] = '$' ;
		arr[end-1][start+2] = '$' ;
		arr[end-1][end-2] = '$' ;
		
		//打印第三层和倒数第三层
		for(int i = start ; i<=start+2 ; i++ ) {
			arr[start+2][i] = '$' ; 
			arr[end-2][i] = '$' ; 
		}
	
		for(int i = end-2; i<=end ; i++ ) {
			arr[start+2][i] = '$' ;
			arr[end-2][i] = '$' ;
		}
		
	
		//打印第四层
		for(int i = start+3 ; i <= end-3 ; i++) {
			arr[i][start] = '$' ; arr[i][end] = '$' ;
		}
		
	}
	
	public static void replaceTen( ) {
		int center = sideLength / 2 ;
		for(int i = center - 2 ; i<=center+2 ;i++) {
			arr[i][center] = '$' ;
			arr[center][i] = '$' ;
		}
	}
	
	public static void print() {
		for(int i = 0 ; i<=arr.length ; i++ ) {
			for(int j = 0 ; j<arr[i].length ; j++) {
				System.out.print(arr[i][j] + " ") ; 
			}
			System.out.println() ; 
		}
	}
	
}
