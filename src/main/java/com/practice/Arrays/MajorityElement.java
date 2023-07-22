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
        int count = 1,major = A[0],i,f=0;
        for(i=1;i<A.length;i++)
        {
            if(A[i]==major)
            {
                count++;
            }
            else if(count == 0)
            {
                major = A[i];
                count++;
            }
            else{
                count--;
            }
        }
        for(i=0;i<A.length;i++)
        {
            if(A[i]==major)
                f++;
        }
        if(f>A.length/2)
            return major;
        return -1;
    }
}
