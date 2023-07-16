package com.practice.Trees;

/**
 * 
 * @author prerna.dutta
 *
 */

public class IsSymmetric {

	public boolean isMirror(TreeNode leftTree, TreeNode rightTree) {
		if (leftTree == null && rightTree == null)
			return true;

		if (leftTree != null && rightTree != null && leftTree.val == rightTree.val) {

			boolean b1 = isMirror(leftTree.left, rightTree.right);
			boolean b2 = isMirror(leftTree.right, rightTree.left);
			return b1 && b2;
		}
		return false;
	}

	public boolean isSymmetric(TreeNode root) {
		return isMirror(root, root);
	}
}