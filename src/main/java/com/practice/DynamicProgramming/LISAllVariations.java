package com.practice.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LISAllVariations {
	
	public int lengthOfLISTopDown(int[] nums) {
        int dp[][] = new int[nums.length  +1][nums.length+1];
        for(int i=0;i<=nums.length;i++)
        {
            for(int j=0;j<=nums.length;j++)
                dp[i][j]=-1;
        }
        return findLongestLIS(0, -1, nums, dp);
    }
	
	int findLongestLIS(int index , int prev,int nums[] ,int[][]dp){
        if(index == nums.length){
            return 0;
        }//base case
        if(dp[index][prev+1] != -1){
           return dp[index][prev+1];
        }
        int notTaken = 0 + findLongestLIS(index+1,prev,nums,dp);
        int taken = 0;
        if(prev== -1 || nums[index] > nums[prev]){
            taken = 1 + findLongestLIS(index+1,index,nums,dp);
        }
        dp[index][prev+1] = Math.max(notTaken,taken);
        return dp[index][prev+1];
        
    }
	
	public int lengthOfLIS(int[] a) {
        int i,n=a.length,j,maxL=0;
        int lis[]=new int[n];
        for(i=0;i<n;i++)
        {
            lis[i]=1;
        }
        for(i=0;i<n;i++)
        {
            for(j=0;j<i;j++)
            {
                if(a[j]<a[i])
                {
                    lis[i]=Math.max(lis[i],1+lis[j]);
                }
            }
            maxL = Math.max(maxL, lis[i]);
        }
        
        return maxL;
    }
	
	public int lengthOfLISWithPrint(int[] a) {
        int i,n=a.length,j,maxL=0, lastIndex=0;
        List<Integer> list = new ArrayList<>();
        int lis[]=new int[n];
        int hash[]=new int[n];
        for(i=0;i<n;i++)
        {
            lis[i]=1;
        }
        for(i=0;i<n;i++)
        {
        	hash[i]=i;
            for(j=0;j<i;j++)
            {
                if(a[j]<a[i] && 1+lis[j]>lis[i])
                {
                    lis[i]= 1 + lis[j];
                    hash[i] = j;
                }
            }
            if(lis[i]>maxL)
            {
            	maxL=lis[i];
            	lastIndex=j;
            }
        }
        list.add(0, a[lastIndex]);
        while(hash[lastIndex]!=lastIndex)
        {
        	lastIndex = hash[lastIndex];
        	list.add(0, a[lastIndex]);
        }
        list.forEach(System.out::println);
        return maxL;
    }
	
	public int lengthOfLISUsingBS(int[] a) {
        int i,n=a.length;
        List<Integer> list = new ArrayList<>();
        list.add(a[0]);
        for(i=1;i<n;i++)
        {
            if(a[i]>list.get(list.size()-1))
                list.add(a[i]);
            else
            {
                int idx = findCeil(list,a[i]);
                list.set(idx, a[i]);
            }
        }
        
        return list.size();
    }
    int findCeil(List<Integer> list, int key)
    {
        int start = 0, end = list.size()-1, ans =0;
        while(start<=end)
        {
            int mid = start + (end - start)/2;
            if(list.get(mid)==key)return mid;
            else if(list.get(mid)>key)
            {
                ans = mid;
                end = mid-1;
            }
            else
                start = mid+1;

        }
        return ans;
    }
}
