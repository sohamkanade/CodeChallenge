package com.leetcode.questions;

public class BinarySearchTree {

	public class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value = value;
		}
	}

	public class TreeNode {
		public int value;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int value) {
			this.value = value;
		}
	}

	private ListNode list;

	public TreeNode sortedListToBST(int start, int end) {
		if(start>end) {
			return null;
		}
		int mid = (start + end)/2;
		TreeNode leftChildren = sortedListToBST(start, mid - 1);
		TreeNode parent = new TreeNode(list.value);
		parent.left = leftChildren;
		list = list.next;
		parent.right = sortedListToBST(mid + 1, end);
		return parent;
	}

	public TreeNode sortedListToBST(ListNode head) {
		int n = 0;
		ListNode p = head;
		while(p != null) {
			p = p.next;
			n++;
		}
		list = head;
		return sortedListToBST(0, n-1);
	}
}
