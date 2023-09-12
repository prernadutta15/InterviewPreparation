package com.practice.DynamicProgramming;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://practice.geeksforgeeks.org/problems/rod-cutting0840/1?utm_source=
 * geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=
 * article_practice_tab
 */
public class CuttingARod {

	public int cutRod(int A[], int n) {
        int dp[] = new int[A.length+1];
        for(int i=0;i<=A.length;i++)
            dp[i]=-1;
       
        return calculate(A, A.length, dp);
    }
   
    int calculate(int val[],int N, int dp[])
    {
        if(N<=0)return 0;
        if(dp[N]!=-1)return dp[N];
        int max=0;
        for(int cut=1;cut<=N;cut++)
        {
            max=Math.max(max, val[cut-1]+calculate(val, N-cut, dp));
        }
        return dp[N] = max;
        
    }
}
