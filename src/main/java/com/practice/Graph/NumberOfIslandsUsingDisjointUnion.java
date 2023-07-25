package com.practice.Graph;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * much slower
 */
public class NumberOfIslandsUsingDisjointUnion {

	public static class DisjointSet {

		int par[], size[];
		DisjointSet(int V)
		{
			par = new int[V+1];
			size = new int[V+1];
			for(int i=0;i<=V;i++)
			{
				par[i]=i;
				size[i]=1;
			}
		}
		int findParent(int u)
		{
			if(u==par[u])return u;
			par[u]=findParent(par[u]);
			return par[u];
		}
		void union(int u,int v)
		{
			int parU = findParent(u);
			int parV = findParent(v);
			if(parU == parV)return;
			if(size[parU]<size[parV])
			{
				par[parU] = parV;
				size[parV] += size[parU];
			}
			else
			{
				par[parV] = parU;
				size[parU] += size[parV];
			}
		}
		boolean isConnected(int u, int v)
		{
			return (findParent(u) == findParent(v))?true:false;
		}
	}
    public int numIslands(char[][] a) {
        int n=a.length,m=a[0].length,i,j,x,count=0;
        DisjointSet ds = new DisjointSet(n*m);
        int dx[]={0,0,-1,1};
        int dy[]={1,-1,0,0};
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(a[i][j]=='1')
                {
                    int u = i*m+j;
                    for(x=0;x<4;x++)
                    {
                        int xx = i+dx[x];
                        int yy = j+dy[x];
						if(xx<0 || xx>=n || yy<0 || yy>=m || a[xx][yy]=='0')
							continue;
                        int v = xx*m+yy;
                        if(ds.isConnected(u,v)==false)
                            ds.union(u,v);
                    }
                }
            }
        }
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                x=i*m+j;
                if(ds.par[x]==x && a[i][j]=='1')
                    count++;
            }
        }
        return count;
    }
}
