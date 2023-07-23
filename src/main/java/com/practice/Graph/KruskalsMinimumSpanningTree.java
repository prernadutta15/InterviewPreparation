package com.practice.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */

//geeksforgeeks question
public class KruskalsMinimumSpanningTree {

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
    static class Edge implements Comparable<Edge>
    {
        int src,dest,wt;
        Edge(int s, int d, int w)
        {
            src = s;
            dest = d;
            wt = w;
        }
        @Override
        public int compareTo(Edge object)
        {
        	return this.wt-object.wt;
        }
    }
    
	static int spanningTree(int V, int E, int B[][]){
		DisjointSet ds = new DisjointSet(V);
	    List<Edge> list = new ArrayList<>();
        int i,j,cost=0;
        for(i=0;i<B.length;i++)
            list.add(new Edge(B[i][0],B[i][1],B[i][2]));
        Collections.sort(list);
        for(i=0;i<B.length;i++)
        {
        	int u = list.get(i).src;
        	int v = list.get(i).dest;
        	int d = list.get(i).wt;
        	
        	if(ds.findParent(u)!=ds.findParent(v))
        	{
        		cost+=d;
        		ds.union(u, v);
        	}
        }
        return cost;
	}
}
