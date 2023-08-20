package com.practice.BinarySearch;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/maximum-running-time-of-n-computers/description/
 */
public class MaxRunningTimeOfNComputers {

	public long maxRunTime(int n, int[] a) {
        long l,r,mid=0,sum=0,min=Long.MAX_VALUE,ans=0;
        int i;
        for(i=0;i<a.length;i++)
        {
            min = Math.min(min, a[i]);
            sum+=a[i];
        }
        l = min;
        r = sum/n;
        while(l<=r)
        {
            mid = l+(r-l)/2;
            if(isPossible(a,mid,n))
            {
                ans = mid;
                l = mid+1;
            }
            else
                r = mid-1;
        }
        return ans;
    }
    boolean isPossible(int a[], long mid, int n)
    {
        long target = n * mid;
        long sum=0;
        for(int i=0;i<a.length;i++)
        {
            sum+=Math.min(a[i], mid);
            if(sum>=target)return true;
        }
        return false;
    }
}
