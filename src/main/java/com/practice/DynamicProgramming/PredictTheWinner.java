package com.practice.DynamicProgramming;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/predict-the-winner/description/
 */
public class PredictTheWinner {

	public boolean predictTheWinner(int[] nums) {
        int n = nums.length,i,j,sum=0;
        int[][] dp = new int[n][n];
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
                dp[i][j]=-1;
        }
        for(i=0;i<n;i++)
            sum+=nums[i];
        int player1 = f(0, n-1, nums, dp);
        int player2 = sum - player1;
        return player1>=player2;
        
    }
    int f(int i, int j, int a[], int dp[][])
    {
        if(i>j)return 0;
        if(i==j)return a[i];
        if(dp[i][j]!=-1)
            return dp[i][j];
        int take_i = a[i]+Math.min(f(i+2,j,a,dp), f(i+1,j-1,a,dp));
        int take_j = a[j]+Math.min(f(i,j-2,a,dp), f(i+1,j-1,a,dp));
        return dp[i][j]=Math.max(take_i, take_j);
    }
}
