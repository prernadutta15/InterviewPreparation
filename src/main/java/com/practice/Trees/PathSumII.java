package com.practice.Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSumII {

	 public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
	        List<List<Integer>> ans = new ArrayList<>();
	        List<Integer> list = new ArrayList<>();
	        pathSum(root, targetSum, ans, list);
	        return ans;
	    }
	    void pathSum(TreeNode root, int k, List<List<Integer>> ans, List<Integer> list)
	    {
	        if(root==null)return;
	        if(root.left ==null && root.right ==null)
	        {
	            if(root.val==k){
	                List<Integer> temp = new ArrayList<>(list);
	                temp.add(root.val);
	                ans.add(temp);
	            }
	            return;
	        }
	        list.add(root.val);
	        pathSum(root.left, k-root.val,ans,list);
	        pathSum(root.right, k-root.val,ans,list);
	        list.remove(list.size()-1);
	    }
}
