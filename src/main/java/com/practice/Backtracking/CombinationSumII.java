package com.practice.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author prerna.dutta
 *
 */

public class CombinationSumII {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> out = new ArrayList<>();
		Arrays.sort(candidates);
		findCombinationSum(candidates, target, 0, candidates.length, out, ans);
		return ans;
	}

	void findCombinationSum(int a[], int k, int i, int n, List<Integer> out, List<List<Integer>> ans) {
		if (k == 0) {
			ans.add(new ArrayList<>(out));
			return;
		}
		for (int j = i; j < n; j++) {
			if (j > i && a[j] == a[j - 1]) //remember this as j>i and not j>0
				continue;
			if (a[j] <= k) {
				out.add(a[j]);
				findCombinationSum(a, k - a[j], j + 1, n, out, ans); //j+1 not i+1
				out.remove(out.size() - 1);
			}
		}
	}
}
