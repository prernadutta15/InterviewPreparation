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
 * https://leetcode.com/problems/course-schedule-ii/
 */
public class CourseScheduleII {

	public int[] findOrder(int numCourses, int[][] B) {
        int V = numCourses, E = B.length;
        Graph g = new Graph(V,E);
        int i,k=0,j;
        int ans[]=new int[V];
        int indegree[]=new int[V];
        
        for(i=0;i<E;i++){
            g.addEdge(B[i][0],B[i][1]);
            indegree[B[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(i=0;i<V;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        
        while(!q.isEmpty())
        {
            int u = q.remove();
            ans[k++]=u;
            for(i=0;i<g.list[u].size();i++)
            {
                int v = g.list[u].get(i);
                indegree[v]--;
                if(indegree[v]==0)
                    q.add(v);
            }
        }
        for(i=0,j=ans.length-1;i<j;i++,j--)
            ans[i]=(ans[i]+ans[j])-(ans[j]=ans[i]);
        return k==V?ans:new int[0];
    }
    class Graph
    {
        int V,E;
        List<Integer> list[];
        Graph(int v, int e)
        {
            V=v;
            E=e;
            list = new ArrayList[V+1];
            for(int i=0;i<=V;i++)
            list[i] = new ArrayList<>();
        }
        void addEdge(int u, int v)
        {
            list[u].add(v);
        }
    }
}
