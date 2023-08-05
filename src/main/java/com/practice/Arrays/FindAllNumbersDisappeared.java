package com.practice.Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
/*
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 */
public class FindAllNumbersDisappeared {

	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int idx = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                idx = nums[i]*-1-1;
            }else{
                idx = nums[i]-1;
            }
            
            if(nums[idx]>0){
                nums[idx] = -nums[idx];
            }
            
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                list.add(i+1);
            };
            
        }
        
        return list;
    }
	
	 public List<Integer> findDisappearedNumbersNaiveMethod(int[] a) {
	        Set<Integer> set = new HashSet<>();
	        int i,n=a.length;
	        List<Integer> out=new ArrayList<Integer>();
	        for(i=0;i<n;i++)
	        {
	            set.add(a[i]);
	        }
	        for(i=1;i<=n;i++)
	        {
	            if(set.contains(i)==false)
	                out.add(i);
	        }
	        return out;

	    }
}
