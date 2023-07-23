package com.practice.Graph;

/**
 * 
 * @author prerna.dutta
 *
 */


public class DisjointSetImpl
{
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
	public static void main(String[] args) {
		DisjointSet disjointSet = new DisjointSet(7);
		disjointSet.union(1, 2);
		disjointSet.union(2, 3);
		disjointSet.union(4, 5);
		disjointSet.union(6, 7);
		disjointSet.union(5, 6);
		System.out.println(disjointSet.size[6]);
		System.out.println(disjointSet.isConnected(3, 7));
		System.out.println(disjointSet.isConnected(1, 7));
		disjointSet.union(3, 7);
		System.out.println(disjointSet.isConnected(3, 7));
		System.out.println(disjointSet.isConnected(1, 7));
	}
}

