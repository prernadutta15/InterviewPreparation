package com.practice.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 */
public class UniqueBSTsII {

	@Data
	public static class TreeNode
	{
		public int val;
		public TreeNode left,right;
		public TreeNode(int v)
		{
			val=v;
			left=right=null;
		}
	}
	@Data
	public static class Pair<A,B>
	{
		int start,end;
		Pair(int s, int e)
		{
			
		}
	}
	public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        Map<Pair<Integer, Integer>, List<TreeNode>> dp = new HashMap<>();
        return generateTreesHelper(1, n, dp);        
    }

    private List<TreeNode> generateTreesHelper(int start, int end, Map<Pair<Integer, Integer>, List<TreeNode>> dp) 
    {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        if(start == end)
        {
            result.add(new TreeNode(start));
            return result;
        }
        if (dp.containsKey(new Pair<Integer, Integer>(start, end))) {
            return dp.get(new Pair<>(start, end));
        }
        for(int i=start;i<=end;i++)
        {
            List<TreeNode> leftBST = generateTreesHelper(start,i-1, dp);
            List<TreeNode> rightBST = generateTreesHelper(i+1,end, dp);
            for(TreeNode left: leftBST)
            {
                for(TreeNode right: rightBST)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                    
                }
            }
        }
        dp.put(new Pair<>(start,end), result);
        return result;
    }
}
