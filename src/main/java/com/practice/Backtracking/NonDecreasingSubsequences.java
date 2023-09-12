package com.practice.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/non-decreasing-subsequences/description/
 */
public class NonDecreasingSubsequences {

	public List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> finalAns = new ArrayList<>();
		Set<List<Integer>> ans = new HashSet<>();
		List<Integer> out = new ArrayList<>();
		f(nums, 0, nums.length, out, ans, Integer.MIN_VALUE);
		Iterator<List<Integer>> it = ans.iterator();
		while (it.hasNext()) {
			finalAns.add(it.next());
		}
		return finalAns;
    }
	
	// [4,6,7,7] -> O/P: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
    void f(int a[], int i, int n, List<Integer> out, Set<List<Integer>> ans, int prev) {
		if (i == n) {
			if (out.size() >= 2) {
				ans.add(new ArrayList<>(out));
			}
			return;
		}

		//pick
		if (a[i] >= prev) {
			out.add(a[i]);
			f(a, i + 1, n, out, ans, a[i]);
			out.remove(out.size() - 1);
		}
		
		//not pick
		f(a, i + 1, n, out, ans, prev);
	}
}
