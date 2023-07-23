package com.practice.Graph;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/number-of-provinces/description/
 */
public class NumberOfProvincesUsingDisjointSet {

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
    public int countNumberOfProvinces(int[][] a) {
        DisjointSet ds = new DisjointSet(a.length);
        int i,j,count=0;
        for(i=0;i<a.length;i++)
        {
            for(j=0;j<a[0].length;j++)
            {
                if(a[i][j]==1)
                    ds.union(i,j);
            }
        }
        for(i=0;i<a.length;i++)
        {
            if(ds.par[i]==i)    
                count++;
        }
        return count;
    }
}
