package com.practice.Arrays;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class RunningMedianHard {

	public double findMedianSortedArrays(int[] a1, int[] a2) {
		 if(a1.length>a2.length)return findMedianSortedArrays(a2,a1);
	        int n1=a1.length;
	        int n2=a2.length;
	        int total=(n1+n2+1)/2;
	        int low=0,high=n1,mid=0,cut1=0,cut2=0;
	        while(low<=high)
	        {
	            mid = low+(high-low)/2;
	            cut1 = mid;
	            cut2 = total - mid;
	            int left1 = cut1==0?Integer.MIN_VALUE:a1[cut1-1];
	            int left2 = cut2==0?Integer.MIN_VALUE:a2[cut2-1];
	            int right1 = cut1==n1?Integer.MAX_VALUE:a1[cut1];
	            int right2 = cut2==n2?Integer.MAX_VALUE:a2[cut2];

	            if(left1<=right2 && left2<=right1)
	            {
	                //got the answer
	                if((n1+n2)%2==0)
	                    return ((double)(Math.max(left1,left2)+Math.min(right1,right2)))/2.0;
	                else
	                    return (double)(Math.max(left1,left2));
	            }
	            else if(left1>right2)
	                high=cut1-1;
	            else
	                low = cut1+1;
	        }
	        return 0.0;
    }
}
