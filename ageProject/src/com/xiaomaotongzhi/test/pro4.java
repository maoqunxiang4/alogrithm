/*
标题:第39级台阶
小明刚刚看完电影《第39级台阶》, 离开电影院的时候,他数了数礼堂前的台阶数,恰好是39级!
站在台阶前,他突然又想着一个问题 :
如果我每一步只能迈上1个或2个台阶。先迈左脚,然后左右交替,最后-步是迈右脚,也就是说一共要走偶数步。那么，上完39级台阶,有多少种不同的上法呢?
请你利用计算机的优势,帮助小明寻找答案。
要求提交的是一个整数。
注意:不要提交解答过程,或其它的辅助说明文字。
*/

package com.xiaomaotongzhi.test;

public class pro4 {
	public static Integer count = 0 ;
	
	public static void main(String[] args){
		walk(0,0) ;
		System.out.println("count = " + count);
	}
	
	public static void walk(int step ,int walkcount) {
		if(step>39 ) {
			return ;
		}
		if (step==39 && walkcount%2==0) {
			count++ ;
			return ;
		}
		walk(step+1,walkcount+1) ;
		walk(step+2,walkcount+1) ;
	}
}
