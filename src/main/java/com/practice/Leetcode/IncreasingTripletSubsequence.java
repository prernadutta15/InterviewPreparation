package com.practice.Leetcode;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/increasing-triplet-subsequence/description/
 */
public class IncreasingTripletSubsequence {

	public boolean increasingTripletOptimized(int[] a) {
        /*We only need to find one increasing subsequence.
        So focus on two variables only and if you find one number greater than the two while traversing return true.
        */
        int i,n=a.length;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for(i=0;i<n;i++)
        {
            if(a[i]<=first)
                first = a[i];
            else if(a[i]<=second)
                second = a[i];
            else
                return true;
        }
        return false;

    }
	
	public boolean increasingTriplet(int[] a) {
        int i,n=a.length;
        int min[] = new int[n];
        int max[] = new int[n];
        min[0]=a[0];
        for(i=1;i<n;i++)
        {
            min[i]=Math.min(min[i-1],a[i]);
        }
        max[n-1]=a[n-1];
        for(i=n-2;i>=0;i--)
        {
            max[i]=Math.max(max[i+1], a[i]);
        }
        for(i=1;i<n-1;i++)
        {
            int left = min[i-1];
            int right = max[i+1];
            if(a[i]>left && a[i]<right)
                return true;
        }
        return false;

    }
}
