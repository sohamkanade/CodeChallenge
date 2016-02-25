package com.leetcode.bit;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {

	/**
	 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
	 * 0000 -> ****
	 * 0001 -> ***1
	 * 0010 -> **1*
	 * 0011 -> **2
	 * 0100 -> *1**
	 * 0101 -> *1*1
	 * 0110 -> *2*
	 * 0111 -> *3
	 * 1000 -> 1***
	 * 1001 -> 1**1
	 * 1010 -> 1*1*
	 * 1011 -> 1*2
	 * 1100 -> 2**
	 * 1101 -> 2*1
	 * 1110 -> 3*
	 * 1111 -> 4
	 * 
	 * 
	 * 
	 * 
4
3d
2r1
2rd
1o2
1o1d
1or1
1ord
w3
w2d
w1r1
w1rd
wo2
wo1d
wor1
word
	 */

	public List<String> generateAbbreviations(String word) {
		List<String> res = new ArrayList<>();
		dfs(res, new StringBuilder(), word.toCharArray(), 0, 0);
		return res;
	}

	public void dfs(List<String> res, StringBuilder sb, char[] c, int i, int num) {
		int len = sb.length();
		if(i == c.length) {
			if(num != 0) { 
				sb.append(num);
			}
			System.out.println(sb.toString());
			res.add(sb.toString());
		} else {
			dfs(res, sb, c, i + 1, num + 1);				// abbr c[i]

			if(num != 0) {									// not abbr c[i
				sb.append(num);
			}
			dfs(res, sb.append(c[i]), c, i + 1, 0);
		}
		sb.setLength(len); 
	}

	public static void main(String[] args) {
		GeneralizedAbbreviation ga = new GeneralizedAbbreviation();
		List<String> res = ga.generateAbbreviations("word");
		res.stream().forEach(System.out::println);
	}
}
