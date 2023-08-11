package com.practice.DynamicProgramming;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/unique-paths/description/
 */
public class UniquePaths {

	public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        int i,j;
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
                dp[i][j]=-1;
        }
        return f(m-1,n-1,dp);
    }
    int f(int m, int n, int dp[][])
    {
        if(m==0 && n==0)return 1;
        if(m<0 || n<0)return 0;
        if(dp[m][n]!=-1)return dp[m][n];
        int left  = f(m-1,n, dp);
        int right = f(m, n-1, dp);
        return dp[m][n]=left+right;
    }
}
