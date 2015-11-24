package com.leetcode.linkedlist;

public class ReverseList {

	/**
	 * Iterative way
	 * @param head
	 * @return
	 */
	public ListNode reverseListIter(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}

	/**
	 * Recursive way
	 * @param head
	 * @return
	 */
	public ListNode reverseListRecur(ListNode node) {
		if(node == null || node.next == null) return node;
		ListNode p = reverseListRecur(node.next);
		node.next.next = node;
		node.next = null;
		return p;
	}

	public static void main (String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = null;

		ReverseList rl = new ReverseList();
		ListNode curr = rl.reverseListIter(n1);
		while(curr != null) {
			System.out.print(curr.getValue() + " ");
			curr = curr.next;
		}

		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		curr = rl.reverseListRecur(n1);
		while(curr != null) {
			System.out.print(curr.getValue() + " ");
			curr = curr.next;
		}
	}
	
}
