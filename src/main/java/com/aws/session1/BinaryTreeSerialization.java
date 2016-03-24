package com.aws.session1;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeSerialization {

	List<Integer> list = new ArrayList<>();

	public void serialization(BinaryTreeNode node) {
		if(null == node) {
			return;
		}
		list.add(node.value);
		if(null == node.left) {
			list.add(null);
		} else {
			serialization(node.left);
		}
		if(null == node.right) {
			list.add(null);
		} else {
			serialization(node.right);
		}
	}

	public BinaryTreeNode deserialization() {
		Integer value = list.get(0);
		list.remove(0);
		if(null != value) {
			BinaryTreeNode child = new BinaryTreeNode(value);
			child.left = deserialization();
			child.right = deserialization();
			return child;
		}
		return null;
	}
}
