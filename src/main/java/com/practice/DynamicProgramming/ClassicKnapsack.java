package com.practice.DynamicProgramming;

import java.util.Arrays;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
 */
public class ClassicKnapsack {

	//Top down
	static int knapSackTopDown(int W, int wt[], int val[], int n) 
    { 
        
        int[][] dp = new int[n + 1][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return knapsack(n, W, val, wt, dp);
    }

    static int knapsack(int n, int W, int val[],int wt[], int dp[][])
    {
        if(n==0 || W==0)return 0;
        if(dp[n][W]!=-1)
            return dp[n][W];
        if(W>=wt[n-1])
            dp[n][W]=Math.max(val[n-1]+knapsack(n-1,W-wt[n-1],val,wt,dp),knapsack(n-1,W,val,wt,dp));
        else
            dp[n][W]=knapsack(n-1,W,val,wt,dp);
        return dp[n][W];
    }
    
	//bottom up approach
	public int knapSack(int W, int wt[], int val[], int n) 
    { 
        int dp[] = new int[W+1];
        int i,j;
        
        for(i=1;i<=n;i++)
        {
            for(j=W;j>=0;j--)
            {
                if(j>=wt[i-1])
                    dp[j]=Math.max(dp[j],val[i-1]+dp[j-wt[i-1]]);
            }
            
        }
        return dp[W];
    }
}
