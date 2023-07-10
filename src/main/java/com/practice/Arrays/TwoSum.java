package com.practice.Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author prerna.dutta
 *
 */

public class TwoSum {

	 public int[] twoSum(int[] a, int target) {
	        Map<Integer,Integer> map = new HashMap<>();
	        for(int i=0;i<a.length;i++)
	        {
	            if(map.containsKey(target - a[i]))
	                return new int[]{map.get(target-a[i]),i};
	            map.put(a[i],i);
	        }
	        return new int[]{-1,-1};
	    }
	 public static void main(String[] args) {
		
	}
}
