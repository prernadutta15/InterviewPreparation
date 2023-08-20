package com.practice.DynamicProgramming;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/cherry-pickup-ii/description/
 */
public class CherryPickupII {

	public int cherryPickup(int[][] grid) {
        int dp[][][]=new int[grid.length][grid[0].length][grid[0].length];
        int i,j,k;
        for(i=0;i<grid.length;i++)
        {
            for(j=0;j<grid[0].length;j++)
            {
                for(k=0;k<grid[0].length;k++)
                    dp[i][j][k]=-1;
            }
        }
        return f(grid, 0, 0, grid[0].length-1,grid.length, grid[0].length, dp);
    }

    public int f(int a[][], int i, int j1, int j2, int n, int m, int dp[][][])
    {
        if(j1<0 || j1>=m || j2<0 || j2>=m)
            return -10000000;
        if(dp[i][j1][j2]!=-1)return dp[i][j1][j2];
        if(i==n-1)
        {
            if(j1==j2)return a[i][j1];
            else 
            return a[i][j1]+a[i][j2];
        }
        int max=-10000000;
        for(int k=-1;k<=1;k++)
        {
            for(int l=-1;l<=1;l++)
            {
                int value = 0;
                if(j1==j2)
                    value = a[i][j1];
                else
                    value = a[i][j1]+a[i][j2];
                value += f(a,i+1,j1+k,j2+l,n,m, dp);
                max = Math.max(max, value);
            }
        }
        return dp[i][j1][j2]=max;
    }
}
