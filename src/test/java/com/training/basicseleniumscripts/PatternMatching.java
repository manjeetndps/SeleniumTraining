package com.training.basicseleniumscripts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatching {

	public static void main(String[] args) {

		int count = 0;
		String str = " abcd 1234567890 pqr 54897 kak 655464 gvs 54415435 dgag 435355";

		//String str1 = " abcsdfgsdfgdgdfgabcghkjljglhjgabctryrrtabctertuerabc";
		Pattern p = Pattern.compile("(\\d+)");
		Matcher m = p.matcher(str);
		while (m.find()) {
			count++;
			System.out.println(m.group());
		}
		System.out.println(count);
	}

}
