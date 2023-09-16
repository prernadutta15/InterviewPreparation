package com.practice.StacksAndQueues;

import java.util.Stack;

/*
 * 
You have a string, denoted as A.

To transform the string, you should perform the following operation repeatedly:
Identify the first occurrence of consecutive identical pairs of characters within the string.
Remove this pair of identical characters from the string.
Repeat steps 1 and 2 until there are no more consecutive identical pairs of characters.
The final result will be the transformed string.


Problem Constraints
1 <= |A| <= 100000


Example Input
Input 1:

 A = "abccbc"

Output 1:  "ac"

Input 2:
 A = "ab"

Output 2: "ab"
 */
public class DoubleCharacterTrouble {
	
	 public String solve(String s) 
	    {
	        Stack<Character> stack = new Stack<>();
	        StringBuffer output = new StringBuffer("");
	        int i, n = s.length();
	        for(i=0;i<n;i++)
	        {
	            if(!stack.isEmpty() && stack.peek()==s.charAt(i))
	            {
	               stack.pop();
	            }
	            else
	                stack.push(s.charAt(i));
	        }
	        while(!stack.isEmpty())
	        {
	            output.append(stack.pop());
	        }
	        output.reverse();
	        return output.toString();
	    }

}
