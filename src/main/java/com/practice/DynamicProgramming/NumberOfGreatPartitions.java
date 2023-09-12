package com.practice.DynamicProgramming;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/number-of-great-partitions/description/
 */
public class NumberOfGreatPartitions {

	int mod = (int)Math.pow(10,9)+7;
    public int countPartitions(int[] nums, int k) {
        int i,n=nums.length;
        long sum=0;
        for(i=0;i<n;i++)
            sum+=nums[i];
        return f(0, nums, n, 0, sum, k);
    }
    int f(int i, int a[], int n, long sum, long total, int k)
    {
        if(i==n)
        {
            if(sum>=k && ((int)(total-sum))>=k)
            return 1;
            else
            return 0;
        }
        //pick
        int pick = f(i+1, a, n, sum+a[i], total, k);
        //not pick
        int notPick = f(i+1, a, n, sum, total, k);
        return (pick%mod + notPick%mod)%mod;
    }
	
}
