package com.practice.Leetcode;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/
 */

public class MaxConsecutiveOnesIII {

	 public int longestOnes(int[] a, int k) {
	        int s=0,e=0,ans=0;
	        for(s=0;s<a.length;s++)
	        {
	            if(a[s]==0)k--;
	            while(k<0)
	            {
	                if(a[e]==0)
	                    k++;
	                e++;
	            }
	            ans = Math.max(ans, s-e+1);
	        }
	        return ans;
	    }
}
