package com.home.list;

public class FindNode {

	private int i = 0;
	private Node head;

	class Node {
		public Integer data;
		public Node next;

		public Node(Integer data) {
			this.data = data;
		}

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

	public void findNthFromLast(Node head, int n) {
		if(head == null) {
			return;
		}
		findNthFromLast(head.next, n);
		if(++i == n) {
			System.out.println("nth node data: " + head.data);
		}
	}

	public Node getHead() {
		return head;
	}

	public Node reverse(Node current) {
		if(null == current) return null;
		if(null == current.next) {
			head = current;
			return current;
		}

		Node rnode = reverse(current.next);
		current.next = null;
		rnode.next = current;
		return rnode.next;
	}

	public Node prepareNodes() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		node9.next = node10;
		node8.next = node9;
		node7.next = node8;
		node6.next = node7;
		node5.next = node6;
		node4.next = node5;
		node3.next = node4;
		node2.next = node3;
		node1.next = node2;
		return node1;
	}

	public static void main(String[] args) {
		FindNode fn = new FindNode();
		fn.findNthFromLast(fn.prepareNodes(), 4);
		fn.reverse(fn.prepareNodes());
		Node current = fn.getHead();
		do {
			System.out.print(current.getData().toString() + " ");
			current = current.next;
		} while(current != null);
		System.out.println();
	}
}
