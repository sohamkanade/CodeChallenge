package com.leetcode.linkedlist;

public class ReverseInteger {

	public int reverse(int x) {  
		int reverse = 0, remain = 0;
		while(x != 0)  
		{
			remain = x%10;
			reverse = reverse*10 + remain;
			x = x/10;
		}
		return reverse;
	}

//	public int reverse(int x) {
//		int sign = 1;
//		if(x < 0) {
//			sign = -1;
//		}
//		x = sign*x;
//		List<Integer> list = new LinkedList<>();
//		do {
//			list.add(x %10);
//			x = x/10;
//		} while(x > 0);
//
//		for(int i =0; i <list.size(); i++) {
//			x= x*10 + list.get(i);
//		}
//		return sign *x;
//	}

	public static void main(String[] args) {
		ReverseInteger RI = new ReverseInteger();
		System.out.println( RI.reverse(1534236469) );
	}
}
