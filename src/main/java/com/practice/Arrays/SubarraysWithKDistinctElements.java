package com.practice.Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/subarrays-with-k-different-integers/description/
 */

public class SubarraysWithKDistinctElements {

	/*
	 * we find subarray count with atmost k elements - subarray count with atmost k-1 elements
	 * [1,2,1,3,4],k=3 O/P: 13-10=3
	 */
	public int subarraysWithKDistinct(int[] a, int k) {
        int atMostK = subarrayWithAtmostKDistinctElements(a,k);
        int atMostKMinusOne = subarrayWithAtmostKDistinctElements(a,k-1);
        return atMostK - atMostKMinusOne;
    }
    public int subarrayWithAtmostKDistinctElements(int a[],int k)
    {
        int s=0,e=0,n=a.length,c=0;
        Map<Integer,Integer> map = new HashMap<>();
        while(e<n)
        {
            map.put(a[e],map.getOrDefault(a[e],0)+1);
            e++;
            while(map.size()>k)//imp: I had kept it as if and was getting error!
            {
                int freq = map.get(a[s])-1;
                if(freq<=0)
                    map.remove(a[s]);
                else
                    map.put(a[s],freq);
                s++;
            }
            c+=e-s;
        }
        return c;
    }
}
