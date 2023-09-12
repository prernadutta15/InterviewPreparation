package com.practice.Trees;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 */
public class MaxPathSum {

	int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        f(root);
        return max;
    }
    int f(TreeNode root)
    {
        if(root==null)return 0;
        int left = Math.max(0,f(root.left));
        int right = Math.max(0,f(root.right));
        max = Math.max(max, root.val+left+right);
        return Math.max(left, right)+root.val;
    }
}
