package com.practice.DynamicProgramming;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/description/
 */
public class ValidParitionForArray {

	public boolean validPartition(int[] a) {
        int n = a.length;
        Boolean dp[] = new Boolean[n];
        return solve(0, a, n, dp);
    }
    boolean solve(int i, int a[], int n, Boolean dp[])
    {
        if(i>=n)return true;
        boolean result = false;
        if(dp[i]!=null)
            return dp[i];
        if(i+1<n && a[i]==a[i+1])
            result = solve(i+2, a, n, dp);
        if(result)return true;
        if(i+2<n && a[i]==a[i+1] && a[i]==a[i+2])
            result = solve(i+3, a, n, dp);
        if(result)return true;
        if(i+2<n && a[i+1]-a[i]==1 && a[i+2]-a[i+1]==1)
            result = solve(i+3, a, n, dp);
        dp[i]=result;
        return result;
    }
}
