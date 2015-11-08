package com.home.test;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeLists {
	public class Node {
		int value;
		Node next;
		public Node(int value) {
			this.value = value;
		}
	}

	public Node merge(Node l1, Node l2) {
		Node p = new Node(0);
		Node head = p;
		while(l1 != null && l2 != null) {
			if(l1.value <l2.value) {
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

	public Node mergeKLists(List<Node> lists) {
		if(lists.isEmpty()) {
			return null;
		}
		Queue<Node> queue = new PriorityQueue<>(lists.size(), (Node x, Node y) -> x.value - y.value);
		lists.forEach(node -> {
			if(null != node) {
				queue.add(node);
			}
		});
		Node head = new Node(0);
		Node p = head;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			p.next = node;
			p = p.next;
			if(node.next != null) {
				queue.add(node.next);
			}
		}
		return head.next;
	}

	public Node mergeKLists2(List<Node> lists) {
		if(lists.isEmpty()) return null;
		int end = lists.size() - 1;
		while( end > 0 ) {
			int begin = 0;
			while(begin < end) {
				lists.set(begin, merge(lists.get(begin), lists.get(end)));
				begin++;
				end--;
			}
		}
		return lists.get(0);
	}
}
