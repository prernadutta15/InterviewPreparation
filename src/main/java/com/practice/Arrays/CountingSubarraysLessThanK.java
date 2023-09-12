package com.practice.Arrays;

/**
 * 
 * @author prerna.dutta
 *
 */

public class CountingSubarraysLessThanK {

	public static int solve(int[] a, int k) {
        int s=0,e=0,n=a.length,sum=0, ans=0;
        for(e=0;e<n;e++)
        {
            sum+=a[e];
            while(sum>=k)
            {
                sum-=a[s];
                s++;
            }
//            System.out.println(e-s+1);
            ans += e-s+1;
        }
        return ans;
    }
	public static void main(String[] args) {
		int a[]= {3,4,2,1,6,8};
		int k=9;
		System.out.println(solve(a, k));
	}
}
