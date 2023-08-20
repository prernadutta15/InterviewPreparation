package com.practice.DynamicProgramming;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BuyAndSellStocks {

	 public int maxProfit(int[] prices) {
	        int min=Integer.MAX_VALUE, max=0,i, n=prices.length;
	        for(i=0;i<n;i++)
	        {
	            min = Math.min(min, prices[i]);
	            max = Math.max(max, prices[i]-min);
	        }
	        return max;
	    }
}
