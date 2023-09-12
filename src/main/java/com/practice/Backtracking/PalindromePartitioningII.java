package com.practice.Backtracking;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/palindrome-partitioning-ii/description/
 */
//TLE
public class PalindromePartitioningII {

	public int minCut(String s) {
		if(isPalindrome(s,0,s.length()-1))
            return 0;
        int dp[] = new int[s.length()];
        for(int i=0;i<s.length();i++)
            dp[i]=-1;
        return minCuts(s,0,s.length(),dp)-1;
    }

    int minCuts(String s, int i, int n, int dp[])
    {
        int minCost = Integer.MAX_VALUE, cost=0;
        if(i==n)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        for(int j=i;j<n;j++)
        {
            if(isPalindrome(s, i, j))
            {
                cost = 1 + minCuts(s, j+1, n, dp);
                minCost = Math.min(minCost, cost);
            } 
        }
        return dp[i]=minCost;
    }
    boolean isPalindrome(String s, int start, int end)
    {
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    
    public int minCutAcceptedSolution(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];
        
        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;  
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }
}
