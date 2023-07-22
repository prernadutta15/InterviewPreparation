package com.practice.DynamicProgramming;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/climbing-stairs/description/
 */

public class ClimbingStairs {
	 public int climbStairs(int A) {
	        return BottomUp(A);
	    }
	    public int TopDown(int A)
	    {    
	        int[] dp = new int[A+1];
	        for(int i=0; i<=A; i++)
	            dp[i] = -1;
	            
	        return TopDownStairs(A, dp);
	    }
	    
	    public int TopDownStairs(int A, int[] dp)
	    {
	        // Base Case
	        if(A == 1)
	            return 1;   // Step 1 in one way
	            
	        if(A == 2)
	            return 2;
	            
	        if(dp[A] != -1)
	            return dp[A];
	            
	        dp[A] = TopDownStairs(A-1, dp) % 1000000007 + TopDownStairs(A-2, dp) % 1000000007;
	        
	        return dp[A] % 1000000007;
	    }
	    
	    public int BottomUp(int A)
	    {
	        int a,b,c=1;
	        a=1;
	        b=2;
	        if(A<3)return A;
	       
	        for(int i = 3; i <= A; i++)
	        {
	           c=(a% 1000000007+b% 1000000007)% 1000000007;
	           a=b;
	           b=c;
	        }
	        
	        return c % 1000000007;
	    }
}

