package com.practice.Graph;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/
 */

public class NumberOfOperationsToMakeNetworkConnected {

	public static class DisjointSet {

		int par[], size[];
		DisjointSet(int V)
		{
			par = new int[V+1];
			size = new int[V+1];
			for(int i=0;i<=V;i++)
			{
				par[i]=i;
				size[i]=1;
			}
		}
		int findParent(int u)
		{
			if(u==par[u])return u;
			par[u]=findParent(par[u]);
			return par[u];
		}
		void union(int u,int v)
		{
			int parU = findParent(u);
			int parV = findParent(v);
			if(parU == parV)return;
			if(size[parU]<size[parV])
			{
				par[parU] = parV;
				size[parV] += size[parU];
			}
			else
			{
				par[parV] = parU;
				size[parU] += size[parV];
			}
		}
		boolean isConnected(int u, int v)
		{
			return (findParent(u) == findParent(v))?true:false;
		}
	}
    public int makeConnected(int n, int[][] a) {
        DisjointSet ds = new DisjointSet(n);
        
        //logic: find number of extra edges in a component and then find number of connected components
        //if there are 5 connected components, you will need 5-1=4 to connect, now check if you have 4 extra edges.
        
        int extra=0, connectedCount=0, ans;
        for(int i=0;i<a.length;i++)
        {
            int u = a[i][0];
            int v = a[i][1];
            if(ds.isConnected(u,v))
                extra++;
            else
                ds.union(u,v);
        }
        
        for(int i=0;i<n;i++)
        {
            if(ds.par[i]==i)
                connectedCount++;
        }
        ans = connectedCount - 1;
        if(extra>=ans)return ans;
        return -1;
    }
	
}
