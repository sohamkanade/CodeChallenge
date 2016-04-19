package com.aws.session1;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSerialization {

	Queue<Integer> queue = new LinkedList<>();

	public void serialization(BinaryTreeNode node) {
		if(null == node) {
			queue.add(null);
			return;
		}
		queue.add(node.value);
		serialization(node.left);
		serialization(node.right);
	}

	public BinaryTreeNode deserialization() {
		Integer value = queue.poll();
		if(null != value) {
			BinaryTreeNode child = new BinaryTreeNode(value);
			child.left = deserialization();
			child.right = deserialization();
			return child;
		}
		return null;
	}
}
