package com.practice.Trees;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/description/
 */
public class MaxSumBSTPostOrder {

	int maxValue = 0;
    class NodeInfo
    {
        Integer min;
        Integer max;
        int sum;
        Boolean isBST;

        NodeInfo()
        {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            sum = 0;
            isBST = true;
        }
    }
    public int maxSumBST(TreeNode root)
    {
        if(root == null)return 0;
        findMaxSumBST(root);
        return maxValue;
    }
    public NodeInfo findMaxSumBST(TreeNode root) {
        if(root == null)return new NodeInfo();
        
        NodeInfo left = findMaxSumBST(root.left);
        NodeInfo right = findMaxSumBST(root.right);

        NodeInfo cur = new NodeInfo();
        
        cur.min = Math.min(root.val, Math.min(left.min, right.min));
        cur.max = Math.max(root.val, Math.max(left.max, right.max));
        cur.isBST = (left.isBST && right.isBST && root.val>left.max && root.val<right.min);
        
        if(cur.isBST)
        {
            cur.sum =  left.sum + right.sum + root.val;
            maxValue = Math.max(cur.sum, maxValue);
        }
        else
             cur.sum = Math.max(left.sum,right.sum);
            
        return cur;
    }
}
