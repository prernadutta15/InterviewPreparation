package com.practice.DynamicProgramming;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/unique-paths-ii/description/
 */
public class UniquePathII {
	//way 1: top down
	public int uniquePathsWithObstacles(int[][] a) {
        int m=a.length,n=a[0].length;
        int dp[][] = new int[m][n];
        int i,j;
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
                dp[i][j]=-1;
        }
        return f(a,m-1,n-1,dp);
        
    }
    
    int f(int a[][],int m, int n, int dp[][])
    {
        if(m<0 || n<0 || a[m][n]==1)return 0;
        if(m==0 && n==0)return 1;
        if(dp[m][n]!=-1)return dp[m][n];
        
        int left  = f(a,m-1,n, dp);
        int right = f(a,m, n-1, dp);
        return dp[m][n]=left+right;
    }
    
    //bottom up
    public int uniquePathsWithObstaclesBottomUp(int[][] a) {
        int m=a.length,n=a[0].length;
        int dp[][] = new int[m][n];
        int i,j;
        if(a[0][0]==1||a[m-1][n-1]==1)
            return 0;
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(i==0 && j==0)dp[i][j]=1;
                else if(a[i][j]==1)
                    dp[i][j]=0;
                else
                {
                    int up=0;
                    int left=0;
                    if(i>0)
                    up=dp[i-1][j];
                    if(j>0)
                    left=dp[i][j-1];
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[m-1][n-1];
        
    }
    
    //bottom up 1D array
    public int uniquePathsWithObstacles1D(int[][] a) {
        int m=a.length,n=a[0].length;
        int prev[] = new int[n];
        int i,j;
        if(a[0][0]==1||a[m-1][n-1]==1)
            return 0;
        for(i=0;i<m;i++)
        {
            int cur[]=new int[n];
            for(j=0;j<n;j++)
            {
                if(i==0 && j==0)cur[j]=1;
                else if(a[i][j]==1)
                    cur[j]=0;
                else
                {
                    int up=0;
                    int left=0;
                    if(i>0)
                    up=prev[j];
                    if(j>0)
                    left=cur[j-1];
                    cur[j]=up+left;
                }
            }
            for(j=0;j<n;j++)
                prev[j]=cur[j];
        }
        return prev[n-1];
        
    }
}
