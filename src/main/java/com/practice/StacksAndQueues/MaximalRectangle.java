package com.practice.StacksAndQueues;

import java.util.Stack;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/maximal-rectangle/description/
 */
public class MaximalRectangle {
	
	public int maximalRectangle(char[][] A) {
	      int height[] = new int[A[0].length];
	        int i,j,ans=0;
	        for(i=0;i<A.length;i++)
	        {
	            for(j=0;j<A[0].length;j++)
	            {
	                if(A[i][j]=='1')
	                    height[j]++;
	                else if(A[i][j]=='0')
	                    height[j]=0;
	            }
	            ans = Math.max(ans, findMaxArea(height));
	        }
	        return ans;
	    }
	    int findMaxArea(int height[])
	    {
	        if (height.length == 1) {
	            return height[0];
	        }
	        int ls[]=findLeftSmallerIndex(height);
	        int rs[]=findRightSmallerIndex(height);
	        int i, max=0;
	        for(i=0;i<height.length;i++)
	        {
	            max = Math.max(max, height[i]*(rs[i]-ls[i]-1));
	        }
	        return max;
	    }
	    int[] findLeftSmallerIndex(int a[])
	    {
	        Stack<Integer> s = new Stack<>();
	        int i;
	        int out[] = new int[a.length];
	        for(i=0;i<a.length;i++)out[i]=-1;
	        for(i=0;i<a.length;i++)
	        {
	            while(!s.isEmpty() && a[s.peek()]>=a[i])
	                s.pop();
	            if(!s.isEmpty())
	                out[i]=s.peek();
	            s.push(i);
	        }
	        return out;
	    }
	    int[] findRightSmallerIndex(int a[])
	    {
	        Stack<Integer> s = new Stack<>();
	        int i;
	        int out[] = new int[a.length];
	        for(i=0;i<a.length;i++)out[i]=a.length;
	       for(i=a.length-1;i>=0;i--)
	        {
	            while(!s.isEmpty() && a[s.peek()]>=a[i])
	                s.pop();
	            if(!s.isEmpty())
	                out[i]=s.peek();
	            // else
	            //     out[i]=a.length;//most important case here
	            s.push(i);
	        }
	        return out;
	    }
	
}
