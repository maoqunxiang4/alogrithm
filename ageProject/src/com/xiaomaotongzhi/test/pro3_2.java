/*
标题:马虎的算式

小明是个急性子，上小学的时候经常把老师写在黑板上的题目抄错了。有一次，老师出的题目是: 36x495= ? ,他却给抄成了: 396x45= ?

但结果却很戏剧性,他的答案竟然是对的! !因为36* 495=396* 45= 17820类似这样的巧合情况可能还有很多,比如: 27 * 594= 297* 54

假设abcde代表1 ~9不同的5个数字(注意是各不相同的数字，且不含0 )

能满足形如: ab * cde= adb * ce这样的算式一共有多少种呢 ?

请你利用计算机的优势寻找所有的可能,并回答不同算式的种类数。

满足乘法交换律的算式计为不同的种类,所以答案肯定是个偶数。

答案直接通过浏览器提交。I

注意:只提交-一个表示最终统计种类数的数字,不要提交解答过程或其它多余的内容。
*/


package com.xiaomaotongzhi.test;

import java.util.ArrayList;

//从M个数中取出N个数并进行全排列，且这N个数不能够重复
public class pro3_2 {
	public static Integer count = 0 ;  
	
	public static void main (String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9} ;
		int n = 5 ;
		ArrayList<Integer> list = new ArrayList<Integer>() ;
		//固定数组长度
		for(int i = 0 ; i<n ; i++) {
			list.add(-1) ;
		}
		ListAll(list,arr,n) ;
		System.out.println(count);
	}
	
	public static void ListAll(ArrayList<Integer> list ,int[] ints ,int n) {
		if(n==0) {
			int a = list.get(0) ;
			int b = list.get(1) ;
			int c = list.get(2) ;
			int d = list.get(3) ;
			int e = list.get(4) ;
			if((a*10+b)*(c*100+d*10+e) == (a*100+d*10+b)*(c*10+e)) count++ ;
			System.out.println(list.toString());
			return  ;
		}
		
		for(int i = 0 ; i<ints.length ;i++) {
			if(!list.contains(ints[i])) {
				list.set(list.size()-n, ints[i]) ;
			}else continue ;
			
			ListAll(list,ints,n-1) ;
			list.set(list.size()-n, -1) ;
		}
	}
}
