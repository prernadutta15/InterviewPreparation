package com.practice.DynamicProgramming;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/target-sum/description/
 */

public class TargetSumHard {
	public int findTargetSumWays(int[] a, int target) {
        int sum=0,i,j,n=a.length;
        for(i=0;i<n;i++)sum+=a[i];
        if(sum-target<0 || (sum-target)%2!=0)
            return 0;
        int k=(sum-target)/2;
        int dp[][] = new int[n][k+1];
        for(i=0;i<n;i++)
        {
            for(j=0;j<=k;j++)dp[i][j]=-1;
        }
        return f(a, a.length-1, k, dp);
    }
    int f(int a[], int n, int k, int dp[][])
    {
        // if(k==0)return 1;
        if(n==0)
        {
            if(k==0 && a[n]==k)return 2;
            if(k==0 || a[n]==k)return 1;
            return 0;
        }
        if(dp[n][k]!=-1)return dp[n][k];
        int notPick = f(a, n-1, k, dp);
        int pick=0;
        if(k>=a[n])
            pick = f(a, n-1, k-a[n], dp);
        dp[n][k]=notPick+pick;
        return dp[n][k];
    }
}
