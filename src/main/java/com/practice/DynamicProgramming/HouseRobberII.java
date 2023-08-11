package com.practice.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/house-robber-ii/description/
 */
public class HouseRobberII {

	//beats 100% top down approach
	public int rob(int[] a) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int i,n=a.length;
        if(n==1)return a[0];
        int dp[]=new int[n];
        for(i=0;i<n;i++)
        {
            if(i!=0)
                list1.add(a[i]);
            if(i!=n-1)
                list2.add(a[i]);
            dp[i]=-1;
        }
        int ans1 = findMaxAmountRobbed(list1, list1.size()-1,dp);
        Arrays.fill(dp,-1);
        int ans2 = findMaxAmountRobbed(list2, list2.size()-1,dp);
        int ans = Math.max(ans1,ans2);
        return ans;
   }
   int findMaxAmountRobbed(List<Integer> a, int n, int dp[])
   {
       if(n==0)return a.get(n);
       if(n<0)return 0;
       if(dp[n]!=-1)return dp[n];
       int pick = a.get(n)+findMaxAmountRobbed(a,n-2,dp);
       int notPick = findMaxAmountRobbed(a,n-1,dp);
       dp[n]=Math.max(pick,notPick);
       return dp[n];
   }
	
	//Bottom up with constant space beats only 8% in time
	public int rob1(int[] a) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int i,n=a.length;
        if(n==1)return a[0]; //imp edge case
        for(i=0;i<n;i++)
        {
            if(i!=0)
                list1.add(a[i]);
            if(i!=n-1)
                list2.add(a[i]);
        }
        int ans = Math.max(findMaxAmountRobbed(list1),findMaxAmountRobbed(list2));
        return ans;
   }
   int findMaxAmountRobbed(List<Integer> a)
   {
       int i,prev = a.get(0),prev2=0, cur_i=0;
       for(i=1;i<a.size();i++)
       {
           int pick = a.get(i);
           if(i>1)
            pick+=prev2;
           int notPick = prev;
           cur_i = Math.max(pick,notPick);
           prev2=prev;
           prev=cur_i;
       }
       return prev;
   }
}
