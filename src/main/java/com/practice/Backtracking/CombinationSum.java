package com.practice.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/combination-sum/description/
 */

/**
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 *
 */
public class CombinationSum {

	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> ans = new ArrayList<>();
	        List<Integer> out = new ArrayList<>();
	        findCombinationSum(candidates, target, candidates.length-1, candidates.length, out, ans);
	        return ans;
	    }
	    void findCombinationSum(int a[], int k, int i, int n, List<Integer> out, List<List<Integer>> ans)
	    {
	        if(i<0)
	        {
	            if(k==0)
	                ans.add(new ArrayList<>(out));
	            return;
	        }
	        

	        //pick
	        if(a[i]<=k)
	        {
	            out.add(a[i]);
	            findCombinationSum(a,k-a[i],i,n,out,ans);
	            out.remove(out.size()-1);
	        }
	        
	        //not pick
	        findCombinationSum(a,k,i-1,n,out,ans);
	    }
}
