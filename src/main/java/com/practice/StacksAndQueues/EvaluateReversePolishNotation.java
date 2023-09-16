package com.practice.StacksAndQueues;

import java.util.Stack;

/*
 * An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each string may be an integer or an operator.

Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.

Input 1:
A =   ["2", "1", "+", "3", "*"]
Output 1:
9

Input 2:
A = ["4", "13", "5", "/", "+"]
Output 2:
6
 */
public class EvaluateReversePolishNotation {

	public int evalRPN(String[] a) 
    {
        Stack<String> stack = new Stack<>();
        for(int i=0;i<a.length;i++)
        {
            if(isNumeric(a[i],a[i].length()))
                stack.push(a[i]);
            else
            {
                String s1 = stack.pop();
                String s2 = stack.pop();
                int s3 = operator(s2,s1,a[i]);
                stack.push(""+s3);
            }
        }
        return Integer.parseInt(stack.pop());
    }
    int operator(String s1, String s2, String op)
    {
        int op1= Integer.parseInt(s1);
        int op2 = Integer.parseInt(s2);
        if(op.equals("+"))
            return op1+op2;
        if(op.equals("-"))
            return op1-op2;
        if(op.equals("*"))
            return op1*op2;
        if(op.equals("/"))
            return op1/op2;
        return 0;
    }
    public boolean isNumeric(String str, int n)
    {
        
        for (int i = 0; i < n; i++) {

            // Check if character is
            // digit from 0-9
            // then return true
            // else false
            if (str.charAt(i) >= '0'
                && str.charAt(i) <= '9' || (str.charAt(0) == '-' && str.length()!=1)) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
}
