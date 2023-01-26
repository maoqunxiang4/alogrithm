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

public class pro2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1,9,4,9} ;
		HashSet<Integer> set =  new HashSet<Integer>() ;
		
		for(int a = 0 ; a<4 ; a++) {
			for(int b = 0 ; b<4 ; b++) {
				if(b==a) continue ;
				for(int c = 0 ; c<4 ; c++) {
					if(c==a || c==b ) continue ;
					for(int d = 0 ; d<4 ; d++) {
						if(d==a || d==b || d==c) continue ;
						int number = arr[a]*1000 + arr[b]*100 + arr[c]*10 + arr[d] ;
						boolean isRight = true ;
						
						for(int i = 2 ; i<Math.sqrt(number) ; i++) {
							if(number%i==0) {
								isRight = false ;
								break ;
							}
						}
						
						if(isRight) {
							set.add(number) ;
						}
						
					}
				}
			}
		}
		
		System.out.println("the numebr is : " + set.size()) ;
		
		
	}

}
