package com.practice.Greedy;

import java.util.Arrays;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/jump-game-ii/description/
 * 
 * Pg: 254
 */

/*
 * [2,3,1,1,4] -> ans = 2
 */
public class JumpGameII {
	
	//more intuitive DP approach
	public int jumpTopDown(int[] nums) {
        int dp[]=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return f(0, nums, nums.length, dp);
    }
    public int f(int i, int a[], int n, int dp[])
    {
        if(i==n-1)return 0;
        if(i>=n)return (int)10e7;
        if(dp[i]!=-1)return dp[i];
        int min = (int)10e7;
        int jumps = a[i];
        for(int j=1;j<=jumps;j++)
        {
            if(i+j<n)
                min = Math.min(min, 1+f(i+j, a, n, dp));
        }
        return dp[i]=min;
    }
	
    //bottom up approach
	public int jumpCount(int[] nums) {

	    int n = nums.length;
	    
	    int[] dp = new int[n + 1];
	    Arrays.fill(dp, Integer.MAX_VALUE);
	    dp[0] = 0;

	    for (int i = 1; i < n; i++) {
	        for (int j = 0; j < i; j++) {
	            if (j + nums[j] >= i) {
	                dp[i] = Math.min(dp[i], dp[j] + 1);
	            }
	        }
	    }
	    return dp[n - 1];

	}
	
	
	//best approach
	public int jump(int[] a) {
        int i,count=0,n=a.length;
        for(i=1;i<n;i++)
        {
            a[i]=Math.max(a[i-1],a[i]+i);
        }
        i=0;
        count=0;
        while(i<n-1)//note that it should be n-1 so that it stops running for the last time
        {
            i=a[i];
            count++;
        }
        return count;
    }
}
