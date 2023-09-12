package com.practice.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

import com.practice.DynamicProgramming.UniqueBSTsII.TreeNode;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/all-possible-full-binary-trees/description/
 */
public class AllPossibleFullBinaryTrees {

	 List<List<TreeNode>> mp = new ArrayList<>();
	    
	    public List<TreeNode> solve(int n) {
	    	
	        if (n % 2 == 0) {
	            return new ArrayList<>();
	        }
	        
	        if (n == 1) {
	            TreeNode root = new TreeNode(0);
	            List<TreeNode> singleNodeList = new ArrayList<>();
	            singleNodeList.add(root);
	            return singleNodeList;
	        }
	        
	        if (!mp.get(n).isEmpty()) {
	            return mp.get(n);
	        }
	        
	        List<TreeNode> result = new ArrayList<>();
	        for (int i = 1; i < n; i += 2) {
	            List<TreeNode> leftAllFBT = solve(i);
	            List<TreeNode> rightAllFBT = solve(n - i - 1);
	            
	            for (TreeNode l : leftAllFBT) {
	                for (TreeNode r : rightAllFBT) {
	                    TreeNode root = new TreeNode(0);
	                    root.left = l;
	                    root.right = r;
	                    result.add(root);
	                }
	            }
	        }
	        
	        mp.set(n, result);
	        return result;
	    }
	    
	    public List<TreeNode> allPossibleFBT(int n) {
	        for (int i = 0; i < 21; i++) {
	            mp.add(new ArrayList<>());
	        }
	        return solve(n);
	    }
}
