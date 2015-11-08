package com.ensighten;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraverse {
	private Queue<Node> queue = new LinkedList<Node>();

	class Node {
		public Node(Integer value) {
			this.value = value;
		}
		Integer value;
		Node left;
		Node right;
	}

	public void traverse(Node head) {
		StringBuilder sb = new StringBuilder();
		int currentLevel = 1;
		int nextLevel = 0;
		queue.add(head);
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			sb.append(node.value).append(" ");
			currentLevel--;
			if(null != node.left) {
				queue.add(node.left);
				nextLevel++;
			}
			if(null != node.right) {
				queue.add(node.right);
				nextLevel++;
			}
			if(0 == currentLevel) {
				sb.append("\n");
				currentLevel = nextLevel;
			}
		}
		System.out.println(sb.toString());
	}

	public Node prepare() {
		Node n3 = new Node(3);
		Node n9 = new Node(9);
		Node n20 = new Node(20);
		Node n15 = new Node(15);
		Node n7 = new Node(7);
		n20.left = n15;
		n20.right = n7;
		n3.left = n9;
		n3.right = n20;
		return n3;
	}

	public static void main(String[] args) {
		LevelOrderTraverse lot = new LevelOrderTraverse();
		Node head = lot.prepare();
		lot.traverse(head);
	}
}
