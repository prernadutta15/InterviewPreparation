package com.practice.DynamicProgrammingRevision.Phase1;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/house-robber-ii/
 */
public class Q5HouseRobbers2 {

	public int robber2(int a[])
	{
		int n = a.length;
        if(n == 1) return a[0];
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1); 
        int firstHouse = maxAmountRobbed(a,0,n-1,dp);
        Arrays.fill(dp,-1); 
        int lastHouse = maxAmountRobbed(a,1,n,dp);
        return Math.max(firstHouse,lastHouse);
	}
	
    public int maxAmountRobbed(int a[], int start, int n, int dp[])
    {
       if(start>=n)return 0;
       if(dp[start]!=-1)return dp[start];
       int pick = maxAmountRobbed(a, start+2, n, dp) + a[start];
       int notPick = maxAmountRobbed(a, start+1, n, dp);
       return dp[start] = Math.max(pick, notPick);
    }
    
    public int robBottomUp(int nums[])
    {
    	int n = nums.length;
        if(nums.length == 1) 
            return nums[0];
        //We will create two arrays in first we will reject first house
        int houseFirst[] = new int[n];
        //In this array we are rejecting last house
        int houseLast[] = new int[n];
        for(int i=0;i<nums.length;i++){
            if(i!=0){
                houseFirst[i] = nums[i];
            }
            if(i!=n-1){
                houseLast[i] = nums[i];
            }
        }
        return Math.max(maxRobbedBottomUp(houseFirst),maxRobbedBottomUp(houseLast));
    }
    
    public int maxRobbedBottomUp(int[] nums){
        int prev = nums[0];
        int prev2 = 0;
        for(int i=1;i<nums.length;i++){
            int take = nums[i];
            if(i>1){
                take+=prev2;
            }
            int nottake = 0 + prev;
            int cur = Math.max(take,nottake);
            prev2=prev;
            prev=cur;
            
        }
        return prev;
    }
}
