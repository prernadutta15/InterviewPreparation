package com.practice.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/subsets/description/
 */
/**
 * 
 * @Page: 41
 *
 */
public class Subsets {

	public List<List<Integer>> subsets(int[] nums) 
	{
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        findSubsets(nums, 0, nums.length, out, ans);
        return ans;
	}
	
	//Beats 100.00% of users with Java
	void findSubsets(int a[], int i, int n, List<Integer> out, List<List<Integer>> ans)
    {
        if(i==n)
        {
            ans.add(new ArrayList<>(out));
            return;
        }
        out.add(a[i]);
        findSubsets(a,i+1,n,out,ans);
        out.remove(out.size()-1);
        findSubsets(a,i+1,n,out,ans);
    }
	
	//Beats	71.80%
	void f(int a[], int i, int n, List<Integer> out, List<List<Integer>> ans)
    {
        ans.add(new ArrayList<>(out));
        
        for(int j=i;j<n;j++)
        {
            out.add(a[j]);
            f(a,j+1,n,out,ans);
            out.remove(out.size()-1);
        }
    }

}
