package com.practice.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/number-of-islands/description/
 */

public class NumberOfIslandsUsingDfsAndBfs {

	public class Pair
    {
        int x,y;
        Pair(){}
        Pair(int a, int b)
        {
            x=a;
            y=b;
        }
    }
    public int numIslands(char[][] grid) {
        int i,j,n=grid.length,m=grid[0].length,c=0;
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(grid, i,j, n,m);
                    c++;
                }
            }
        }
        return c;
    }
    //beats 36%
    void bfs(char a[][], int i, int j, int n, int m)
    {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        int dx[]={0,0,-1,1};
        int dy[]={1,-1,0,0};
        while(!q.isEmpty())
        {
            Pair pair = q.remove();
            int x = pair.x;
            int y = pair.y;
            for(int k=0;k<4;k++)
            {
                int xx = x+dx[k];
                int yy = y+dy[k];
                if(xx>=0 && xx<n && yy>=0 && yy<m && a[xx][yy]=='1')
                {
                    a[xx][yy]='2';
                    q.add(new Pair(xx,yy));
                }
            }
        }
    }
    
    //beats 97%
    void dfs(char a[][], int i, int j, int n, int m)
    {
    	if(i<0 || i>=n || j<0 || j>=m || a[i][j]=='0')
    		return;
    	a[i][j]='0';
    	dfs(a,i,j+1,n,m);
    	dfs(a,i,j-1,n,m);
    	dfs(a,i-1,j,n,m);
    	dfs(a,i+1,j,n,m);
    }
}
