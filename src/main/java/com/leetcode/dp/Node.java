package com.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class Node {
	String value;
	List<Node> children = new ArrayList<>();
	public Node(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}

	public List<Node> getChildren(){
		return children;
	}

}