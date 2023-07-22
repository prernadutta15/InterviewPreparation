package com.practice.Strings;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) 
    {
        String maxPalin="";
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int x[]= checkPalindrome(s,i,i);
            int y[] = checkPalindrome(s,i,i+1);
            if(maxLen< x[0])
            {
                maxLen = x[0];
                maxPalin = s.substring(x[1]+1,x[2]);
            } 
            if(maxLen< y[0])
            {
                maxLen = y[0];
                maxPalin = s.substring(y[1]+1,y[2]);
            } 
        }
        
        return maxPalin;
        
    }
   
    private int[] checkPalindrome(String s, int l, int r) {
        while(l>=0 && r< s.length() && s.charAt(l)==s.charAt(r))
        {
            l--;
            r++;
        }
        return new int[]{r-l-1,l,r};
    }
}
