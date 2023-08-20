package com.practice.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/01-matrix/
 */
public class ZeroOneMatrix {

	class Graph
    {
        int x,y,dist;
        Graph(int i,int j,int d)
        {
            x=i;
            y=j;
            dist=d;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        Queue<Graph> q = new LinkedList<>();
        int n = mat.length, m = mat[0].length;
        int[][] distance = new int[n][m];
        int[][] ans = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int i,j;
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                visited[i][j]=false;
                distance[i][j]=0;
                if(mat[i][j]==0)
                {
                    visited[i][j]=true;
                    q.add(new Graph(i,j,0));
                }
            }
        }
        int dx[]={-1,0,1,0};
        int dy[]={0,-1,0,1};
        while(!q.isEmpty())
        {
            Graph g = q.remove();
            for(i=0;i<4;i++)
            {
                int x = g.x+dx[i];
                int y = g.y+dy[i];
                if(x>=0 && x<n && y>=0 && y<m && visited[x][y]==false)
                {
                    q.add(new Graph(x,y,g.dist+1));
                    distance[x][y]=g.dist+1;
                    visited[x][y]=true;
                }
            }
        }
        return distance;
    }
}
