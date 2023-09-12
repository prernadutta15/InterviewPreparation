package com.practice.StacksAndQueues;

import java.util.Stack;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 */
public class QueuesUsingStacks {

	Stack<Integer> first;
    Stack<Integer> second;

    public QueuesUsingStacks() {
        first = new Stack<>();
        second = new Stack<>();
    }
    
    public void push(int x) {
        first.push(x);
    }
    
    public int pop() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int removed = second.pop();
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return removed;
    }
    
    public int peek() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int removed = second.peek();
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return removed;
    }
    
    public boolean empty() {
        return first.isEmpty();
    }
}
