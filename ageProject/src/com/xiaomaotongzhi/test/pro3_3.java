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
import java.util.HashSet;
import java.util.List;

public class pro3_3 {
	//从M个元素中对N个元素进行全排列，且这M个元素中允许含有重复元素
	static HashSet<String> set = new HashSet<String>() ;
	
	public static void main(String[] args) {
		int[] ints = new int[] {1,2,2,4,5} ;
		List<Integer> list = new ArrayList<Integer>() ;
		//n表示要对多少个元素进行全排列
		int n = 3 ;
		//限定list集合长度
		for(int i = 0 ; i<n ; i++) {
			list.add(-1);
		}
		ListAll(list,ints,n) ;
		System.out.println("the size of set is : " + set.size());
		System.out.println(set.toString()) ;
	}
	
	public static void ListAll(List<Integer> list,int[] ints,int n) {
		if(n==0) {
			//我们要从数组ints中获取元素，list集合内存储的是下标，将下标转化成数组
			String all = ints[list.get(0)]+ " " + ints[list.get(1)] + " " + ints[list.get(2)] + " ";
			set.add(all) ;
			return ;
		}
		
		//遍历数组内所有的元素，所以要用ints.length
		for(int i=0 ; i<ints.length ; i++) {
			//当list集合中没有存储对应的下标时
			if(!list.contains(i)) {
				//对下标进行存储
				list.set(list.size()-n,i) ;
			}else continue ;
			
			ListAll(list,ints,n-1) ;
			//对数组进行复原
			list.set(list.size()-n, -1) ;
			
		}
	}
}
