package com.practice.DynamicProgrammingRevision.Phase1;

/*
 * https://leetcode.com/problems/unique-paths/description/
 */
public class Q7GridUniquePattern {

	public int uniquePathsTopDown(int m, int n) {
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
    
    public int uniquePathsBottomUp(int m, int n) {
        int dp[][] = new int[m][n];
        int i,j,left=0,right=0;
        dp[0][0]=1;
        for(i=0;i<m;i++)
            dp[i][0]=1;
        for(i=0;i<n;i++)
            dp[0][i]=1;
        for(i=1;i<m;i++)
        {
            left=0;
            right=0;
            for(j=1;j<n;j++)
            {
                left = dp[i-1][j];
                right = dp[i][j-1];
                dp[i][j]=left+right;
            }
        }
        return dp[m-1][n-1];
    }
    
    public int uniquePathsBottomUpSpaceOptimized(int m, int n) {
        int prev[] = new int[n];
        int i,j,left=0,right=0;
        
        for(i=0;i<m;i++)
        {
            int cur[]=new int[n];
            
            for(j=0;j<n;j++)
            {
                left=0;
                right=0;
                if(i==0 && j==0)cur[j]=1;
                else
                {
                    if(i>0)left=prev[j];
                    if(j>0)right = cur[j-1];
                    cur[j]=left+right;
                }
            }
            for(j=0;j<n;j++)
                prev[j]=cur[j];
        }
        return prev[n-1];
    }
}
