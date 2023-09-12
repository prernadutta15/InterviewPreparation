package com.practice.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/network-delay-time/description/
 */
public class NetworkDelayTime {

	class Pair implements Comparable<Pair>
    {
        int dist;
        int dest;
        Pair(int d, int n)
        {
            dist=d;
            dest = n;
        }
        @Override
        public int compareTo(Pair ob)
        {
            return -(ob.dist-this.dist);
        }
    }
    class Graph
    {
        int V;
        List<Pair> adj[];
        Graph(int v)
        {
            V=v;
            adj = new ArrayList[V+1];
            for(int i=0;i<=v;i++)
                adj[i] = new ArrayList<>();
        }
        void addEdge(int src, int dest, int wt)
        {
              adj[src].add(new Pair(wt, dest));
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Graph g = new Graph(n);
        int i;
        for(i=0;i<times.length;i++)
            g.addEdge(times[i][0],times[i][1],times[i][2]);
        
        return dijkstra(g, k);
       
    }
    int dijkstra(Graph g, int src)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[]=new int[g.V+1];
        for(int i=0;i<=g.V;i++)
            dist[i]=Integer.MAX_VALUE;
        dist[src]=0;
        pq.add(new Pair(0, src));
        while(!pq.isEmpty())
        {
            Pair pair = pq.remove();
            int wt = pair.dist;
            int u = pair.dest;
            for(int i=0;i<g.adj[u].size();i++)
            {
                Pair v = g.adj[u].get(i);
                int curWt = v.dist;
                int curDest = v.dest;
                if(wt + curWt < dist[curDest])
                {
                    dist[curDest] = wt + curWt;
                    pq.offer(new Pair(wt + curWt, curDest));
                }
            }
        }

        int ans = Integer.MIN_VALUE; 
        for(int i = 1; i <= g.V; i++)
            ans = Math.max(ans, dist[i]);
	    return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
