package com.practice.LinkedLists;

import com.practice.DynamicProgramming.UniqueBSTsII.TreeNode;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLL {

	public void flatten(TreeNode root) {
        TreeNode prev[] = new TreeNode[1];
        preorder(root, prev);
    }
    void preorder(TreeNode cur, TreeNode[] prev)
    {
        if(cur==null)return;
        if(prev[0]!=null)
        {
            prev[0].left = null;
            prev[0].right = cur;
        }
        TreeNode r = cur.right;
        prev[0] = cur;
        preorder(cur.left, prev);
        preorder(r, prev);
    }
}
