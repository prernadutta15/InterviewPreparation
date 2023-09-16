package com.practice.StacksAndQueues;

import java.util.Stack;

//Input 1:
// A = "x^y/(a*z)+b"
//Output 1:
// "xy^az*/b+"
// 
//Input 2:
// A = "a+b*(c^d-e)^(f+g*h)-i"
//Output 2:
// "abcd^e-fgh*+^*+i-"
 
public class InfixToPostfix {

	public int getPrecedence(char ch)
    {
        switch(ch)
        {
            case '^': return 5;
            case '/':
            case '*': return 4;
            case '+':
            case '-': return 3;
            default:
            return 0;
        }
    }
    public String solve(String A) {


        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
   
        for(int i=0;i<A.length();i++){

            char ch = A.charAt(i);
            if(ch >='a' && ch <='z')
                sb.append(ch);
            else{
                    if(ch == '(')
                        stack.push(ch);
                    else if(ch == ')'){
                        while(!stack.isEmpty() && stack.peek() != '(')
                            sb.append(stack.pop());    
                        stack.pop();
                    }
                    else{
                        while(!stack.isEmpty() && getPrecedence(stack.peek()) >=
                                                                     getPrecedence(ch))
                            sb.append(stack.pop());
                        stack.push(ch);
                    }
                
            }
        }
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }
}
