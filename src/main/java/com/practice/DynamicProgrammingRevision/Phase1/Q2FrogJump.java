package com.practice.DynamicProgrammingRevision.Phase1;

/*
 * https://www.codingninjas.com/studio/problem-details/frog-jump_3621012
 */
public class Q2FrogJump {

	public static int frogJumpTopDown(int n, int a[]) {
        int dp[]=new int[n];
        for(int i=0;i<n;i++)dp[i]=-1;
        return f(n-1,a, dp);
    }
    public static int f(int n, int a[], int dp[])
    {
        if(n==0)return 0;
        if(n==1)return Math.abs(a[n]-a[n-1]);
        if(dp[n]!=-1)return dp[n];
        int nMinusTwo = Integer.MAX_VALUE;
        int nMinusOne = f(n-1, a, dp)+Math.abs(a[n]-a[n-1]);
        // if(n>1)
        nMinusTwo = f(n-2, a, dp)+Math.abs(a[n]-a[n-2]);
        dp[n] = Math.min(nMinusOne, nMinusTwo);
        return dp[n];
    }

    public static int frogJumpBottomUp(int n, int a[])
    {
        if(n==0)return 0;
        if(n==1)return Math.abs(a[1]-a[0]);

        int prev2 = 0,prev1= Math.abs(a[0]-a[1]);
        for(int i=2;i<n;i++)
        {
            int nMinusTwo = prev2+Math.abs(a[i]-a[i-2]);
            int nMinusOne = prev1 +Math.abs(a[i]-a[i-1]);
            int cur = Math.min(nMinusOne, nMinusTwo);
            prev2=prev1;
            prev1=cur;
        }
        return prev1;
    }
}
