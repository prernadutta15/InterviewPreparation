package com.practice.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/3sum/description/
 */

public class ThreeSum {

	/*
 	 * why to sort? [-3,3,4,-3,1,2] -> [-3,-3,1,2,3,4] 
 	 * so that we don't store duplicate triplets [-3,1,2] and [-3,1,2]
 	 */
	 
	public List<List<Integer>> threeSum(int[] a) {
        List<List<Integer>> output = new ArrayList<>();
        int i=0,j=1,k=a.length-1,sum=0;
        Arrays.sort(a);
        for(i=0;i<a.length-2;i++)
        {
            j=i+1;
            k=a.length-1;
            if(i>0 && a[i]==a[i-1])
                continue;
            while(j<k)
            {
                sum = a[i]+a[j]+a[k];
                if(sum==0)
                {
                    output.add(Arrays.asList(a[i],a[j],a[k]));
                    while(j<k && a[j]==a[j+1])
                        j++;
                    while(j<k && a[k]==a[k-1])
                        k--;
                    j++;
                    k--;
                }
                else if(sum<0)
                    j++;
                else
                    k--;
            }
        }
        return output;
    }
	 public static void main(String[] args) {
		
	}
}
