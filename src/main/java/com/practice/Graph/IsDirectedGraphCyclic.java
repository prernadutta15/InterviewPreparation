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

public class IsDirectedGraphCyclic {

	 class Graph
	    {
	        int V,E;
	        List<Integer> list[];
	        Graph(int v,int e)
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
//	            list[dest].add(src);
	        }
	    }
	    public int solve(int A, int[][] B) 
	    {
	        Graph g = new Graph(A+1,B.length);
	        int i,src=0;
	        for(i=0;i<B.length;i++)
	        {
	            g.addEdge(B[i][0],B[i][1]);
	        }
	        boolean visited[]=new boolean[A+1];
	        int par[]=new int[A+1];
	        for(i=0;i<=A;i++)
	        {
	            visited[i]=false;
	            par[i]=-1;
	        }
	        
	        for(i=1;i<=A;i++)
	        {
	            if(visited[i])continue;
	            boolean ans = bfs(g, i, visited, par);
	            if(ans==true)return 1;
	        }
	        
	        return 0;
	    }
	    
	    boolean dfs(Graph g, int src, boolean visited[], int parent)
	    {
	        visited[src]=true;
	        int i;
	        for(i=0;i<g.list[src].size();i++)
	        {
	            int v=g.list[src].get(i);
	            if(!visited[v])
	            {
	                visited[v]=true;
	                boolean ans = dfs(g, v, visited, src);
	                if(ans)return true;
	            }
	            else if(parent!=v)
	                return true;
	        }
	        return false;
	    }
	    boolean bfs(Graph g, int src, boolean visited[], int par[])
	    {
	        Queue<Integer> q = new LinkedList<>();
	        q.add(src);
	        par[src]=src;
	        visited[src]=true;
	        while(!q.isEmpty())
	        {
	            int u = q.remove();
	            for(int i=0;i<g.list[u].size();i++)
	            {
	                int v = g.list[u].get(i);
	                if(visited[v]==false)
	                {
	                    q.add(v);
	                    visited[v]=true;
	                    par[v]=u;
	                }
	                else if(par[u]!=v)
	                    return true;
	            }
	        }
	        return false;
	    }
}
