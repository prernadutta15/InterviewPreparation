package com.practice.Backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author prerna.dutta
 *
 */


/*
 * https://leetcode.com/problems/optimal-partition-of-string/description/
 */
public class OptimalPartitioningOfString {

	//beats 70%
	public int partitionStringBetterApproach(String s) {
        int ans = 0,i,n=s.length();
        Set<Character> set = new HashSet<>();
        for(i=0;i<n;i++)
        {
            if(set.contains(s.charAt(i)))
            {
                set = new HashSet<>();
                ans++;
            }
            set.add(s.charAt(i));
        }
        return ans+1;
    }
	
	//only beats 5% in space and time brute force
	public int partitionString(String s) {
        int dp[]=new int[s.length()];
        Arrays.fill(dp,Integer.MAX_VALUE);
        return f(s,0, dp);
    }
    public int f(String s, int index, int dp[])
    {
        if(index==s.length())return 0;
        if(dp[index]!=Integer.MAX_VALUE)
            return dp[index];
        int min = s.length();
        for(int i=index;i<s.length();i++)
        {
            if(isValid(s,index,i))
            {
                min = Math.min(min, 1+f(s,i+1, dp));
            }
            else
                break;
        }
        dp[index]=min;
        return min;
    }
    public boolean isValid(String s, int i, int j)
    {
        Set<Character> set = new HashSet<>();
        for(int k=i;k<=j;k++)
        {
            if(set.contains(s.charAt(k)))
                return false;
            set.add(s.charAt(k));
        }
        return true;
    }
}
