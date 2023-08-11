package com.practice.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParanthesis {

	/**
	 * 
	 * @Page: 239
	 */
	 public List<String> generateParenthesis(int n) {
	        List<String> output = new ArrayList<>();
	        generate(n, 0, 0, "", output);
	        return output;
	    }
	    void generate(int n, int open, int close, String pattern, List<String> output)
	    {
	        if(pattern.length()==2*n)
	        {
	            output.add(pattern);
	            return;
	        }

	        if(open<n)
	        {
	            generate(n, open+1, close, pattern+"(", output);
	        }
	        if(close<open)
	            generate(n, open, close+1, pattern+")",output);
	    }
}
