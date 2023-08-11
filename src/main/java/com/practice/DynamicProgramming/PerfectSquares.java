package com.practice.DynamicProgramming;

import java.util.Arrays;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/perfect-squares/description/
 */
public class PerfectSquares {

	public int numSquares(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return f(n, dp);
    }
    int f(int n, int dp[])
    {
        if(n==0)return 0;
        if(dp[n]!=-1)return dp[n];
        int min = Integer.MAX_VALUE;
        for(int x=1;x*x<=n;x++)
            min = Math.min(f(n-x*x,dp),min);
        dp[n]=1+min;
        return dp[n];
    }
}
