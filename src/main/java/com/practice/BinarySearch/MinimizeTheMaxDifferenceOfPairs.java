package com.practice.BinarySearch;

import java.util.Arrays;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/description
 */
public class MinimizeTheMaxDifferenceOfPairs {

	public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        
        int left = 0, right = nums[nums.length - 1] - nums[0], ans = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (checkIfPairsPossible(nums, mid, p)) {
                ans = mid;
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        
        return ans;
    }
    
    private boolean checkIfPairsPossible(int[] a, int mid, int p) {
        int count = 0, n = a.length, i;
        for(i=0;i<n-1;i++)
        {
            if(Math.abs(a[i]-a[i+1])<=mid)
            {
                i++;
                count++;
            }
        }
        return count>=p;
    }
}
