package com.practice.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/subsets-ii/description/
 */

public class SubsetsII {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(nums, 0, nums.length, out, ans);
        return ans;
    }

    void findSubsets(int a[], int i, int n, List<Integer> out, List<List<Integer>> ans)
    {
        ans.add(new ArrayList<>(out));
        
        for(int j=i;j<n;j++)
        {
            if(j>i && a[j]==a[j-1])continue;
            out.add(a[j]);
            findSubsets(a,j+1,n,out,ans);
            out.remove(out.size()-1);
        }
    }
}
