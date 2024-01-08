package com.practice.DynamicProgrammingRevision.Phase1;

/*
 * https://leetcode.com/problems/fibonacci-number/
 */

public class Q1aFibonacci {

	// Recursion
    public int fibRecursion(int n) {
        if(n < 2) return n;
        return fibRecursion(n-1) + fibRecursion(n-2);
    }

    // Top down
    public int fibTopDown(int n) {
        int dp[] = new int[n+1];
        for(int i=0; i<=n; i++)
            dp[i]=-1;
        return fibonacciTopDown(n, dp);
    }

    public int fibonacciTopDown(int n, int[] dp) {
        if(n < 2) return n;
        if(dp[n] != -1)
            return dp[n];
        dp[n] = fibonacciTopDown(n-1, dp) + fibonacciTopDown(n-2, dp);
        return dp[n];
    }
    
    // Bottom up
    public int fibBottomUp(int n) {
        if(n < 2) return n;
        int dp[] = new int[n+1];
        for(int i=0; i<=n; i++)
            dp[i]=-1;
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++)
            dp[i]=dp[i-1] + dp[i-2];
        return dp[n];
    }
    
    // Space optimized
    public int fibSpaceOptimized(int n) {
        if(n < 2) return n;
        int prev2 = 0;
        int prev1 = 1;
        for(int i=2; i<=n; i++) {
            int curr=prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}