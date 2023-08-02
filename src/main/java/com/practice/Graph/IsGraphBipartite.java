package com.practice.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/is-graph-bipartite/description/
 */
public class IsGraphBipartite 
{
	class Graph
    {
        int V,E;
        List<Integer> list[];
        Graph(int v)
        {
            V=v;
            list = new ArrayList[V+1];
            for(int i=0;i<V;i++)
                list[i]=new ArrayList<>();
        }
        void addEdge(int src, int dest)
        {
            list[src].add(dest);
        }
    }
    public boolean isBipartite(int[][] graph) {
        int i,j,V=graph.length;
        Graph g = new Graph(V);
        for(i=0;i<V;i++)
        {
            for(j=0;j<graph[i].length;j++)
            {
                g.addEdge(i,graph[i][j]);
            }
        }
        int color[]=new int[V];
        for(i=0;i<V;i++)
            color[i]=-1;
        for(i=0;i<V;i++) //VImp to do it for all components
        {
            if(color[i]!=-1)continue;
            color[i]=1;
            boolean ans = dfs(g,i,color);
            if(ans==false)return false;
        }
        return true;
    }
    public boolean dfs(Graph g, int src, int color[])
    {
        for(int i=0;i<g.list[src].size();i++)
        {
            int v = g.list[src].get(i);
            if(color[v]==-1)
            {
                color[v]=1-color[src];
                boolean ans = dfs(g, v, color);
                if(ans == false)return false;
            }
            else if(color[v]==color[src])
            {
                return false;
            }
        }
        return true;
    }
}
