package com.practice.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/asteroid-collision/description/
 */
public class AsteroidCollision {
	
	/*
	 * [1,-3] -> sum = -2 so left
	 * [5,-3] -> sum = 2 so right, 
	 * also collision happens only when first is +ve then -ve
	 */
	public int[] asteroidCollision(int[] a) {
        int i,n=a.length,sum=0;
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(i=0;i<n;i++)
        {
            while(!stack.isEmpty() && a[i]<0 && stack.peek()>0)
            {
                sum = stack.peek()+a[i];
                if(sum<0)
                    stack.pop();
                else if(sum == 0)
                {
                    stack.pop();
                    a[i]=0;
                }
                else
                    a[i]=0;
            }
            if(a[i]!=0)
                stack.push(a[i]);
        }
        while(!stack.isEmpty())
        {
            ans.add(0,stack.pop());
        }
        int out[]=new int[ans.size()];
        for(i=0;i<ans.size();i++)
            out[i]= ans.get(i);
        return out;

    }
	
}
