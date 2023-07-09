package com.practice.StacksAndQueues;

import java.util.Stack;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/min-stack/description/
 */
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(!minStack.isEmpty() && val<=minStack.peek())
            minStack.push(val);
        else if (minStack.isEmpty())
            minStack.push(val);
    }
    
    public void pop() {
        int ele = stack.pop();
        if(minStack.peek()==ele)
            minStack.pop();
    }
    
    public int top() {
        
        return stack.peek();
    }
    
    public int getMin() {
        if(minStack.isEmpty())return 0;
        return minStack.peek();
    }
}
