package com.practice.DynamicProgramming;

import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/triangle/description/
 */
public class Triangles {

	public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][]=new int[n][n];
        int i,j;
        for(i=0;i<triangle.get(n-1).size();i++)
            dp[n-1][i]=triangle.get(n-1).get(i);
        for(i=n-2;i>=0;i--)
        {
            for(j=0;j<triangle.get(i).size();j++)
            {
                dp[i][j] = triangle.get(i).get(j)+Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
	
	public int minimumTotalSpaceOptimized(List<List<Integer>> triangle) {
        int n = triangle.size();
        int next[]=new int[n];
        int i,j;
        for(i=0;i<triangle.get(n-1).size();i++)
            next[i]=triangle.get(n-1).get(i);
        for(i=n-2;i>=0;i--)
        {
            int cur[]=new int[n];
            for(j=0;j<triangle.get(i).size();j++)
            {
                cur[j] = triangle.get(i).get(j)+Math.min(next[j],next[j+1]);
            }
            for(j=0;j<next.length;j++)
                next[j]=cur[j];
        }
        return next[0];
    }
}
