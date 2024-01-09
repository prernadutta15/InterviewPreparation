package com.practice.DynamicProgrammingRevision.Phase1;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/perfect-squares/
 */
public class Q6MinimumNumberOfSquares {

	public int numSquares(int n) {
        int dp[]=new int[n+1];
		Arrays.fill(dp, -1);
		return countTopDown(n, dp);
	}
	public int countTopDown(int n, int dp[])
	{
		if(n==0)return 0;
		int min=Integer.MAX_VALUE;
        if(dp[n]!=-1)return dp[n];
		for(int x=1;x*x<=n;x++)
			min = Math.min(min, countTopDown(n-x*x, dp));
		dp[n]=1+min;
		return dp[n];
	}
	
	public int numSquaresBottomUp(int n) {
        int dp[]=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++)
        {
            int min=Integer.MAX_VALUE;
            for(int x=1;x*x<=i;x++)
                min=Math.min(min, dp[i-x*x]);
            dp[i]=1+min;
        }
        return dp[n];
	}
}
