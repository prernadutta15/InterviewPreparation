package com.practice.DynamicProgramming;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/coin-change-ii/description/
 */
public class CoinChangeII {

	public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount+1];
        int i,j;
        for(i=0;i<coins.length;i++)
        {
            for(j=0;j<=amount;j++)
                dp[i][j]=-1;
        }
        return f(coins, coins.length, amount, dp);
    }
    int f(int a[], int n, int k, int dp[][])
    {
        if(k==0)return 1;
        if(n==0)return 0;
        if(dp[n-1][k]!=-1)return dp[n-1][k];
        int pick = 0;
        if(k>=a[n-1])
        pick = f(a,n,k-a[n-1],dp);
        int notPick = f(a,n-1,k,dp);
        return dp[n-1][k]= pick+notPick;
    }
}
