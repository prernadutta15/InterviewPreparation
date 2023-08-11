package com.practice.DynamicProgramming;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/coin-change/description/
 */
public class CoinChange {

	public int coinChange(int[] A, int B) {
        int dp[][]=new int[A.length+1][B+1];
        for(int i=0;i<=A.length;i++)
            for(int j=0;j<=B;j++)
                dp[i][j]=-1;
        int ans = calculate(A, A.length,B, dp);
        return ans==1000000?-1:ans;
    }
    int calculate(int A[],int n, int V, int dp[][])
    {
        if(V==0)return 0;
        if(n==0)return 1000000;
        if(dp[n][V]!=-1)
            return dp[n][V];
        int ans = Integer.MAX_VALUE;
        if(V>=A[n-1])
            ans = Math.min(1+calculate(A,n,V-A[n-1],dp),calculate(A,n-1,V,dp));
        else
            ans = calculate(A,n-1,V,dp);
        dp[n][V]=ans;
        return ans;
    }
}
