package com.practice.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */

//TLE
public class PalindromePartitioningII {

	public int minCut(String s) {
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
}
