package com.practice.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/find-if-path-exists-in-graph/description/
 */

/*
 * TC: O(V+E)
 * SC: O(V)
 */
public class FindIfPathExistsUsingDfsAndBfs {

	class Graph
    {
        int V,E;
        List<Integer> list[];
        Graph(int v, int e)
        {
            V=v;
            E=e;
            list = new ArrayList[V];
            for(int i=0;i<V;i++)
                list[i]=new ArrayList<>();
        }
        void addEdge(int src, int dest)
        {
            list[src].add(dest);
            list[dest].add(src);
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph g = new Graph(n, edges.length);
        for(int i=0;i<edges.length;i++)
            g.addEdge(edges[i][0],edges[i][1]);
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++)
            vis[i]=false;
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
                bfs(g,source,vis);
        }
        return vis[destination];
    }
    private void dfs(Graph g, int source, boolean vis[])
    {
        vis[source] = true;
        for(int i=0;i<g.list[source].size();i++)
        {
            int v = g.list[source].get(i);
            if(!vis[v])
                dfs(g, v, vis);
        }
    }
    private void bfs(Graph g, int source, boolean vis[])
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis[source] = true;
        while(!q.isEmpty())
        {
            int u = q.remove();
            for(int i=0;i<g.list[u].size();i++)
            {
                int v = g.list[u].get(i);
                if(!vis[v])
                {
                    vis[v]=true;
                    q.add(v);
                }
            }
        }
    }
}