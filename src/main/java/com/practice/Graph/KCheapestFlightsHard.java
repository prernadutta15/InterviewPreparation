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
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */

public class KCheapestFlightsHard {

	 public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
	        Graph g = createGraph(n, flights);
	        int cheapestFlightCost = findCheapestFlightCost(g, src, dst, k);
	        return cheapestFlightCost;
	    }

	    int findCheapestFlightCost(Graph g, int src, int dst, int k)
	    {
	        Queue<Edge> q = new LinkedList<>();
	        int dist[]=new int[g.V];
	        
	        for(int i=0;i<g.V;i++)
	            dist[i]=Integer.MAX_VALUE;
	        dist[src]=0;
	        q.add(new Edge(src, 0));
	        int steps = 0;
	        while(!q.isEmpty() && steps<=k)
	        {
	            int n = q.size(); //vvimp: to process all current level nodes
	            while(n-->0)
	            {
					Edge edge = q.remove();
					int u = edge.node;
					int u_dist = edge.dist;
					for (int i = 0; i < g.list[u].size(); i++) {
						int v = g.list[u].get(i).node;
						int v_dist = g.list[u].get(i).dist;
						if (u_dist + v_dist < dist[v]) {
							dist[v] = u_dist + v_dist;
							q.add(new Edge(v, dist[v]));
						}
					}
	            }
	            steps++;
	            
	        }
	        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
	    }

	    class Edge
	    {
	        int node;
	        int dist;
	        Edge(int n, int d)
	        {
	            node = n;
	            dist = d;
	        }
	    }
	    class Graph
	    {
	        int V;
	        List<Edge> list[];
	        Graph(int v)
	        {
	            V=v;
	            list = new ArrayList[V];
	            for(int i=0;i<V;i++)
	                list[i]=new ArrayList<>();
	        }
	        void addEdge(int src, int dest, int cost)
	        {
	            list[src].add(new Edge(dest, cost));
	        }
	    }

	    Graph createGraph(int n, int[][] flights)
	    {
	        Graph g = new Graph(n);
	        for(int i=0;i<flights.length;i++)
	        {
	            g.addEdge(flights[i][0], flights[i][1], flights[i][2]);
	        }
	        return g;
	    }
}
