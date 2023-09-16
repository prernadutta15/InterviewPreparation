package com.practice.StacksAndQueues;

import java.util.Stack;

/*
 * Given an array of integers A.

The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.

Calculate and return the sum of values of all possible subarrays of A modulo 109+7.

Input:
A = [4, 7, 3, 8]
Output:
26

value ( [4] ) = 4 - 4 = 0
value ( [7] ) = 7 - 7 = 0
value ( [3] ) = 3 - 3 = 0
value ( [8] ) = 8 - 8 = 0
value ( [4, 7] ) = 7 - 4 = 3
value ( [7, 3] ) = 7 - 3 = 4
value ( [3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3] ) = 7 - 3 = 4
value ( [7, 3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3, 8] ) = 8 - 3 = 5
sum of values % 10^9+7 = 26

 */

public class MaxAndMin {

	public int solve(int[] a) {

        int i,n=a.length,mod=1000*1000*1000+7;
        long maxSum=0,minSum=0;
        int lg[]=leftGreater(a);
        int rg[]=rightGreater(a);
        int ls[]=leftSmaller(a);
        int rs[]=rightSmaller(a);
        //for max we continue till we find lg and rg, then we stop
        for(i=0;i<n;i++)
        {
            maxSum += (1L* a[i]%mod * (i-lg[i])%mod * (rg[i]-i)%mod)%mod;
            minSum += (1L* a[i]%mod * (i-ls[i])%mod * (rs[i]-i)%mod)%mod;
        }
        return (int)(maxSum%mod - minSum%mod + mod)%mod; 
    }
    int[] leftSmaller(int a[])
    {
        int i,n=a.length;
        Stack<Integer> stack = new Stack<>();
        int out[]=new int[n];
        for(i=0;i<n;i++)
        {
            while(!stack.isEmpty() && a[stack.peek()]>=a[i])
                stack.pop();
            if(stack.isEmpty())
                out[i]=-1;
            else
                out[i]=stack.peek();

            stack.push(i);
        }
        return out;
    }
    int[] rightGreater(int a[])
    {
        int i,n=a.length;
        Stack<Integer> stack = new Stack<>();
        int out[]=new int[n];
        for(i=n-1;i>=0;i--)
        {
            while(!stack.isEmpty() && a[stack.peek()]<=a[i])
                stack.pop();
            if(stack.isEmpty())
                out[i]=n;
            else
                out[i]=stack.peek();

            stack.push(i);
        }
        return out;
    }
    int[] rightSmaller(int a[])
    {
        int i,n=a.length;
        Stack<Integer> stack = new Stack<>();
        int out[]=new int[n];
        for(i=n-1;i>=0;i--)
        {
            while(!stack.isEmpty() && a[stack.peek()]>=a[i])
                stack.pop();
            if(stack.isEmpty())
                out[i]=n;
            else
                out[i]=stack.peek();

            stack.push(i);
        }
        return out;
    }
    int[] leftGreater(int a[])
    {
        int i,n=a.length;
        Stack<Integer> stack = new Stack<>();
        int out[]=new int[n];
        for(i=0;i<n;i++)
        {
            while(!stack.isEmpty() && a[stack.peek()]<=a[i])
                stack.pop();
            if(stack.isEmpty())
                out[i]=-1;
            else
                out[i]=stack.peek();

            stack.push(i);
        }
        return out;
    }
}
