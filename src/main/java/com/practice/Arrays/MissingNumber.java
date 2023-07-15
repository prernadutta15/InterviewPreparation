package com.practice.Arrays;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/missing-number/description/
 */
public class MissingNumber {

	// here every number lies between [0,n]
	public int missingNumberReal(int[] nums) {
		int result = nums.length;
		for (int i = 0; i < nums.length; i++) {
			result += i - nums[i];
		}
		return result;
	}

	// if numbers are from [0,n]
	public int missingNumber(int[] a) {
		int i, n = a.length, index, last = -1;
		i = 0;
		while (i < n) {
			if (a[i] >= 0 && a[i] <= n) {
				index = a[i];
				if (index == n) {
					last = index;
					i++;
				} else if (a[index] != a[i])
					a[i] = (a[i] + a[index]) - (a[index] = a[i]);
				else
					i++;
			} else
				i++;
		}
		for (i = 0; i < n; i++) {
			if (a[i] != i)
				return i;
		}
		if (n != last)
			return n;
		return n + 1;
	}

	// if numbers are from [0,n-1]
	public int missingNumberFromZeroToNMinusOne(int[] a) {
		int i, n = a.length, index;
		i = 0;
		while (i < n) {
			if (a[i] >= 1 && a[i] <= n) {
				index = a[i] - 1;
				if (a[index] != a[i])
					a[i] = (a[i] + a[index]) - (a[index] = a[i]);
				else
					i++;
			} else
				i++;
		}
		for (i = 0; i < n; i++) {
			if (a[i] != (i + 1))
				return i + 1;
		}
		return n;
	}

	public static void main(String[] args) {
	}
}
