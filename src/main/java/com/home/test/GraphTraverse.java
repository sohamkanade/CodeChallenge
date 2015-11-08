package com.home.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * http://www.cs.cornell.edu/courses/cs2112/2012sp/lectures/lec24/lec24-12sp.html
 * @author spark
 *
 */
public class GraphTraverse {
	class Node {
		public Node(String value) {
			this.value = value;
		}
		String value;
		boolean isVisited = false;
		List<Node> nodes = new ArrayList<>();
	}

	public void DFS(Node node) {
		if(!node.isVisited ) {
			node.isVisited = true;
			System.out.println(node.value);
			node.nodes.forEach(this::DFS);
		}
	}

	public void BFS(Node start) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(start);
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(!node.isVisited) {
				node.isVisited = true;
				System.out.println(node.value);
				node.nodes.forEach(cnode -> {
					if(!cnode.isVisited) {
						queue.add(cnode);
					}
				});
			}
		}
	}

	public Node prepareGraph() {
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");

		A.nodes.add(B);
		A.nodes.add(D);
		A.nodes.add(E);
		B.nodes.add(C);
		B.nodes.add(D);
		D.nodes.add(C);
		D.nodes.add(A);
		D.nodes.add(E);
		return A;
	}

	public static void main(String[] args) {
		GraphTraverse gt = new GraphTraverse();

		System.out.println("\nDFS - recursion");
		gt.DFS(gt.prepareGraph());

		System.out.println("\nBFS - queue");
		gt.BFS(gt.prepareGraph());
	}
}
