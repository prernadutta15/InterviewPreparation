package com.practice.StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/implement-stack-using-queues/description/
 */
public class StacksUsingQueues {

	 Queue<Integer> q;
	    public StacksUsingQueues() {
	        q = new LinkedList<>();
	    }
	    
	    public void push(int x) {
	        q.add(x);
	    }
	    
	    public int pop() {
	        int size = q.size();
	        for(int i=1;i<size;i++)
	        {
	            q.add(q.remove());
	        }
	        return q.remove();
	    }
	    
	    public int top() {
	        int size = q.size();
	        for(int i=1;i<size;i++)
	        {
	            q.add(q.remove());
	        }
	        int x = q.remove();
	        q.add(x);
	        return x;
	    }
	    
	    public boolean empty() {
	        return q.isEmpty();
	    }
}
