package com.practice.Trees;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/path-sum/
 */
public class PathSum {

	public boolean hasPathSum(TreeNode root, int k) {
        if(root==null)return false;
        if(root.left ==null && root.right ==null)
        {
            if(root.val==k)return true;
        }
        boolean left = hasPathSum(root.left, k-root.val);
        boolean right = hasPathSum(root.right, k-root.val);
        return left || right;
        
    }
}
