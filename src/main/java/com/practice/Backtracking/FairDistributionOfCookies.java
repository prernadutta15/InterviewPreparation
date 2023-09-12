package com.practice.Backtracking;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/fair-distribution-of-cookies/
 */
/*
 * Page: 259
 */
public class FairDistributionOfCookies {

	int result = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int children[] = new int[k];
        f(0, cookies, k, children);
        return result;
    }
    public int findUnfairness(int a[])
    {
        int max=0;
        for(int i=0;i<a.length;i++)
            max = Math.max(max,a[i]);
        return max;
    }
    public void f(int i, int cookies[], int k, int children[])
    {
        if(i>=cookies.length)
        {
            int unfairness = findUnfairness(children);
            result = Math.min(result, unfairness);
            return;
        }

        for(int j=0;j<k;j++)
        {
            children[j]+=cookies[i];
            f(i+1, cookies, k, children);
            children[j]-=cookies[i];
        }
        
    }
}
