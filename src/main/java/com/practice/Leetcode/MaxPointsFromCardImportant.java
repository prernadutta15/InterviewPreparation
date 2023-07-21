package com.practice.Leetcode;

import java.util.Arrays;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 */

public class MaxPointsFromCardImportant {

	//way 1 using dp giving TLE
	public int maxScoreUsingDp(int[] cardPoints, int k) {
		int n = cardPoints.length;
		int dp[][][] = new int[k + 1][n][n];
		for (int[][] grid : dp)
			for (int[] row : grid)
				Arrays.fill(row, -1);

		return f(cardPoints, 0, n - 1, k, dp);
    }
    int f(int a[], int start, int end, int k, int dp[][][])
    {
		if (k == 0 || end < 0)
			return 0;
		
		if (dp[k][start][end] != -1)
			return dp[k][start][end];
		
		int option1 = a[end] + f(a, start, end - 1, k - 1, dp);
		int option2 = a[start] + f(a, start + 1, end, k - 1, dp);
		
		dp[k][start][end] = Math.max(option1, option2);
		
		return dp[k][start][end];
    }
    
    //better O(n) approach using sliding window trick
    public int maxScore(int[] a, int k) {
        int n = a.length,B=n-k,i,s,e,sum=0,minSum=Integer.MAX_VALUE,totalSum=0;
        for(i=0;i<n;i++)totalSum+=a[i];
        for(i=0;i<B;i++)
        {
            sum+=a[i];
        }
        minSum=Math.min(minSum,sum);
        for(s=1,e=B;e<n;s++,e++)
        {
            sum+=a[e]-a[s-1];
            minSum=Math.min(minSum,sum);
        }
        return totalSum-minSum;
    }
}
