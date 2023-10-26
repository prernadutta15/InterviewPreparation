package com.practice.StacksAndQueues;

import java.util.Stack;
/*
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/description/
 */
public class SmallestSubsequenceOfDistinctChars {

	public String smallestSubsequence(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        
        boolean[] taken = new boolean[26];
        int[] lastIndex = new int[26];
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            lastIndex[ch - 'a'] = i;
        }
        
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            
            if (taken[idx]) continue;
            
            while (!st.isEmpty() && s.charAt(i)<st.peek() && lastIndex[st.peek()-'a'] > i) {
                taken[st.pop() - 'a'] = false;
            }
            
            st.push(s.charAt(i));
            taken[idx] = true;
        }
        
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        
        return result.reverse().toString();
    }
}
