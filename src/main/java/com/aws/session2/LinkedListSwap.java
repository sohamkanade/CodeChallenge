package com.aws.session2;

/**
 * swap kth node from beginning with kth node from end
 * @author spark
 *
 */
public class LinkedListSwap {

	LinkedListNode nodeKthFromBegin;
	LinkedListNode nodeKthFromEnd;

	public void findKthNodeFromBeginAndEnd(LinkedListNode node, Integer k) {
		// actually we need to find k-1th node from beginning and end
		// because of making connection
		int index = 1;
		while((node = node.next) != null ) {
			if(index == k-1) {
				nodeKthFromBegin = node;
			}
			LinkedListNode temp = node;
			for(int i = 1; i <= k + 1; i++) {
				temp = temp.next;
			}
			if(null == temp) {
				nodeKthFromEnd = node;
			}
			index++;
		}
	}
	// 1-2-3-4-5-6-7-null
	// k = 2 , so 2 and 6
	// but actually we persist 1 and 5
	public void swapNodes() {
		LinkedListNode next1 = nodeKthFromBegin.next.next; // 3
		LinkedListNode next2 = nodeKthFromEnd.next.next; // 7
		LinkedListNode temp = nodeKthFromBegin.next;
		nodeKthFromBegin.next = nodeKthFromEnd.next;
		nodeKthFromBegin.next.next = next1;
		nodeKthFromEnd.next = temp;
		nodeKthFromEnd.next.next = next2;
	}
}
