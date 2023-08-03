package com.practice.Strings;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 */

/*
 * Reference: https://www.youtube.com/watch?v=5QpMpO2CAb0
 */

public class LongestSubstringWithAtLeastKRepeatingCharacters {

	public int longestSubstring(String s, int k) {
        return findLongestSubstring(s.toCharArray(), 0, s.length(), k);
    }
    int findLongestSubstring(char a[], int start, int end, int k)
    {
        if(end-start<k)return 0;
        int count[]=new int[26];
        for(int i=start;i<end;i++)
            count[a[i]-'a']++;
        for(int i=start;i<end;i++)
        {
            if(count[a[i]-'a']<k)
            {
                int j=i+1;
                while(j<end && count[a[j]-'a']<k)
                    j++;
                return Math.max(findLongestSubstring(a,start,i,k), findLongestSubstring(a,j,end,k));
            }
        }
        return end-start;
    }
}
