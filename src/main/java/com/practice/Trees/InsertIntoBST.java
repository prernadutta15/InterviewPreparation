package com.practice.Trees;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
 */
public class InsertIntoBST {

	public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode p = root, par = null;
        TreeNode newNode = new TreeNode(val, null, null);
        if(root==null)return newNode; //remember base edge
        while(p!=null)
        {
            par = p;
            if(val<p.val)
                p=p.left;
            else
                p=p.right;
        }
        if(val<par.val)
            par.left = newNode;
        else
            par.right = newNode;
        return root;
    }
}
