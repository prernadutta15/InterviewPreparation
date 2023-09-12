package com.practice.Strings;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/palindromic-substrings/description/
 */
public class PalindromicSubstringCount {

	public int countSubstrings(String s) {
        int i,n=s.length(),ans=0,j,d;
        boolean dp[][]=new boolean[n][n];
        for(d=0;d<n;d++)
        {
            for(i=0,j=d;j<n;i++,j++)
            {
                if(d==0)
                    dp[i][j]=true;
                else if(d==1)
                {
                    if(s.charAt(i)==s.charAt(j))
                        dp[i][j]=true;
                    else
                        dp[i][j]=false;
                }
                else
                {
                    if(s.charAt(i)==s.charAt(j))
                        dp[i][j]=dp[i+1][j-1];
                    else
                        dp[i][j]=false;
                }
                if(dp[i][j])
                    ans++;
            }
        }
        return ans;
    }
}