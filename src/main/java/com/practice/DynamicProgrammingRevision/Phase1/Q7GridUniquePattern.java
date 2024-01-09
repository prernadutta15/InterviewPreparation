package com.practice.DynamicProgrammingRevision.Phase1;

/*
 * https://leetcode.com/problems/unique-paths/description/
 */

public class Q7GridUniquePattern {

	// Recursion
	public int uniquePathsRecursion(int m, int n) {
		return uniquePathsRecursionHelper(m - 1, n - 1);
	}

	public int uniquePathsRecursionHelper(int i, int j) {
		if (i == 0 && j == 0)
			return 1;
		if (i < 0 || j < 0)
			return 0;
		int up = uniquePathsRecursionHelper(i - 1, j);
		int left = uniquePathsRecursionHelper(i, j - 1);
		return up + left;
	}

	// Top down
	public int uniquePathsTopDown(int m, int n) {
		int[][] dp = new int[m][n];
		return uniquePathsTopDownHelper(dp, m - 1, n - 1);
	}

	public int uniquePathsTopDownHelper(int[][] dp, int i, int j) {
		if (i == 0 && j == 0)
			return 1;
		if (i < 0 || j < 0)
			return 0;
		if (dp[i][j] != 0)
			return dp[i][j];
		int up = uniquePathsTopDownHelper(dp, i - 1, j);
		int left = uniquePathsTopDownHelper(dp, i, j - 1);
		dp[i][j] = up + left;
		return dp[i][j];
	}

	// Bottom up
	public int uniquePathsBottomUp(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int up = 0;
				int left = 0;
				if (i == 0 && j == 0)
					dp[i][j] = 1;
				else {
					if (i > 0)
						up = dp[i - 1][j];
					if (j > 0)
						left = dp[i][j - 1];

					dp[i][j] = up + left;
				}
			}
		}
		return dp[m - 1][n - 1];
	}

	// Space optimized
	public int uniquePathsSpaceOptimized(int m, int n) {
		int[] prev = new int[n];
		for (int i = 0; i < m; i++) {
			int[] curr = new int[n];
			for (int j = 0; j < n; j++) {
				int up = 0;
				int left = 0;
				if (i == 0 && j == 0)
					curr[j] = 1;
				else {
					if (i > 0)
						up = prev[j];
					if (j > 0)
						left = curr[j - 1];

					curr[j] = up + left;
				}
			}
			for (int j = 0; j < n; j++)
				prev[j] = curr[j];
		}
		return prev[n - 1];
	}
}