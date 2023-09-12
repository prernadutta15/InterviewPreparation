package com.practice.Trees;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/validate-binary-search-tree
 */
public class ValidateBST {

	 public boolean isValidBSTWay1(TreeNode root) {
	        boolean ans = findBST(root, null, null);
	        return ans;
	    }
	    boolean findBST(TreeNode root, Integer l, Integer r)
	    {
	        if(root==null)return true;
	        if((l!=null && root.val<= l) || (r!=null && root.val>= r))return false;
	        boolean left = findBST(root.left, l, root.val);
	        boolean right = findBST(root.right, root.val, r);
	        return left && right;
	    }
	    
	    public boolean isValidBSTWay2(TreeNode root) {
	        TreeNode prev[] = new TreeNode[1];
	        prev[0]=null;
	        return inorder(root, prev);
	    }
	    boolean inorder(TreeNode root, TreeNode[] prev)
	    {
	        if(root==null)return true;
	        boolean left = inorder(root.left, prev);
	        if(prev[0]!=null && prev[0].val>=root.val)
	            return false;
	        prev[0]=root;
	        boolean right = inorder(root.right, prev);
	        return left && right;
	    }
	    
	    class NodeInfo
	    {
	        TreeNode root;
	        long size,min,max;
	        boolean isBST;
	        NodeInfo()
	        {

	        }
	    }
	    NodeInfo postOrder(TreeNode root)
	    {
	        if(root==null)
	        {
	            NodeInfo info = new NodeInfo();
	            info.root = null;
	            info.min = Long.MAX_VALUE;
	            info.max = Long.MIN_VALUE;
	            info.size = 0;
	            info.isBST = true;
	            return info;
	        }
	        NodeInfo left = postOrder(root.left);
	        NodeInfo right = postOrder(root.right);
	        NodeInfo current = new NodeInfo();
	        current.isBST = (left.isBST && right.isBST && root.val>left.max && root.val<right.min)?true: false;
	        current.min = Math.min(root.val,Math.min(left.min,right.min));
	        current.max = Math.max(root.val,Math.max(left.max,right.max));
	        if(current.isBST)
	        {
	            current.root = root;
	            current.size = left.size + right.size;
	        }
	        else
	        {
	            if(left.size>right.size)
	            {
	                current.root = left.root;
	                current.size = left.size;
	            }
	            else
	            {
	                 current.root = right.root;
	                current.size = right.size;
	            }
	        }
	        return current;
	    }
	    public boolean isValidBSTWay3(TreeNode root) {
	        if(root==null)
	            return true;
	        if(root.left == null && root.right==null)
	            return true;
	        NodeInfo info = postOrder(root);
	        return info.isBST;
	    }
}
