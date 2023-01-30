package com.xiaomaotongzhi.test;

import java.util.Scanner;

public class pro6_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in) ;
		int a = scanner.nextInt() ;
		int b = scanner.nextInt() ;
		int max = a*b ;
		
		for(int i = max ; i>=0 ; i--) {
			//为什么是从后往前排除而不是从前往后排除，原因就是从前往后排会遇到许多的无法组成的数字，但是从后往前排，一旦遇到无法组成的，就一定是最大那个
			boolean isTrue = buySuger(a,b,i) ;
			if(!isTrue) {
				System.out.println(i);
				break ;
			}
		}
		
		scanner.close();
	}
	
	public static boolean buySuger(int a , int b , int count) {
		for(int i = 0 ; i*a<=count ; i++) {
			//用表达式作为循环条件可以提高效率
			for(int j = 0 ; i*a+j*b <= count ; j++) {
				if(i*a+j*b==count) {
					return true ;
				}
			}
		}
		return false ;
	}
}
