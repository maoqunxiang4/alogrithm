/*
 标题:组素数

素数就是不能再进行等分的数。比如: 235711等。9=3* 3说明它可以3等分,因而不是素数。

我们国家在1949年建国。如果只给你1949这4个数字卡片,可以随意摆放它们的先后顺序(但卡片不能倒着摆放啊,我们不是在脑筋急转弯! ) , 那么,你能组成多少个4位的素数呢?

比如: 1949 , 4919都符合要求。

请你提交:能组成的4位素数的个数,不要罗列这些素数!!

注意:不要提交解答过程,或其它的辅助说明文字。
 */

package com.xiaomaotongzhi.test;

import java.util.HashSet;

public class pro2_2 {

	static HashSet<Integer> set = new HashSet<Integer>() ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] number = new int[] {1,9,4,9} ;
		fullSort(number ,0 ,number.length-1) ;
		System.out.println(set.size());
	}

	public static void fullSort(int[] arr ,int start ,int end) {
		if(start==end) {
			int num = arr[0]*1000 + arr[1]*100 + arr[2]*10 + arr[3] ;
			boolean isRight = true ;
			for(int i = 2 ; i<Math.sqrt(num) ;i++) {
				if(num%i==0) {
					isRight = false ;
					break ;
				}
			}
			
			if(isRight) {
				set.add(num) ;
			}
		}
			
		for(int i = start ; i<=end ; i++) {
			swap(arr,start,i) ;
			fullSort(arr,start+1,end) ;
			swap(arr,start,i) ;
		}
		
	}
	
	public static void swap(int[] arr , int i ,int j) {
		int temp ;
		temp = arr[i] ;
		arr[i] = arr[j] ;
		arr[j] = temp ;
	}
}
