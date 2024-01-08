package com.practice.DynamicProgrammingRevision.Phase1;

/*
 * https://www.codingninjas.com/studio/problem-details/frog-jump_3621012
 */

public class Q2FrogJump {

	// Recursion
	public static int frogJumpRecursion(int n, int heights[]) {
		return frogJumpRecur(n - 1, heights);
	}

	public static int frogJumpRecur(int n, int heights[]) {
		if (n == 0)
			return 0;
		int nMinusTwo = Integer.MAX_VALUE;
		int nMinusOne = frogJumpRecur(n - 1, heights) + Math.abs(heights[n] - heights[n - 1]);
		if (n > 1)
			nMinusTwo = frogJumpRecur(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);
		return Math.min(nMinusOne, nMinusTwo);
	}

	// Top down
	public static int frogJump2TopDown(int n, int heights[]) {
		int dp[] = new int[n];
		for (int i = 0; i < n; i++)
			dp[i] = -1;
		return frogJumpDp(n - 1, heights, dp);
	}

	public static int frogJumpDp(int n, int heights[], int dp[]) {
		if (n == 0)
			return 0;
		if (dp[n] != -1)
			return dp[n];
		int nMinusTwo = Integer.MAX_VALUE;
		int nMinusOne = frogJumpDp(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
		if (n > 1)
			nMinusTwo = frogJumpDp(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);
		dp[n] = Math.min(nMinusOne, nMinusTwo);
		return dp[n];
	}

	// Bottom up
	public static int frogJumpBottomUp(int n, int heights[]) {
		int dp[] = new int[n];
		dp[0] = 0;
		for (int i = 1; i < n; i++) {
			int nMinusTwo = Integer.MAX_VALUE;
			int nMinusOne = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
			if (i > 1)
				nMinusTwo = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
			dp[i] = Math.min(nMinusOne, nMinusTwo);
		}
		return dp[n - 1];
	}

	// Space optimized
	public static int frogJump(int n, int heights[]) {
		int prev2 = 0;
		int prev1 = 0;
		for (int i = 1; i < n; i++) {
			int nMinusTwo = Integer.MAX_VALUE;
			int nMinusOne = prev1 + Math.abs(heights[i] - heights[i - 1]);
			if (i > 1)
				nMinusTwo = prev2 + Math.abs(heights[i] - heights[i - 2]);
			int curr = Math.min(nMinusOne, nMinusTwo);
			prev2 = prev1;
			prev1 = curr;
		}
		return prev1;
	}
}