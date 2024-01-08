package com.practice.DynamicProgrammingRevision.Phase1;

/*
 * https://leetcode.com/problems/house-robber/
 */

public class Q4HouseRobbers1 {

	// Recursion
	public int robRecursion(int[] nums) {
        int n = nums.length;
        return robRecursionHelper(nums, n-1);
    }

    public int robRecursionHelper(int[] nums, int n) {
        if(n==0) return nums[0];
        if(n==1) return Math.max(nums[0], nums[1]);
        return Math.max(robRecursionHelper(nums, n-2)+nums[n], robRecursionHelper(nums, n-1));
    }

    // Top down
    public int robTopDown(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        for(int i=0; i<n; i++)
            dp[i] = -1;
        return robTopDownHelper(nums, dp, n-1);
    }

    public int robTopDownHelper(int[] nums, int dp[], int n) {
        //if(n==0) return nums[0];
        //if(n==1) return Math.max(nums[0], nums[1]);
        if(n<0) return 0;
        if(dp[n] != -1)
            return dp[n];
        dp[n] = Math.max(robTopDownHelper(nums, dp, n-2)+nums[n], robTopDownHelper(nums, dp, n-1));
        return dp[n];
    }
    
    // Bottom up
    public int robBottomUp(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++)
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        return dp[n-1];
    }
    
    // Space optimized
    public int robSpaceOptimized(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        int curr = prev1;
        for(int i=2; i<n; i++) {
            curr = Math.max(prev2+nums[i], prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}