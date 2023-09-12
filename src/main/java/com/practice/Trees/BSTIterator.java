package com.practice.Trees;

import java.util.Stack;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 */
public class BSTIterator {

	Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAll(root);
    }
    
    public void pushAll(TreeNode root)
    {
        while(root!=null)
        {
            stack.push(root);
            root=root.left;
        }
    }
    public int next() {
        if(stack.isEmpty())return Integer.MIN_VALUE;
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
