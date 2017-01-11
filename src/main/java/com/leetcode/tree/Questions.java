package com.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Questions {

	private TreeNode prev;

	/**
	 * Find height of tree
	 * @param node tree node
	 * @return height
	 */
	public int findHeight(TreeNode node) {
		if (node == null) {
			return -1;
		}

		int lefth = findHeight(node.left);
		int righth = findHeight(node.right);

		if (lefth > righth) {
			return lefth + 1;
		} else {
			return righth + 1;
		}
	}

	/**
	 * Check Tree is balanced or not, which means height difference is less than 2
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;

		if (getHeight(root) == -1)
			return false;

		return true;
	}

	public int getHeight(TreeNode root) {
		if (root == null)
			return 0;

		int left = getHeight(root.left);
		int right = getHeight(root.right);

		if (left == -1 || right == -1)
			return -1;

		if (Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}


	/**
	 * Check Tree is Binary Search Tree or not
	 * @param node tree node
	 * @return true if given node and below is binary search tree, otherwise false
	 */
	boolean isBST(TreeNode node)
	{
		// traverse the tree in inorder fashion and
		// keep a track of previous node
		if (node != null)
		{
			if (!isBST(node.left))
				return false;

			// allows only distinct values node
			if (prev != null && node.value <= prev.value )
				return false;
			prev = node;
			return isBST(node.right);
		}
		return true;
	}
	
	/**
	 * Check if a given array can represent Preorder Traversal of Tree /// not Binary Search Tree

   6
 8    9
4 1   n  7
nn nn    nn

6 8 4 nn 1 nn 9 n 7 nn 

4 nn -> n
1 nn -> n
7 nn -> n
6 8 n n 9 n n  

8 nn -> n 
9 nn -> n

6 nn -> n

so turn into n
	 */
	public static boolean isPreorderResult(List<Integer> result) {
		do {
			List<Integer> temp = new ArrayList<>();
			for(int i = 0; i < result.size() -2 ; i++) {
				if(result.get(i+1) ==null && result.get(i+2) == null) {
					temp.add(null);
					i+=2;
				} else {
					temp.add(result.get(i));
				}
			}
			System.out.println(temp);
			result = temp;
			if(result.size() == 1) {
				return true;
			}
		} while(result.contains(null));
		return false;
	}

	public static void main(String[] args) {
		boolean result = isPreorderResult(Arrays.asList(new Integer[]{6, 8, 4, null, null, 1, null, null, 9, null, 7, null, null }));
		System.out.println(result);
	}
}
