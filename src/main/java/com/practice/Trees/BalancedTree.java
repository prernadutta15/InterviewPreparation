package com.practice.Trees;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/balanced-binary-tree/description/
 */
public class BalancedTree {

	public boolean isBalanced(TreeNode root) {
        int h = height(root);
        if(h==-1)return false;
        return true;
    }
    int height(TreeNode root)
    {
        if(root==null)return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        if(Math.abs(lh-rh)>1)return -1;
        if(lh==-1 || rh==-1)return -1;
        return 1+Math.max(lh,rh);
    }
}
