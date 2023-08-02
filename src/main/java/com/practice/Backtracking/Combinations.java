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
        backtrack(1, n, k, new ArrayList<>(), result);
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
}
