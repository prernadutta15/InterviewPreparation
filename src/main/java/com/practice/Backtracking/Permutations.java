package com.practice.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/permutations/description/
 */

/*
 * Page: 43
 */
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        permutation(nums, nums.length, 0, output);
        return output;
    }
    public void permutation(int a[], int n, int i, List<List<Integer>> output)
    {
        if(i==n)
        {
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++)
                list.add(a[j]);
            output.add(list);
            return;
        }
        for(int j=i;j<n;j++)
        {
            a[i]=(a[i]+a[j])-(a[j]=a[i]);
            permutation(a,n,i+1, output);
            a[i]=(a[i]+a[j])-(a[j]=a[i]);
        }
    }
}
