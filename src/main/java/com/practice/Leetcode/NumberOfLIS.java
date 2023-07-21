package com.practice.Leetcode;

/**
 * 
 * @author prerna.dutta
 *
 */

public class NumberOfLIS {

	public int findNumberOfLIS(int[] a) {
        int i,n=a.length,j,maxL=0,ans=0;
        int lis[]=new int[n];
        int count[]=new int[n];
        for(i=0;i<n;i++)
        {
            lis[i]=count[i]=1;
        }
        for(i=0;i<n;i++)
        {
            for(j=0;j<i;j++)
            {
                if(a[j]<a[i] && 1+lis[j]>lis[i])
                {
                    lis[i]=1+lis[j];
                    count[i]=count[j];
                }
                else if(a[j]<a[i] && 1+lis[j]==lis[i])
                {
                    count[i]+=count[j];
                }
            }
            maxL = Math.max(maxL, lis[i]);
        }
        for(i=0;i<n;i++)
        {
            if(lis[i]==maxL)
             ans+=count[i];
        }
        return ans;
    }
}
