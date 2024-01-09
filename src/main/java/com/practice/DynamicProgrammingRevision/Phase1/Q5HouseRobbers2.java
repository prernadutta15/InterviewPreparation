package com.practice.DynamicProgrammingRevision.Phase1;

/*
 * https://leetcode.com/problems/house-robber-ii/description/
 */

public class Q5HouseRobbers2 {

	public int rob(int[] nums) {

		int n = nums.length;
		if (n == 1)
			return nums[0];
		int a1[] = new int[n];
		int a2[] = new int[n];
		int i = 0, j = 0;
		for (int k = 0; k < n; k++) {
			if (k != 0) {
				a1[i] = nums[k];
				i++;
			}
			if (k != n - 1) {
				a2[j] = nums[k];
				j++;
			}
		}

		//return Math.max(helperRecursion(a1, a1.length - 1), helperRecursion(a2, a2.length - 1));
		//return Math.max(helperTD(a1, a1.length - 1), helperTD(a2, a2.length - 1));
		//return Math.max(helperBottomUp(a1, a1.length - 1), helperBottomUp(a2, a2.length - 1));
		return Math.max(helperSpaceOptimized(a1, a1.length - 1), helperSpaceOptimized(a2, a2.length - 1));
	}

	// Recursion
    public int helperRecursion(int[] a, int n){
        if(n == 0) return a[0];
        if(n == 1) return Math.max(a[0], a[1]);
        return Math.max(helperRecursion(a, n-2) + a[n], helperRecursion(a, n-1));
    }

	// Top down
	public int helperTD(int[] a, int n) {
		int[] dp = new int[n + 1];
		for (int i = 0; i <= n; i++)
			dp[i] = -1;
		return helperTopDown(a, dp, n);
	}

	public int helperTopDown(int[] a, int[] dp, int n) {
		if (n == 0)
			return a[0];
		if (n == 1)
			return Math.max(a[0], a[1]);
		if (dp[n] != -1)
			return dp[n];
		dp[n] = Math.max(helperTopDown(a, dp, n - 2) + a[n], helperTopDown(a, dp, n - 1));
		return dp[n];
	}

	// Bottom up
	public int helperBottomUp(int[] a, int n) {
        if(n == 0) return a[0];
        if(n == 1) return Math.max(a[0], a[1]);
        int[] dp = new int[n+1];
        dp[0] = a[0];
        dp[1] = Math.max(a[0], a[1]);
        for(int i=2; i<=n; i++)
            dp[i] = Math.max(dp[i-2] + a[i], dp[i-1]);
        return dp[n];
    }

	// Space optimized
	public int helperSpaceOptimized(int[] a, int n) {
		if (n == 0)
			return a[0];
		if (n == 1)
			return Math.max(a[0], a[1]);
		int prev2 = a[0];
		int prev1 = Math.max(a[0], a[1]);
		for (int i = 2; i <= n; i++) {
			int cur = Math.max(prev2 + a[i], prev1);
			prev2 = prev1;
			prev1 = cur;
		}
		return prev1;
	}
}