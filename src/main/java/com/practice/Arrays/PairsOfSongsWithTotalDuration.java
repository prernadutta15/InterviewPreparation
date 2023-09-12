package com.practice.Arrays;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/description/
 */
public class PairsOfSongsWithTotalDuration {

	public int numPairsDivisibleBy60(int[] time) {
        int i,n=time.length,modBase = 60,ans=0;
        long f[]=new long[60];
        for(i=0;i<n;i++)
            f[time[i]%modBase]++;
        
        for(i=1;i<modBase/2;i++)
            ans+=f[i]*f[modBase-i];

        ans+=(f[modBase/2]*(f[modBase/2]-1))/2;
        ans+=(f[0]*(f[0]-1))/2;
        return ans;
    }
}
