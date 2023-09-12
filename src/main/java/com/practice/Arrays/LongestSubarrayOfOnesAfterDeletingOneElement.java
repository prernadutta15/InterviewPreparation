package com.practice.Arrays;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 * 
 * Pg: 304
 */
public class LongestSubarrayOfOnesAfterDeletingOneElement {

	public int longestSubarray(int[] a) {
        int zero=0, max=0, s=0,e;
        for(e=0;e<a.length;e++)
        {
            if(a[e]==0)zero++;
            while(zero>1)
            {
                if(a[s]==0)
                    zero--;
                s++;
            }
            max = Math.max(max, e-s);
        }
        return max;
    }
}
