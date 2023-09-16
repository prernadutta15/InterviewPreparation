package com.practice.StacksAndQueues;

import java.util.Stack;

/*
 * 
Input 1:
 A = "((a+b))"
 
Input 2:
 A = "(a+(a+b))"


Output 1:
 1
Output 2:
 0
 */
public class RedundantBraces {

	public int braces(String s) {
        //if between ( and ) there is a bracket then it is not redundant
        int i;
        boolean isValid = false;
        Stack<Character> stack = new Stack<>();
        for(i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(isOpeningBracket(ch) || isOperator(ch))
                stack.push(ch);
            else if(isClosingBracket(ch))
            {
                isValid = false;
                while(isOpeningBracket(stack.peek())!=true)
                {
                    char c = stack.pop();
                    if(isOperator(c))
                        isValid = true;
                }
                stack.pop();
                if(!isValid)
                    return 1;
            }
        }
        return 0;
    }
    boolean isOpeningBracket(char c)
    {
        if(c=='('||c=='{'||c=='[')
            return true;
        return false;
    }
    boolean isClosingBracket(char c)
    {
        if(c==')'||c=='}'||c==']')
            return true;
        return false;
    }
    boolean isOperator(char c)
    {
        if(c=='+'||c=='-'||c=='*'||c=='/')
            return true;
        return false;
    }
}
