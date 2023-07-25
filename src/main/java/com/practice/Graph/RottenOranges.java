package com.practice.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/rotting-oranges/description/
 */
public class RottenOranges {

	class Orange
    {
        int x,y,dist;
        Orange(int x,int y, int dist)
        {
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }
    public int orangesRotting(int[][] a) {
        int i,j,n=a.length,m=a[0].length,max=0,k;
        Queue<Orange> q = new LinkedList<>();
        int dx[]={0,0,-1,1};
        int dy[]={1,-1,0,0};
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(a[i][j]==2)
                    q.add(new Orange(i,j,0));
            }
        }
        while(!q.isEmpty())
        {
            Orange orange = q.remove();
            for(k=0;k<4;k++)
            {
                int x = orange.x+dx[k];
                int y = orange.y+dy[k];
                int dist = orange.dist;
                max = Math.max(max,dist);
                if(x>=0 && x<n && y>=0 && y<m && a[x][y]==1)
                {
                    q.add(new Orange(x,y,dist+1));
                    a[x][y]=2;
                }
                
            }
        }
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(a[i][j]==1)
                    return -1;
            }
        }
        return max;
    }
	
}
