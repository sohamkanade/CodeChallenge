package com.leetcode.tree;

/**
 * Find longest consecutive sequence which is all the time parent -> child
 * @author spark
 *
 */
public class ConsecutiveSequence {
	public int longestConsecutive(TreeNode root) {
		return dfs(root, null, 0);
	}

	private int dfs(TreeNode p, TreeNode parent, int length) {
		if(p == null) return length;
		length = (parent != null && p.value == parent.value + 1 ) ? length + 1 : 1;
		return Math.max(length, Math.max(dfs(p.left, p, length), dfs(p.right, p, length)));
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);

		t1.right = t3;
		t3.left = t2;
		t3.right = t4;
		t4.right = t5;
		//      1
		//       \
		//        3
		//       /  \
		//      2    4
		//            \
		//             5

		// longest 3 -> 4 -> 5, so it should be 3
		ConsecutiveSequence cs = new ConsecutiveSequence();
		System.out.println( cs.longestConsecutive(t1) );
	}
}
