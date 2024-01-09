package com.practice.DynamicProgrammingRevision.Phase1;

/*
 * https://leetcode.com/problems/unique-paths-ii/description/
 */

public class Q8GridUniquePattern2 {

	// Recursion
	public int uniquePathsWithObstaclesRecursion(int[][] obstacleGrid) {
		return uniquePathsWithObstaclesRecursionHelper(obstacleGrid, obstacleGrid.length - 1,
				obstacleGrid[0].length - 1);
	}

	public int uniquePathsWithObstaclesRecursionHelper(int[][] oG, int i, int j) {
		if (i < 0 || j < 0)
			return 0;
		if (oG[i][j] == 1)
			return 0;
		if (i == 0 && j == 0)
			return 1;
		int up = uniquePathsWithObstaclesRecursionHelper(oG, i - 1, j);
		int left = uniquePathsWithObstaclesRecursionHelper(oG, i, j - 1);
		return up + left;
	}

	// Top down
	public int uniquePathsWithObstaclesTopDown(int[][] obstacleGrid) {
		int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
		return uniquePathsWithObstaclesTopDownHelper(obstacleGrid, dp, obstacleGrid.length - 1,
				obstacleGrid[0].length - 1);
	}

	public int uniquePathsWithObstaclesTopDownHelper(int[][] oG, int[][] dp, int i, int j) {
		if (i < 0 || j < 0)
			return 0;
		if (oG[i][j] == 1)
			return 0;
		if (i == 0 && j == 0)
			return 1;
		if (dp[i][j] != 0)
			return dp[i][j];
		int up = uniquePathsWithObstaclesTopDownHelper(oG, dp, i - 1, j);
		int left = uniquePathsWithObstaclesTopDownHelper(oG, dp, i, j - 1);
		dp[i][j] = up + left;
		return dp[i][j];
	}

	// Bottom up
	public int uniquePathsWithObstaclesBottomUp(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int up = 0;
				int left = 0;
				if (obstacleGrid[i][j] == 1)
					dp[i][j] = 0;
				else if (i == 0 && j == 0)
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
	public int uniquePathsWithObstaclesSpaceOptimized(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[] prev = new int[n];
		for (int i = 0; i < m; i++) {
			int[] curr = new int[n];
			for (int j = 0; j < n; j++) {
				int up = 0;
				int left = 0;
				if (obstacleGrid[i][j] == 1)
					curr[j] = 0;
				else if (i == 0 && j == 0)
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

	// Space optimized 2
	public int uniquePathsWithObstaclesSpaceOptimized2(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[] prev = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int up = 0;
				int left = 0;
				if (obstacleGrid[i][j] == 1)
					prev[j] = 0;
				else if (i == 0 && j == 0)
					prev[j] = 1;
				else {
					if (i > 0)
						up = prev[j];
					if (j > 0)
						left = prev[j - 1];

					prev[j] = up + left;
				}
			}
		}
		return prev[n - 1];
	}
}