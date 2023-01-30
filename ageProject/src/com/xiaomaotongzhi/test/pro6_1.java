/*
标题:买不到的数目

小明开了一家糖果店。他别出心裁:把水果糖包成4颗一包和7颗一包的两种。 糖果不能拆包卖。

小朋友来买糖的时候,他就用这两种包装来组合。当然有些糖果数目是无法组合出来的,比如要买10颗糖。

你可以用计算机测试一下,在这种包装情况下,最大不能买到的数量是17.大于17的任何数字都可以用4和7组合出来。

本题的要求就是在已知两个包装的数量时,求最大不能组合出的数字。

输入:

两个正整数,表示每种包装中糖的颗数(都不多于1000)

要求输出:

-一个正整数,表示最大不能买到的糖数

不需要考虑无解的情况
*/

package com.xiaomaotongzhi.test;

import java.util.HashSet;
import java.util.Scanner;

public class pro6_1 {

	static HashSet<Integer> set = new HashSet<Integer>() ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner scanner = new Scanner(System.in) ;
			int a = scanner.nextInt() ;
			int b = scanner.nextInt() ;
			int max = a*b ;
			
			for(int i = 0 ; i*a <= max ; i++) {
				for(int j = 0 ; j*b + i*a <= max  ; j++) {
					set.add(j*b + i*a) ;
				}
			}
			
			for(int i = max ; i>=0 ; i-- ) {
				if(!set.contains(i)) {
					System.out.println(i);
					break ;
				}
			}
			
			scanner.close() ;
	}

}
