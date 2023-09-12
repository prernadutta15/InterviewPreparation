package com.practice.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/word-break-ii/description/
 */
public class WordBreakII {

	private List<String> result = new ArrayList<>();
    private Set<String> wordSet = new HashSet<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
       for (String str: wordDict) {
            wordSet.add(str);
        }
        if(wordSet.contains(s)){
            result.add(s);
            return result;
        }
        solve(0, s, "");
        return result;
    }

    private void solve(int i, String str, String ans) {
    	 if (i>=str.length()) {
             result.add(ans);
         }
         for (int j = 1; j < str.length(); j++) {
             if(i+j>str.length())
                 break;
             String subStr = str.substring(i, i+j);
             if (wordSet.contains(subStr)) {
                 String toAdd = ans=="" ? subStr : " " + subStr;
                 solve(i+j,str, ans+toAdd);
             }
         }
     }
}
