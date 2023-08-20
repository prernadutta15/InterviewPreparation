package com.practice.StacksAndQueues;

import java.util.Stack;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/validate-stack-sequences/description/
 */
public class ValidateStackSequence {

	public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int n = pushed.length;
        if(n==0)return true;
        int i=0,j=0;
        while(i<n && j<n)
        {
            stack.push(pushed[i]);
            while(!stack.isEmpty() && popped[j]==stack.peek())
            {
                stack.pop();
                j++;
            }
            i++;
        }
        return stack.isEmpty()?true:false;
    }
}
