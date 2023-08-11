package com.practice.DynamicProgramming;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/minimum-falling-path-sum/description/
 */
public class MinFallingPathSum {

	//best TC : O(n*n) SC: O(n)
	public int minFallingPathSum(int[][] a) {
        int n=a.length,i,j,first=Integer.MAX_VALUE, second=Integer.MAX_VALUE, third=Integer.MAX_VALUE, ans=Integer.MAX_VALUE;
        int prev[]=new int[n];
        for(j=0;j<n;j++)
            prev[j]=a[0][j];
        for(i=1;i<n;i++)
        {
            int cur[]=new int[n];
            
            for(j=0;j<n;j++)
            {
                first = Integer.MAX_VALUE;
                second=Integer.MAX_VALUE;
                third=Integer.MAX_VALUE;
                if(i>0 && j>0)
                first = prev[j-1];
                if(i>0)
                second = prev[j];
                if(i>0 && j<n-1)
                third = prev[j+1];
                
                cur[j]=a[i][j]+Math.min(first, Math.min(second, third));
            }
            for(j=0;j<n;j++)
                prev[j]=cur[j];
        }
        
        for(j=0;j<n;j++)
            ans = Math.min(ans, prev[j]);
        return ans;
        
    }
	
	public int minFallingPathSumWithoutSpaceOptimization(int[][] a) {
        int n=a.length,i,j,first=Integer.MAX_VALUE, second=Integer.MAX_VALUE, third=Integer.MAX_VALUE, ans=Integer.MAX_VALUE;
        int dp[][]=new int[n][n];
        for(j=0;j<n;j++)
            dp[0][j]=a[0][j];
        for(i=1;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                first=Integer.MAX_VALUE;
                second=Integer.MAX_VALUE;
                third=Integer.MAX_VALUE;
                if(i>0 && j>0)
                first = dp[i-1][j-1];
                if(i>0)
                second = dp[i-1][j];
                if(i>0 && j<n-1)
                third = dp[i-1][j+1];
                
                dp[i][j]=a[i][j]+Math.min(first, Math.min(second, third));
            }
        }
        
        for(j=0;j<n;j++)
            ans = Math.min(ans, dp[n-1][j]);
        return ans;
        
    }
}
