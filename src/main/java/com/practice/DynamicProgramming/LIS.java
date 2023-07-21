package com.practice.DynamicProgramming;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LIS {
	
	public int lengthOfLIS(int[] a) {
        int i,n=a.length,j,maxL=0,ans=0;
        int lis[]=new int[n];
        for(i=0;i<n;i++)
        {
            lis[i]=1;
        }
        for(i=0;i<n;i++)
        {
            for(j=0;j<i;j++)
            {
                if(a[j]<a[i] && 1+lis[j]>lis[i])
                {
                    lis[i]=1+lis[j];
                }
            }
            maxL = Math.max(maxL, lis[i]);
        }
        
        return maxL;
    }
}
