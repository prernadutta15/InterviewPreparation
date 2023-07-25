package com.practice.Graph;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/number-of-provinces/description/
 */
public class NumberOfProvincesUsingDFS {

	public int findNumberOfProvinces(int[][] a) {
        int n=a.length,i,c=0;
        boolean vis[]=new boolean[n];
        
        for(i=0;i<n;i++)
        {
            vis[i]=false;
        }
       
        for(i=0;i<n;i++)
        {
            if(vis[i])continue;
            else
            {
                dfs(a,i,n,vis);
                c++;
            }
        }
        return c;
    }
    void dfs(int a[][], int i, int n, boolean vis[])
    {
        if(i<0 || i>=n || vis[i]==true)return;
        vis[i]=true;
        
        for(int j=0;j<a[i].length;j++)
        {
            if(a[i][j]==1)
                dfs(a,j,n,vis);
        }

    }
}
