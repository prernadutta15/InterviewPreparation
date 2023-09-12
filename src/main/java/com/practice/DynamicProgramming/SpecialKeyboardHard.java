package com.practice.DynamicProgramming;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://practice.geeksforgeeks.org/problems/special-keyboard3018/1
 */
/*
 * Page: 288
 */
public class SpecialKeyboardHard {

	//bottom up
	static int optimalKeys(int N){
        // code here
        int dp[]=new int[N+1];
        int n,j,max=0;
        if(N<=6)return N;
        for(n=1;n<=6;n++)
            dp[n]=n;
        for(n=7;n<=N;n++)
        {
            for(j=n-3;j>=1;j--)
            {
                int val = dp[j]*(n-j-1);
                max = Math.max(max, val);
            }
            dp[n]=max;
        }
        return dp[N];
    }
	
	//Top down
	 static int optimalKeysTopDown(int N){
	        // code here
	        int dp[]=new int[N+1];
	        for(int i=0;i<=N;i++)dp[i]=-1;
	        f(N,dp);
	        return dp[N];
	    }
	    static int f(int n, int dp[])
	    {
	        if(n<=6)return dp[n]=n;
	        if(dp[n]!=-1)return dp[n];
	        for(int i=2;i<=n-2;i++)
	        {
	            dp[n]=Math.max(dp[n],f(n-i-1,dp)*i);
	        }
	        return dp[n];
	    }
}
