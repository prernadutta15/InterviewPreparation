package com.practice.DynamicProgrammingRevision.Phase1;

/*
 * https://leetcode.com/problems/climbing-stairs/
 */

public class Q1bClimbingStairs {
	
	// Recursion
    public int climbStairsRecursion(int n) {
        if(n<=2) return n;
        return climbStairsRecursion(n-1) + climbStairsRecursion(n-2);
    }

    // Top down
    public int climbStairsTopDown(int n) {
        int dp[] = new int[n+1];
        for(int i=0; i<=n; i++)
            dp[i]=-1;
        return climbStairsTopDownHelper(n, dp);
    }

    public int climbStairsTopDownHelper(int n, int dp[]) {
        if(n<=2) return n;
        if(dp[n] != -1)
            return dp[n];
        dp[n] = climbStairsTopDownHelper(n-1, dp) + climbStairsTopDownHelper(n-2, dp);
        return dp[n];
    }
    
    // Bottom up
    public int climbStairsBottomUp(int n) {
        if(n<=2) return n;
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++)
            dp[i]=dp[i-1] + dp[i-2];
        return dp[n];
    }
    
    // Space optimized
    public int climbStairsSpaceOptimized(int n) {
        if(n<=2) return n;
        int prev2 = 1;
        int prev1 = 2;
        for(int i=3; i<=n; i++) {
            int curr=prev1 + prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}