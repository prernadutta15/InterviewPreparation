package com.practice.StacksAndQueues;

import java.util.Stack;

/**
 * 
 * @author prerna.dutta
 *
 */

public class LargestAreaOfHistogram {

	public int largestRectangleArea(int[] a) {
        int i,n=a.length,max=0;
        int ls[]=leftSmaller(a,n);
        int rs[]=rightSmaller(a,n);
        for(i=0;i<n;i++)
        {
            max = Math.max(max, (rs[i]-ls[i]-1) * a[i]);
        }
        return max;
    }
    int[] leftSmaller(int a[], int n)
    {
        int out[]=new int[n];
        Stack<Integer> s = new Stack<>();
        int i;
        for(i=0;i<n;i++)
        {
            while(!s.isEmpty() && a[i]<=a[s.peek()])
                s.pop();
            if(!s.isEmpty())
                out[i]=s.peek();
            else
                out[i]=-1;
            s.push(i);
        }
        return out;
    }
    int[] rightSmaller(int a[], int n)
    {
        int out[]=new int[n];
        Stack<Integer> s = new Stack<>();
        int i;
        for(i=n-1;i>=0;i--)
        {
            while(!s.isEmpty() && a[i]<=a[s.peek()])
                s.pop();
            if(!s.isEmpty())
                out[i]=s.peek();
            else
                out[i]=n;
            s.push(i);
        }
        return out;
    }
}
