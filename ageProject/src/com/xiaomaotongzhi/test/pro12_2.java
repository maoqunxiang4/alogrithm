/*
 * 标题:李白打酒

话说大诗人李白，-生好饮。幸好他从不开车。

-天,他提着酒壶,从家里出来,酒壶中有酒2斗。他边走边唱:

“无事街上走,提壶去打酒。逢店加一倍,遇花喝一斗。”

这- -路上,他- -共遇到店5次,遇到花10次,已知最后- -次遇到的是花,他正好把酒喝光了。

请你计算李白遇到店和花的次序,可以把遇店记为a ,遇花记为b。则: babaabbabbabbbb就是合理的次序。像这样的答案一共有多少呢?请你计算出所有可能方案的个数(包含题目给出的)。

注意:通过浏览器提交答案。答案是个整数。不要书写任何多余的内容。

 * 
 * */

package com.xiaomaotongzhi.test;

public class pro12_2 {

	static int count = 0 ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dr = 2 ;
		drink(dr,0,0) ;
		System.out.println(count);
	}

	//count1遇见花
	//count2遇见店
	public static void drink(int dr ,int count1 ,int count2) {
		//最后一次遇见的是花，也就是说，在倒数第二次时酒只剩下一斗了
		if(count1==9 && count2==5 && dr==1 ) {
			count++ ;
			return ;
		}
		
		//if是表示什么情况的时候才会进行递归调用
		if(count2<5) drink(dr*2 , count1 , count2+1) ;
		if(count1<10) drink(dr-1 , count1+1 , count2) ;
	}
}
