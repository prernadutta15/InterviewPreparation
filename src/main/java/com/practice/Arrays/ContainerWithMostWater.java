package com.practice.Arrays;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/container-with-most-water/description/
 */

public class ContainerWithMostWater {

	 public int maxArea(int[] a) {
	        int n=a.length,i=0,j=n-1,area=0;
	        while(i<=j)
	        {
	            area= Math.max(area,Math.min(a[i],a[j]) * (j-i));
	            if(a[i]<a[j])
	                i++;
	            else if(a[j]<a[i])
	                j--;
	            else
	            {
	                i++;
	                j--;
	            }
	        }
	        return area;
	    }
}
