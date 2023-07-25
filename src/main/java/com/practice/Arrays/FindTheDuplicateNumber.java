package com.practice.Arrays;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 */
public class FindTheDuplicateNumber {

	public int findDuplicate(int[] a) {
        int n=a.length, i, index=0;
				i=0;
				while(i<n)
				{
					index = a[i]-1;
					if(a[i]!=a[index])
					{
							while(a[i]!=a[index])
							{
								index = a[i]-1;
								a[i]=(a[i]+a[index])-(a[index]=a[i]);
							}
					}
					else
						i++;					
				}
				for(i=0;i<n;i++)
				{
					if(a[i]!=(i+1))
						return a[i];
				}
				return -1;
    }
}
