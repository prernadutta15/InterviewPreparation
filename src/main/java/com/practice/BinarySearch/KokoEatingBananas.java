package com.practice.BinarySearch;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/koko-eating-bananas/description/
 */
public class KokoEatingBananas {

	public int minEatingSpeed(int[] a, int h) {
        int i,n=a.length, max=0;
        for(i=0;i<n;i++){
            max = Math.max(max, a[i]);
        }
        int l=1, r=max, mid;
        if(n == h)return max;
        while(l<r)
        {
            mid = l+(r-l)/2;
            if(isPossible(a, mid, h))
            {
                r = mid;
            }
            else
                l=mid+1;
        }
        return l;
    }
    boolean isPossible(int a[], int mid, int h)
    {
        int c=0, n = a.length, i;
        for(i=0;i<n;i++)
        {
            c += a[i]/mid;
            if(a[i]%mid!=0)
                c++;
        }
        return c<=h;
    }
}
