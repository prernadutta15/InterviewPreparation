package com.practice.DynamicProgramming;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/2-keys-keyboard/description/
 */

/*
 * Page: 289
 */
public class TwoKeysKeyBoardHard {

	public int minSteps(int n) {
        int dp[]=new int[n+1];
        for(int i=0;i<=n;i++)
            dp[i]=Integer.MAX_VALUE;
        f(n,dp);
        return dp[n];
    }
    public int f(int n, int dp[])
    {
        if(n==0 || n==1)
            return dp[n]=0;
        if(n==2)
            return dp[n]=2;
        if(dp[n]!=Integer.MAX_VALUE)
            return dp[n];
        dp[n] = n;
        for(int i=n/2;i>=1;i--)
        {
            if(n%i==0)
            {
                dp[n] = Math.min(dp[n],n/i + f(i, dp));
            }
        }
        return dp[n];
    }
}
