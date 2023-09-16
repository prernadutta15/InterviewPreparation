package com.practice.StacksAndQueues;

import java.util.Stack;

/*
 * Input 1:
 A = [4, 5, 2, 10, 8]
 
Input 2:
 A = [3, 2, 1]


Example Output
Output 1:
 [-1, 4, -1, 2, 2]
 
Output 2:
 [-1, -1, -1]
 */
public class NextNearElement {

	public int[] prevSmaller(int[] a) 
    {
        Stack<Integer> stack = new Stack<Integer>();
        int i,n=a.length;
        int output[]=new int[n];
        for(i=0;i<n;i++)
            output[i] = -1;
        // stack.push(a[0]);
        for(i=0;i<n;i++)
        {
            while(!stack.isEmpty() && a[i]<=stack.peek())
                    stack.pop();
            if(!stack.isEmpty())
            output[i]=stack.peek();
            
            stack.push(a[i]);   
        }
        return output;
    }
}
