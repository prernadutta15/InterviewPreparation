package com.practice.Graph;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/maximal-network-rank/description/
 */
public class MaximalNetworkRank {
	class Graph
    {
        int V;
        Set<Integer> list[];
        Graph(int v)
        {
            V=v;
            list = new HashSet[V+1];
            for(int i=0;i<v;i++)
                list[i]=new HashSet<>();
        }
        void addEdge(int src, int dest)
        {
            list[src].add(dest);
            list[dest].add(src);
        }
    }
    public int maximalNetworkRank(int n, int[][] a) {
        Graph g = new Graph(n);
        int i,j,rankI, rankJ, total=0,max=0;
        for(i=0;i<a.length;i++)
            g.addEdge(a[i][0],a[i][1]);
        for(i=0;i<n;i++)
        {
            for(j=i+1;j<n;j++)
            {
                rankI = g.list[i].size();
                rankJ = g.list[j].size();
                total = rankI + rankJ;
                if(g.list[i].contains(j))
                    total -= 1;
                max = Math.max(max, total);
            }
        }
        return max;
    }
}
