package com.practice.DynamicProgrammingRevision.Phase1;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/minimum-path-sum/
 */

public class Q9MinPathInAGrid {

	// Recursion
	public int minPathSumRecursion(int[][] grid) {
		return minPathSumRecursionHelper(grid, grid.length - 1, grid[0].length - 1);
	}

	public int minPathSumRecursionHelper(int[][] a, int i, int j) {
		if (i == 0 && j == 0)
			return a[i][j];
		if (i < 0 || j < 0)
			return Integer.MAX_VALUE;
		int up = minPathSumRecursionHelper(a, i - 1, j);
		int left = minPathSumRecursionHelper(a, i, j - 1);
		return a[i][j] + Math.min(up, left);
	}

	// Top down
	public int minPathSumTopDown(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++)
			Arrays.fill(dp[i], -1);
		return minPathSumTopDownHelper(grid, dp, n - 1, m - 1);
	}

	public int minPathSumTopDownHelper(int[][] a, int[][] dp, int i, int j) {
		if (i == 0 && j == 0)
			return a[i][j];
		if (i < 0 || j < 0)
			return Integer.MAX_VALUE;
		if (dp[i][j] != -1)
			return dp[i][j];
		int up = minPathSumTopDownHelper(a, dp, i - 1, j);
		int left = minPathSumTopDownHelper(a, dp, i, j - 1);
		dp[i][j] = a[i][j] + Math.min(up, left);
		return dp[i][j];
	}

	// Bottom up
	public int minPathSumBottomUp(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int up = Integer.MAX_VALUE;
				int left = Integer.MAX_VALUE;
				if (i == 0 && j == 0)
					dp[i][j] = grid[i][j];
				else {
					if (i > 0)
						up = dp[i - 1][j];
					if (j > 0)
						left = dp[i][j - 1];
					dp[i][j] = grid[i][j] + Math.min(up, left);
				}
			}
		}
		return dp[n - 1][m - 1];
	}

	// Space optimized
	public int minPathSumSpaceOptimized(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[] prev = new int[m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int up = Integer.MAX_VALUE;
				int left = Integer.MAX_VALUE;
				if (i == 0 && j == 0)
					prev[j] = grid[i][j];
				else {
					if (i > 0)
						up = prev[j];
					if (j > 0)
						left = prev[j - 1];
					prev[j] = grid[i][j] + Math.min(up, left);
				}
			}
		}
		return prev[m - 1];
	}
}