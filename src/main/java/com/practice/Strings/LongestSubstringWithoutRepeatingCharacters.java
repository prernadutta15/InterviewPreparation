package com.practice.Strings;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String str) {
		int s=0,e=0,ans=0;
        Set<Character> set = new HashSet<>();
        for(e=0;e<str.length();e++)
        {
            if(set.contains(str.charAt(e)))
            {
                while(str.charAt(e)!=str.charAt(s))
                {
                    set.remove(str.charAt(s));
                    s++;
                }
                s++;
            }
            set.add(str.charAt(e));
            ans=Math.max(ans,e-s+1);
        }
        return ans;
    }
}
