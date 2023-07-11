package com.practice.Arrays;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/product-of-array-except-self/description/
 */

/*
 *  Input: nums = [1,2,3,4]
	Output: [24,12,8,6]
 */
public class ProductOfArrayExceptSelf {

	public int[] productExceptSelf(int[] a) {
        int left=1,i,n=a.length;
        int right[]=new int[n+1];
        int out[]=new int[n];
        right[n]=1;
        for(i=n-1;i>=0;i--)
            right[i]=right[i+1]*a[i];
        for(i=0;i<n;i++)
        {
            out[i]=left*right[i+1];
            left=left*a[i];
        }
        return out;

    }
}
