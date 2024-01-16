package com.practice.DynamicProgrammingRevision.Phase2;

import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/triangle/description/
 */

public class Q10Triangle {

	// Recursion
	public int minimumTotalRecursion(List<List<Integer>> triangle) {
		return minimumTotalRecursionHelper(0, 0, triangle);
	}

	public int minimumTotalRecursionHelper(int i, int j, List<List<Integer>> triangle) {
		if (i == triangle.size())
			return 0;
		int down = minimumTotalRecursionHelper(i + 1, j, triangle);
		int dg = minimumTotalRecursionHelper(i + 1, j + 1, triangle);
		return triangle.get(i).get(j) + Math.min(down, dg);
	}

	// Top down
	public int minimumTotalTopDown(List<List<Integer>> triangle) {
		int n = triangle.size();
		int dp[][] = new int[n][n];
		for (int i = 0; i < n; i++)
			Arrays.fill(dp[i], -1001);
		return minimumTotalTopDownHelper(0, 0, triangle, dp);
	}

	public int minimumTotalTopDownHelper(int i, int j, List<List<Integer>> triangle, int dp[][]) {
		if (i == triangle.size())
			return 0;
		if (dp[i][j] != -1001)
			return dp[i][j];
		int down = minimumTotalTopDownHelper(i + 1, j, triangle, dp);
		int dg = minimumTotalTopDownHelper(i + 1, j + 1, triangle, dp);
		dp[i][j] = triangle.get(i).get(j) + Math.min(down, dg);
		return dp[i][j];
	}

	// Bottom up
	public int minimumTotalBottomUp(List<List<Integer>> triangle) {
		int n = triangle.size();
		int dp[][] = new int[n][n];
		for (int j = 0; j < n; j++)
			dp[n - 1][j] = triangle.get(n - 1).get(j);

		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				int down = dp[i + 1][j];
				int dg = dp[i + 1][j + 1];
				dp[i][j] = triangle.get(i).get(j) + Math.min(down, dg);
			}
		}
		return dp[0][0];
	}

	// Space optimized
	public int minimumTotalSpaceOptimized(List<List<Integer>> triangle) {
		int n = triangle.size();
		int prev[] = new int[n];
		for (int j = 0; j < n; j++)
			prev[j] = triangle.get(n - 1).get(j);

		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				int down = prev[j];
				int dg = prev[j + 1];
				prev[j] = triangle.get(i).get(j) + Math.min(down, dg);
			}
		}
		return prev[0];
	}
}