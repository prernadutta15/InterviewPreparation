package com.practice.DynamicProgrammingRevision.Phase1;

/*
 * https://leetcode.com/problems/fibonacci-number/
 */
public class Q1aFibonacci {

	public int fibRecursive(int n) {
		if(n<=1)return n;
        return fibRecursive(n-1)+fibRecursive(n-2);
    }
	
	public int fibTopDown(int n) {
        int dp[]=new int[n+1];
        for(int i=0;i<=n;i++)
            dp[i]=-1;
        return f(n,dp);
    }
    public int f(int n, int dp[])
    {
    	if(n<=1)return n;
        if(dp[n]!=-1)return dp[n];
         dp[n]=f(n-1, dp)+f(n-2, dp);
        return dp[n];
    }
	
    public int fibBottomUp(int n) {
        if(n<2)return n;
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++)
            dp[i]=dp[i-1]+dp[i-2];
        return dp[n];
    }
    
    public int fibBottomUpOptimized(int n) {
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
