package com.leetcode.questions;

public class MergeLists {

	public class Node {
		public int val;
		public Node next;
		public Node(int val) {
			this.val = val;
		}
	}

	public Node merge(Node l1, Node l2) {
		Node p = new Node(0);
		Node head = p;
		while(l1 != null && l2 != null) {
			if(l1.val <l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if(l1 != null) p.next = l1;
		if(l2 != null) p.next = l2;
		return head.next;
	}

	public void run() {
		Node n3 = new Node(3);
		Node n6 = new Node(6);
		Node n9 = new Node(9);
		n6.next = n9;
		n3.next = n6;

		Node n2 = new Node(2);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		n7.next = n8;
		n2.next = n7;

		Node sorted = merge(n3, n2);
		while(sorted != null) {
			System.out.print(" " + sorted.val);
			sorted = sorted.next;
		}
	}

	public static void main(String[] args) {
		MergeLists ml = new MergeLists();
		ml.run();
	}
}
