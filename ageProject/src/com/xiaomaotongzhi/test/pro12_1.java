package com.xiaomaotongzhi.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


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

public class pro12_1 {

	static List<Character> list = new ArrayList<Character>() ;
	//花的记录次数
	static Integer count1 = 0 ;
	//店的记录次数
	static Integer count2 = 0 ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer dr = 2 ;
		drink(dr,count1,count2) ;
	}

	
	public static void drink(Integer dr , Integer count1, Integer count2) {
		if(dr==1 && count1==9 && count2==5) {
			Iterator<Character> it = list.iterator() ;
			while(it.hasNext()) {
				System.out.print(it.next()) ;
			}
			System.out.println();
			return ;
		}
		
		if(count1 + count2==15) return ;
		
		//遇见店
		list.add('a') ;
		drink(dr*2,count1,count2+1) ;
		//退出来说明无法成功，移除，进行还原
		list.remove(list.size()-1) ;
		
		//遇见花
		list.add('b') ;
		drink(dr-1,count1+1,count2) ;
		list.remove(list.size()-1) ;
	}
}
