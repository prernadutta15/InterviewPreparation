package com.practice.Arrays;

import java.util.Arrays;

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

	public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for(int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }
	//with extra space
	public int[] productExceptSelfII(int[] a) {
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
	public static void main(String[] args) {
		ProductOfArrayExceptSelf ob = new ProductOfArrayExceptSelf();
		int a[]= {1,2,3,4,5};
		ob.productExceptSelf(a);
	}
}
