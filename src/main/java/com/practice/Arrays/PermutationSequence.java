package com.practice.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/permutation-sequence/description/
 */

public class PermutationSequence {

	public String getPermutation(int n, int k) {
        int fact=1,i;
        String ans="";
        List<Integer> num=new ArrayList<>();
        for(i=1;i<n;i++)
        {
            fact*=i;
            num.add(i);
        }
        num.add(n);
        k--;
        while(true)
        {
            ans+=num.get(k/fact);
            num.remove(k/fact);
            if(num.size()==0)break;
            k=k%fact;
            fact/=num.size();
        }
        return ans;
    }
}
