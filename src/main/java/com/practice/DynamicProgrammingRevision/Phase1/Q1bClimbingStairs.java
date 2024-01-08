package com.practice.DynamicProgrammingRevision.Phase1;

/*
 * https://leetcode.com/problems/climbing-stairs/
 */
public class Q1bClimbingStairs {

	public int climbingStairsRecursive(int n) {
		if(n<3)return n;
        return climbingStairsRecursive(n-1)+climbingStairsRecursive(n-2);
    }
	
	public int climbingStairsTopDown(int n) {
        int dp[]=new int[n+1];
        for(int i=0;i<=n;i++)
            dp[i]=-1;
        return f(n,dp);
    }
    public int f(int n, int dp[])
    {
    	if(n<=2)return n;
        if(dp[n]!=-1)return dp[n];
         dp[n]=f(n-1, dp)+f(n-2, dp);
        return dp[n];
    }
	
    public int climbingStairsBottomUp(int n) {
        if(n<=2)return n;
        int dp[]=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++)
            dp[i]=dp[i-1]+dp[i-2];
        return dp[n];
    }
    
    public int climbingStairsBottomUpOptimized(int n) {
        if(n<2)return n;
        int prev2=0,prev1=1;
        for(int i=2;i<=n;i++)
        {
            int cur=prev2+prev1;
            prev2=prev1;
            prev1=cur;
        }
        return prev1;
    }
}
