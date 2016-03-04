package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LargestBST {
	
	TreeNode largestBST;
	TreeNode child;

	public int findLargestBST(TreeNode p,
							int min,
							int max,
							int maxNodes) {
		if(null == p) {
			return 0;
		}
		if(min < p.value && max > p.value) {
			int leftNodes = findLargestBST(p.left, min, p.value, maxNodes);
			TreeNode leftChild = (0 == leftNodes) ? null : child;
			int rightNodes = findLargestBST(p.right, p.value, max, maxNodes);
			TreeNode rightChild = ( 0 == rightNodes) ? null : child;

			// create a copy of the current node and assign its left and right child
			TreeNode parent = new TreeNode(p.value);
			parent.left = leftChild;
			parent.right = rightChild;

			// pass the parent as the child to the above tree
			child = parent;
			int totalNodes = leftNodes + rightNodes + 1;
			if(totalNodes > maxNodes) {
				maxNodes = totalNodes;
				largestBST = parent;
			}
			return totalNodes;
		}
		// include this node breaks the BST constraint
		// so treat this node as an entirely new tree and
		// check if a larger BST exist in this tree
		findLargestBST(p, Integer.MIN_VALUE, Integer.MAX_VALUE, maxNodes);
		// must return 0 to exclude this node
		return 0;
	}

	public TreeNode findLargestBST(TreeNode root) {
		largestBST = null;
		child = null;
		int maxNodes = Integer.MIN_VALUE;
		findLargestBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE, maxNodes);
		return largestBST;
	}

	/*         ___________________15___________________
              /                                        \ 
  ___________10___________                             20
 /                        \ 
 5                   _____7____
                    /          \
                  __2__       __5
                 /     \     / 
                 0      8    3 

	 */
	public TreeNode preparingTree() {
		TreeNode n15 = new TreeNode(15);
		TreeNode n10 = new TreeNode(10);
		TreeNode n20 = new TreeNode(20);
		TreeNode n5_1 = new TreeNode(5);
		TreeNode n7 = new TreeNode(7);
		TreeNode n2 = new TreeNode(2);
		TreeNode n5_2 = new TreeNode(5);
		TreeNode n0 = new TreeNode(0);
		TreeNode n8 = new TreeNode(8);
		TreeNode n3 = new TreeNode(3);
		n5_2.left = n3;
		n2.left = n0;
		n2.right = n8;
		n7.left = n2;
		n7.right = n5_2;
		n10.left = n5_1;
		n10.right = n7;
		n15.left = n10;
		n15.right = n20;
		return n15;
	}


	public void printTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int current_level = 1;
		int next_level = 0;
		while(!queue.isEmpty()) {
			TreeNode n = queue.poll();
			System.out.print(" "+n.value);
			current_level--;

			if(null != n.left) {
				queue.add(n.left);
				next_level++;
			}
			if(null != n.right) {
				queue.add(n.right);
				next_level++;
			}

			if(0 == current_level) {
				System.out.println();
				current_level = next_level;
				next_level = 0;
			}
		}
	}

	public static void main(String[] args) {
		LargestBST l = new LargestBST();
		TreeNode t = l.findLargestBST(l.preparingTree());

		if(null != t) {
		// print out
			l.printTree(t);
		} else {
			System.out.println("fail to find any BST");
		}
	}
}