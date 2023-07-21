package com.practice.Leetcode;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/teemo-attacking/
 */
public class TeemoAttacking {

	 public int findPoisonedDuration(int[] timeseries, int duration) {
	        int ans = 0;
	        for(int i = 0; i< timeseries.length-1; i++)
	        {
	            if(timeseries[i]+duration<timeseries[i+1])
	            {
	                ans+=duration;
	            }
	            else
	            ans+=timeseries[i+1]-timeseries[i];
	        }
	        return ans+duration;
	    }
}
