package com.practice.DynamicProgramming;

/**
 * 
 * @author prerna.dutta
 *
 */

public class PartitionsWithGivenDifference {

	public int countPartitions(int n, int d, int a[]){
        // Code here
        int sum=0;
        for(int i=0;i<n;i++)sum+=a[i];
        if((sum-d)<0 || ((sum-d))%2!=0)return 0;
        return f(a,(sum-d)/2, (int)(10e9 + 7));
    }
    int f(int a[], int k, int mod)
    {
        int dp[][]=new int[a.length][k+1];
        if(a[0]==0)dp[0][0]=2;
        else
            dp[0][0]=1;
        if(a[0]!=0 && a[0]<=k)dp[0][a[0]]=1;
        for(int i=1;i<a.length;i++)
        {
            for(int sum=0;sum<=k;sum++)
            {
                int take = 0;
                int notTake = dp[i-1][sum];
                if(a[i]<=sum)take = dp[i-1][sum-a[i]];
                dp[i][sum]=(take%mod+notTake%mod)%mod;
            }
        }
        return dp[a.length-1][k];
    }
    
    int fEasy(int a[], int n, int k, int mod, int dp[][])
    {
        
        if(k==0)return 1;
        if(n==0)return 0;
        if(dp[n-1][k]!=-1)return (dp[n-1][k]%mod);
        int notPick = fEasy(a,n-1,k,mod,dp);
        int pick = 0;
        if(k>=a[n-1])
            pick = fEasy(a,n-1, k-a[n-1],mod,dp);
        return dp[n-1][k]=(pick%mod+notPick%mod)%mod;
    }
    
    int fTopDown(int a[], int n, int k, int mod, int dp[][])
    {
        
        if(n==0)
        {
            if(k==0 && a[0]==0)return 2;
            if(k==0 || a[0]==k)return 1;
            return 0;
        }
        if(dp[n][k]!=-1)return (int)(dp[n][k]%mod);
        int notPick = fTopDown(a,n-1,k,mod,dp);
        int pick = 0;
        if(k>=a[n])
            pick = fTopDown(a,n-1, k-a[n],mod,dp);
        return dp[n][k]=(pick%mod+notPick%mod)%mod;
    }
}
