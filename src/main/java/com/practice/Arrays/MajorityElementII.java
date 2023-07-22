package com.practice.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/majority-element-ii/description/
 */
public class MajorityElementII {

	public List<Integer> majorityElement(int[] A) {
        int i, count1=0,count2=0,throne1=0,throne2=0;
        List<Integer> output = new ArrayList<>();
       for(i=0;i<A.length;i++)
       {
           if(count1==0  && A[i]!=throne2)
           {
               throne1=A[i];
               count1++;
           }
           else if(count2==0 && A[i]!=throne1) 
           {
               throne2=A[i];
               count2++;
           }
           else 
           {
               if(A[i]==throne1)
                   count1++;
               else if(A[i]==throne2)
                   count2++;
               else
               {
                   count1--;
                   count2--;
               }
           }
       }
       int f1=0;
       int f2=0;
       for(i=0;i<A.length;i++)
       {
           if(A[i]==throne1)f1++;
           if(A[i]==throne2)f2++;
       }
       if(f1>A.length/3 )
       {
           output.add(throne1);
       }
       if(f2>A.length/3 && throne1!=throne2)
            output.add(throne2);
       return output;
   }
	
}
