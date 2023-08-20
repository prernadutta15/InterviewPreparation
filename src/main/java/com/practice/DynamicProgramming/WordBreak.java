package com.practice.DynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/word-break/description/
 */
public class WordBreak {

	public boolean wordBreak(String s, List<String> wordDict) {
        Boolean dp[]=new Boolean[s.length()];
        Set<String> words = new HashSet<>(wordDict);
        return breakWords(s, 0, words, dp);
    }
    
    public boolean breakWords(String s, int i, Set<String> words, Boolean dp[])
    {
        if(i>=s.length())return true;
        if(words.contains(s.substring(i)))
            return true;
        if(dp[i]!=null)
            return dp[i];
        for(int j=1;j<s.length();j++)
        {
            if(i+j>s.length())
                break;
            if(words.contains(s.substring(i,i+j)) && breakWords(s, i+j, words, dp))
            {
               return dp[i]=true;
            }
        }
        return dp[i]=false;
    }
}
