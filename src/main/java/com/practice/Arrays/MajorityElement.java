package com.practice.Arrays;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/majority-element/description/
 */

public class MajorityElement {

	public int majorityElement(int[] A) {
		int count = 0,throne = 0,i,f=0;
        for(i=0;i<A.length;i++)
        {
            if(count == 0)
            {
                throne = A[i];
                count++;
            }
            else if(A[i]==throne)
            {
                count++;
            }
            else{
                count--;
            }
        }
        for(i=0;i<A.length;i++)
        {
            if(A[i]==throne)
                f++;
        }
        if(f>A.length/2)
            return throne;
        return -1;
    }
}
