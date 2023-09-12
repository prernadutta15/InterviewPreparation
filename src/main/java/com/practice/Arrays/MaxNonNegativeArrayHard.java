package com.practice.Arrays;

import java.util.ArrayList;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://www.interviewbit.com/problems/max-non-negative-subarray/
 */

/*
 * A = [1, 2, 5, -7, 2, 3] O/P: [1, 2, 5]
 */
public class MaxNonNegativeArrayHard {

	public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        int aleft=-1,aright=-1,left=0,right=0;
        long maxsum=0;
        long sum=0;
        ArrayList<Integer> b=new ArrayList<Integer>();
        for(int i=0;i<A.size();i++)
        {
            if(A.get(i)>=0)
            {
                
               sum+=A.get(i);
               if(sum>maxsum || (sum==maxsum && aright-aleft<right-left))
               {
                   maxsum=sum;
                   aleft=left;
                   aright=right;
               }
            }
            else
            {
               sum=0;
               left=i+1;
            }
            right++;
        }
        if(aleft==-1)
        return b;
        for(int i=aleft;i<=aright;i++)
        {
            b.add(A.get(i));
        }
        return b;
    }
}
