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

	public int findDuplicateBestMethod(int[] nums) {
	       int slow = nums[0];
			int fast = nums[nums[0]];
			while (slow != fast)
			{
				slow = nums[slow];
				fast = nums[nums[fast]];
			}

			fast = 0;
			while (fast != slow)
			{
				fast = nums[fast];
				slow = nums[slow];
			}
			return slow;
	    }
	public int findDuplicateSecondBestMethod(int[] a) {
        int n=a.length, i, index=0;
		for(i=0;i<n;i++)
        {
            if(a[i]<0)
                index=(a[i]*-1) -1;
            else
                index = a[i]-1;

            if(a[index]>0)
                a[index]*=-1;
            else
                return Math.abs(a[i]);
        }
        return -1;
    }
	
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
