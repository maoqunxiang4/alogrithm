/*
 * 标题:猜年龄

小明带两个妹妹参加元宵灯会。别人问她们多大了,她们调皮地说:“我们俩的年龄之积是年龄之和的6倍"。小明又补充说:“她们可不是双胞胎,年龄差肯定也不超过8岁啊。”

请你写出:小明的较小的妹妹的年龄。

注意:只写一个人的年龄数字,请通过浏览器提交答案。不要书写任何多余的内容。
 */

package com.xiaomaotongzhi.test;

public class pro8 {
	public static void main(String[] args) {
		boolean flag  = false ;
		//先找小妹妹的
		for(int age1 = 1 ; age1<100 ; age1++ ) {
			//再找大妹妹的，大妹妹一定比小妹妹大，所以就从age1+1开始，且age2满足age2<age1+8
			for(int age2 = age1+1 ; age2<age1+8 ; age2++) {
				if(age1*age2 == (age1+age2)*6) {
					System.out.println(age1 + " " + age2) ;
					flag = true ;
					break ;
				}
			}
			if(flag) break ;
		}
	}
}
