package com.practice.DynamicProgrammingRevision.Phase1;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/perfect-squares/
 */

public class Q6MinimumNumberOfSquares {

	// Recursion
	public int numSquaresRecursion(int n) {
		if (n == 0)
			return 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i * i <= n; i++)
			min = Math.min(min, numSquaresRecursion(n - i * i));
		return 1 + min;
	}

	// Top down
	public int numSquaresTopDown(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		return numSquaresTopDownHelper(dp, n);
	}

	public int numSquaresTopDownHelper(int[] dp, int n) {
		if (n == 0)
			return 0;
		if (dp[n] != -1)
			return dp[n];
		int min = Integer.MAX_VALUE;
		for (int i = 1; i * i <= n; i++)
			min = Math.min(min, numSquaresTopDownHelper(dp, n - i * i));
		dp[n] = 1 + min;
		return dp[n];
	}

	// Bottom up
	public int numSquaresBottomUp(int n) {
		if (n == 0)
			return 0;
		int[] dp = new int[n + 1];
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++)
				min = Math.min(min, dp[i - j * j]);
			dp[i] = 1 + min;
		}
		return dp[n];
	}
}