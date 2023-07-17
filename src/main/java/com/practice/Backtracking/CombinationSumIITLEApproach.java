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

public class CombinationSumIITLEApproach {

	// incorrect method -> gave TLE
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Set<List<Integer>> ans = new HashSet<>();
		List<List<Integer>> finalAns = new ArrayList<>();
		List<Integer> out = new ArrayList<>();
		Arrays.sort(candidates);
		findCombinationSum(candidates, target, candidates.length - 1, candidates.length, out, ans);

		Iterator<List<Integer>> it = ans.iterator();
		while (it.hasNext()) {
			finalAns.add(it.next());
		}
		return finalAns;
	}

	void findCombinationSum(int a[], int k, int i, int n, List<Integer> out, Set<List<Integer>> ans) {
		if (i < 0) {
			if (k == 0)
				ans.add(new ArrayList<>(out));
			return;
		}
		// pick
		if (a[i] <= k) {
			out.add(a[i]);
			findCombinationSum(a, k - a[i], i - 1, n, out, ans);
			out.remove(out.size() - 1);
		}
		// not pick
		findCombinationSum(a, k, i - 1, n, out, ans);
	}
}
