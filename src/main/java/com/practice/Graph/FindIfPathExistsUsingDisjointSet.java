package com.practice.Graph;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/find-if-path-exists-in-graph/description/
 */

/*
 * TC: O(V * 4alpha)
 */

//Better than 90% submissions hence better than DFS/BFS
public class FindIfPathExistsUsingDisjointSet {

	class DisjointSet
    {
        int par[], size[];
        int V;
        DisjointSet(int v)
        {
            V=v;
            par = new int[V];
            size = new int[V];
            for(int i=0;i<V;i++)
            {
                par[i]=i;
                size[i]=1;
            }
        }
        int findParent(int u)
        {
            if(par[u]==u)return u;
            par[u]=findParent(par[u]);
            return par[u];
        }
        void union(int u, int v)
        {
            int pu = findParent(u);
            int pv = findParent(v);
            if(pu==pv)return;
            if(size[pu]<size[pv])
            {
                size[pv]+=size[pu];
                par[pu] = pv;
            }
            else
            {
                size[pu]+=size[pv];
                par[pv] = pu;
            }
        }
        boolean isConnected(int u, int v)
        {
            if(findParent(u)==findParent(v))return true;
            return false;
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DisjointSet ds = new DisjointSet(n);
        for(int i=0;i<edges.length;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            if(!ds.isConnected(u,v))
                ds.union(u,v);
        }
        return ds.isConnected(source,destination);
    }
}