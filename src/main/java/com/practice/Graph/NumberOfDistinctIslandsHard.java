package com.practice.Graph;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1
 */
public class NumberOfDistinctIslandsHard {

	public void dfs(int row, int col, int[][] vis, String vec[], int[][] grid, int row0, int col0) {
        int m = grid.length;
        int n = grid[0].length;

        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0 || vis[row][col] == 1)
            return;

        vis[row][col] = 1;

        vec[0] = vec[0]+" "+(row - row0)+"_"+(col - col0);

        int dx[] = {0,0,-1,1};
        int dy[] = {1,-1,0,0};
        for(int k=0;k<4;k++)
        {
            int x = row+dx[k];
            int y = col+dy[k];
            dfs(x, y, vis, vec, grid, row0, col0);
        }
        
    }

    public int countDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];

        // Set<List<Pair<Integer, Integer>>> s = new HashSet<>();
        Set<String> s = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String vec[] = new String[1];
                vec[0]="";
                dfs(i, j, vis, vec, grid, i, j);

                if (vec[0]!="")
                {
                    s.add(vec[0]);
                }
                    
            }
        }

        return s.size();
    }

    class Pair<T, U> {
        T first;
        U second;

        Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }
}

