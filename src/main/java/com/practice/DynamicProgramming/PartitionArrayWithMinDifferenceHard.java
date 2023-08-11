package com.practice.DynamicProgramming;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/description/
 */

/*
 * Page: 273
 */
public class PartitionArrayWithMinDifferenceHard {

	public int minimumDifference(int[] a) {
	       int sum=0, n=a.length,i,j;
	        for(i=0;i<n;i++)
	            sum+=a[i];
	        int k=sum;
	        // System.out.println(k+" "+sum+" "+n);
	        boolean dp[][] = new boolean[n][k+1];
	        for(i=0;i<n;i++)
	        {
	            dp[i][0]=true;
	        }
	        for(i=0;i<=k;i++)
	        {
	            if(a[0]==k)
	                dp[0][i]=true;
	        }
	        
	        for(i=1;i<n;i++)
	        {
	            for(j=1;j<=k;j++)
	            {
	                boolean take = false;
	                boolean notTake = dp[i-1][j];
	                if(j>=a[i])
	                    take = dp[i-1][j-a[i]];
	                dp[i][j]=take||notTake;
	            }
	        }
	        //goto last row
	        int min = Integer.MAX_VALUE;
	        for(i=0;i<=k/2;i++) //optimization to avoid TLE
	        {
	            if(dp[n-1][i])
	            min = Math.min(min, Math.abs((sum-i)-i));
	        }
	        return min;
	    }
}
