package com.practice.BitManipulation;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/counting-bits/description/
 */
public class CountingBits {

	 public int[] countBitsBetter(int n) {
	        int out[]=new int[n+1];
	        for(int i=0;i<=n;i++)
	            out[i]=out[i/2]+i%2;
	        return out;
	 }
	 
	 public int[] countBits(int n) {
        int out[]=new int[n+1];
        for(int i=0;i<=n;i++)
            out[i]=countSetBits(i);
        return out;
    }
    int countSetBits(int n)
    {
        int c=0;
        while(n!=0)
        {
            n=n&(n-1);
            c++;
        }
        return c;
    }
}
