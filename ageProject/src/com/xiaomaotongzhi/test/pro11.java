/*
 * 标题:猜字母

把ab.d...s共19个字母组成的序列重复拼接106次,得到长度为2014的串。

接下来删除第1个字母(即开头的字母a) , 以及第3个,第5个等所有奇数位置的字母。

得到的新串再进行删除奇数位置字母的动作。如此下去,最后只剩下一一个字母,请写出该字母。答案是一个小写字母,请通过浏览器提交答案。不要填写任何多余的内容。

 * */


package com.xiaomaotongzhi.test;

import java.util.ArrayList;
import java.util.List;

public class pro11 {

	public static void main(String[] args) {
		//进行赋值
		String s = "abcdefghijklmnopqrs" ;
		
		List<Character> list = new ArrayList<Character>() ;
		
		for(int j = 0 ; j<106 ;j++) {
			for(int i = 0 ;  i<s.length() ; i++) {
			//用charAt方法对s中的字母进行一一赋值
				list.add(s.charAt(i)) ;
			}
		}
		
		while(true) {
			//当size==1的时候就可以进行删除了
			if(list.size()==1) {
				System.out.print(list.get(0));
				break ;
			}
			//因为我们已经知道了i为奇数，所以只需要满足i=i+2即可
			for(int i = 0 ; i<list.size() ;i=i+2) {
				//因为list集合删除元素的过程中会导致位置的改变，所以最好的方法是先标记，再删除
				list.set(i, '0') ;
			}
			//将list集合中标志位0的元素全部删除,这个就要一个一个来进行删除了，而不能使用i+2的方式，因为元素位置的改变，i+2会漏掉0
			for(int i = 0 ; i<list.size() ; i++) {
				if (list.get(i)=='0') list.remove(i);
			}
		}
		
	}

}
