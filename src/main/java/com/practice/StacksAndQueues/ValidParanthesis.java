package com.practice.StacksAndQueues;

import java.util.Stack;

/**
 * 
 * @author prerna.dutta
 *
 */

public class ValidParanthesis {
	public boolean isValid(String s) {
        int i,n=s.length();
        Stack<Character> stack = new Stack<>();
        for(i=0;i<n;i++)
        {
            char ch = s.charAt(i);
            if(isOpeningBracket(ch))
                stack.push(ch);
            else 
            {
                if(stack.isEmpty())
                    return false;
                else if(!isMatching(stack.pop(), ch))
                    return false;
            }
        }
        if(!stack.isEmpty())return false;
        return true;
    }
    boolean isOpeningBracket(char c)
    {
        if(c=='('||c=='{'||c=='[')
            return true;
        return false;
    }
    boolean isMatching(char curr, char top)
    {
        if(curr == '(' && top == ')')
            return true;
        if(curr == '{' && top == '}')
            return true;
        if(curr == '[' && top == ']')
            return true;
        return false;
    }

}
