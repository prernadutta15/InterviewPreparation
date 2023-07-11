package com.practice.Arrays;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/rotate-array/description/
 */
public class RotateArray {

	 public void rotate(int[] a, int k) {
	        int n = a.length;
	        k=k%n;
	        reverse(a,0,n-1);
	        reverse(a,0,k-1);
	        reverse(a,k,n-1);
	    }
	    void reverse(int a[],int s,int e)
	    {
	        int i,j;
	        for(i=s,j=e;i<j;i++,j--)
	            a[i]=(a[i]+a[j])-(a[j]=a[i]);
	    }
}
