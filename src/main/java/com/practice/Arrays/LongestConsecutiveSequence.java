package com.practice.Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] A) {
        Set<Integer> set = new HashSet<>();
       int i,j,n=A.length,ans=0,len=1;
       for(i=0;i<n;i++)
           set.add(A[i]);
       for(i=0;i<n;i++)
       {
           if(set.contains(A[i]-1))
               continue;
           len = 1;
           for(j=A[i]+1; ;j++)
           {
               if(set.contains(j))
                   len++;
               else
                   break;
           }
           ans = Math.max(ans,len);
       }
       return ans;   
   }
}
