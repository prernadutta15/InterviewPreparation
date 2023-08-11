package com.practice.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/permutations-ii/description/
 */

public class PermutationsII {

	public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int i=0;i<nums.length;i++)
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i],0)+1);
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        permutation(nums,nums.length,freqMap, temp, output);
        return output;
    }
    void permutation(int a[], int n, Map<Integer,Integer> freqMap, List<Integer> temp, List<List<Integer>> output)
    {
        if(temp.size()==n)
        {
            output.add(new ArrayList<>(temp)); //VVImp: output.add(temp) gives incorrect result
            return;
        }
        for(Map.Entry<Integer,Integer> map: freqMap.entrySet())
        {
            int key = map.getKey();
            int value = map.getValue();
            if(value!=0)
            {
                freqMap.put(key,--value);
                temp.add(key);
                permutation(a,n,freqMap,temp,output);
                temp.remove(temp.size()-1);
                freqMap.put(key,++value);
            }
        }
    }
}
