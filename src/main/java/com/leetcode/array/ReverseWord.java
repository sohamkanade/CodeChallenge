package com.leetcode.array;

public class ReverseWord {
	public void reverseWords(char[] s) {
		if(s.length == 0) return;
		reverse(s, 0, s.length-1);
		int last = 0;
		for(int i=0; i <s.length; i++) {
			if(s[i] == ' ') {
				reverse(s, last, i-1);
				last = i+1;
			}
		}
		if(last < s.length - 1) {
			reverse(s, last, s.length-1);
		}
		System.out.println(s);
	}

	public void reverse(char[] s, int l, int r) {
		while(l <= r) {
			char temp = s[l];
			s[l] = s[r];
			s[r] = temp;
			l++;
			r--;
		}
	}

	public static void main(String[] args) {
		ReverseWord rw = new ReverseWord();
		rw.reverseWords("the sky is blue".toCharArray());
	}
}
