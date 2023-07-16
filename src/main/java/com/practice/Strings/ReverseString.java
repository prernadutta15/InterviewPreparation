package com.practice.Strings;

/**
 * 
 * @author prerna.dutta
 *
 */

public class ReverseString {

	public void reverseString(char[] s) {
		int i, j, n = s.length;
		for (i = 0, j = n - 1; i < j; i++, j--) {
			char c = s[i];
			s[i] = s[j];
			s[j] = c;
		}
	}
}
