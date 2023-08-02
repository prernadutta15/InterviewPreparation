package com.practice.Graph;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/verifying-an-alien-dictionary/description/
 */
public class VerifyAnAlienDictionary {
	public boolean isAlienSorted(String[] A, String B) {
		int i, j, min = Integer.MAX_VALUE;
		String first, second;
		Map<Character, Integer> map = new HashMap<>();
		for (i = 0; i < B.length(); i++)
			map.put(B.charAt(i), (i + 1));
		for (i = 0; i < A.length - 1; i++) {
			first = A[i];
			second = A[i + 1];
			min = Math.min(first.length(), second.length());
			if (first.startsWith(second) && first.length() > second.length())
				return false;
			for (j = 0; j < min; j++) {
				if (map.get(first.charAt(j)) > map.get(second.charAt(j)))
					return false;
				if (map.get(first.charAt(j)) < map.get(second.charAt(j)))
					break;
			}
		}
		return true;
	}
}
