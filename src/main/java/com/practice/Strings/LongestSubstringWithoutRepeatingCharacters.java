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
        int s=0,e=0,n=str.length(),ans=0;
        Set<Character> set = new HashSet<>();
        while(e<n)
        {
            if(set.contains(str.charAt(e)))
            {
                ans=Math.max(ans,e-s);
                while(str.charAt(e)!=str.charAt(s))
                {
                    set.remove(str.charAt(s));
                    s++;
                }
                s++;
            }
            set.add(str.charAt(e));
            e++;
        }
        ans=Math.max(ans,e-s);
        return ans;
    }
}
