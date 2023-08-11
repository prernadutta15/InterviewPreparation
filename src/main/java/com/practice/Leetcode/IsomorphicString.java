package com.practice.Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/isomorphic-strings/description/
 */

/*
 * s = "badc"     t = "baba"
 * Output: false
 */
public class IsomorphicString {

	public boolean isIsomorphic(String s, String t) {
        // Base case: for different length of two strings...
        if(s.length() != t.length())
            return false;
        // Create two maps for s & t strings...
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        // Traverse all elements through the loop...
        for(int idx = 0; idx < s.length(); idx++){
            // Compare the maps, if not equal, return false...
            if(map1[s.charAt(idx)] != map2[t.charAt(idx)])
                return false;
            // Insert each character if string s and t into seperate map...
            map1[s.charAt(idx)] = idx + 1;
            map2[t.charAt(idx)] = idx + 1;
        }
        return true;    // Otherwise return true...
    }
	
	//my method
	public boolean isIsomorphic2(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        if(s.length()!=t.length())return false;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(map.containsKey(ch) && t.charAt(i)!=map.get(ch))
                return false;
            if(!map.containsKey(ch) && set.contains(t.charAt(i)))
                return false;
            set.add(t.charAt(i));
            map.put(ch, t.charAt(i));
        }
        return true;
    }
}
