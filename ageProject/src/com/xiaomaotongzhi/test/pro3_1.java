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

public class pro3_1 {
	/*
	注意，这一题和test2、test3两题有根本区别，前一题是全排列，给出的数的个数和要排列的个数相同，而
	这一题不一样，这一题是给出的数的个数与我们要排列的个数不相同
	*/
	public static void main(String[] args) {
		int count = 0 ;
		for(int a = 1 ; a<10 ; a++ ) {
			for(int b = 1 ; b<10 ; b++ ) {
				if(b==a) continue ;
				for(int c = 1 ; c<10 ; c++ ) {
					if(c==a || c==b) continue ;
					for(int d = 1 ; d<10 ; d++ ) {
						if(d==a || d==b || d==c) continue ;
						for(int e = 1 ; e<10 ; e++ ) {
							if(e==a || e==b || e==c || e==d) continue ;
							if((a*10 + b)*(c*100+d*10+e) == (a*100+d*10+b)*(c*10+e)) {
								count++ ;
							}
						}
					}
				}
			}
		}
		
		System.out.println(count) ;
	}
}
