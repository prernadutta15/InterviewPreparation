package com.practice.Leetcode;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/minimum-deletions-to-make-array-beautiful/description/
 */
public class MinDeletionsToMakeArrayBeautiful {

	public int minDeletion(int[] a) {
        int n = a.length, i, c=0;
        for(i=0;i<n-1;i++)
        {
            if((i-c)%2==0 && a[i]==a[i+1])
                c++;
        }
        return (n-c)%2==0?c:c+1;
        
    }
}
