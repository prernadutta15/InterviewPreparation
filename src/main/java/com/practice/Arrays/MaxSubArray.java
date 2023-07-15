package com.practice.Arrays;

/**
 * 
 * @author prerna.dutta
 *
 */

public class MaxSubArray {

	public int maxSubArray(int[] a) {
		int i, n = a.length, local = 0, global = Integer.MIN_VALUE;
		for (i = 0; i < n; i++) {
			local += a[i];
			global = Math.max(global, local);
			if (local < 0)
				local = 0;
		}
		return global;
	}
}
