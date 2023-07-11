package com.practice.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 */

/*
 * Given an integer array nums of length n where all the integers of nums are in
 * the range [1, n] and each integer appears once or twice, return an array of
 * all the integers that appears twice.
 * 
 * You must write an algorithm that runs in O(n) time and uses only constant
 * extra space. Input: nums = [4,3,2,7,8,2,3,1] Output: [2,3]
 */
public class FindAllDuplicatesInArray {

	 public List<Integer> findDuplicates(int[] a) {
	        List<Integer> out = new ArrayList<>();
	        int i,idx=0,n=a.length;
	        for(i=0;i<n;i++)
	        {
	            idx= Math.abs(a[i])-1;
	            if(a[idx]>0)a[idx]*=-1;
	            else
	                out.add(Math.abs(a[i]));
	        }
	        return out;
	    }
}
