package com.practice.Trees;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 */
public class ConvertSortedArrayToBST {

	public TreeNode sortedArrayToBST(int[] a) {
        return makeTree(a, 0, a.length - 1);
    }
    TreeNode makeTree(int a[], int start, int end)
    {
        if(start>end)return null;
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(a[mid]);
        root.left = makeTree(a, start, mid - 1);
        root.right = makeTree(a, mid+1, end);
        return root;
    }
	
}
