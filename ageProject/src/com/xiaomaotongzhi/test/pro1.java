/*
标题:猜年龄

美国数学家维纳(N.Wiener)智力早熟，11岁就上了大学。他曾在1935-1936年应邀来中国清华大学讲学。

-次,他参加某个重要会议,年轻的脸孔引人注目。于是有人询问他的年龄,他回答说:“我年龄的立方是个4位数。我年龄的4次方是个6位数。这10个数字正好包含了从0到9这10个数字,每个都恰好出现1次。”

请你推算一下 ,他当时到底有多年轻。

通过浏览器,直接提交他那时的年龄数字。

注意:不要提交解答过程,或其它的说明文字。
*/

package com.xiaomaotongzhi.test;

import java.util.HashSet;
import java.util.Set;

public class pro1 {

	public static void main(String[] args) {
		
		for(int i=0 ; i<100 ; i++  ) {
			String age3 = i*i*i+"" ;
			String age4 = i*i*i*i+"" ;
			if( age3.length() == 4  && age4.length() == 6 ) {
				if(CheckAge(age3,age4)) {
					System.out.println(i) ; 
				}
			}
		}

	}
	
	public static boolean CheckAge ( String age3 , String age4 ) {
		String age = age3 + age4 ;
		HashSet<Character> set = new HashSet<Character>(); 
		for( int i = 0 ; i<10 ; i++) {
			set.add( age.charAt(i)) ;
		}
		return set.size() == 10 ;
	}

}
