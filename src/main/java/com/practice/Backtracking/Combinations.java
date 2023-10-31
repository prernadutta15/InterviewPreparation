package com.practice.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/combinations/description/
 */

/*
 * Logic: generate all subsets but pick only those of size k
 */
public class Combinations {

	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=i+1;
        backtrack(1, n, k, new ArrayList<>(), result);
        backtrack2(a, 0, n, k, new ArrayList<>(), result);
        backtrack3(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> output, List<List<Integer>> result) {
        if (output.size() == k) {
            result.add(new ArrayList<>(output));
            return;
        }
        for (int i = start; i <= n; i++) {
            output.add(i);
            backtrack(i+1, n, k, output, result);
            output.remove(output.size() - 1);
        }
    }
    
    void backtrack2(int a[], int i, int n, int k, List<Integer> output, List<List<Integer>> result) {
        
        if (output.size() == k) {
            result.add(new ArrayList<>(output));
            return;
        }
        if(i==n)
            return;
        output.add(a[i]);
        backtrack2(a,i+1,n,k,output,result);
        output.remove(output.size()-1);
        backtrack2(a,i+1,n,k,output,result);
    }
    
    void backtrack3(int i, int n, int k, List<Integer> output, List<List<Integer>> result) {
        
        if(i>n)
        {
            if (output.size() == k) {
                result.add(new ArrayList<>(output));
            }
            return;
        }
        output.add(i);
        backtrack3(i+1,n,k,output,result);
        output.remove(output.size()-1);
        backtrack3(i+1,n,k,output,result);
    }
    
}
