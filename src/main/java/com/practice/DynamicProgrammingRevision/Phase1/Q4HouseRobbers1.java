package com.practice.DynamicProgrammingRevision.Phase1;

/*
 * https://leetcode.com/problems/house-robber/
 */
public class Q4HouseRobbers1 {

	public int robTopDown(int[] a) {
        int dp[]=new int[a.length];
        for(int i=0;i<a.length;i++)
            dp[i]=-1;
        return f(a, a.length-1, dp);
    }
    public int f(int a[], int n, int dp[])
    {
        if(n==0)return a[0];
        if(n==1)return Math.max(a[0],a[1]);
        if(dp[n]!=-1)return dp[n];
        dp[n] = Math.max(f(a,n-2,dp)+a[n], f(a,n-1,dp));
        return dp[n];
    }
    
    public int robBottomUp(int a[])
    {
    	int n = a.length;
    	int dp[]=new int[n];
    	if(n==1)return a[0];
    	if(n==2)return Math.max(a[0], a[1]);
    	dp[0] = a[0];
    	dp[1] = Math.max(a[0], a[1]);
    	for(int i=2;i<n;i++)
    	{
    		dp[i]=Math.max(dp[i-1], dp[i-2]+a[i]);
    	}
    	return dp[n-1];
    }
}
