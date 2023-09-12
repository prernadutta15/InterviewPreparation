package com.practice.Leetcode;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/minimum-penalty-for-a-shop/description/
 */
public class MinPenaltyForAShop {

	//better than brute force
	public int bestClosingTime(String s) {
        int n = s.length(),i;
        int leftN[] = new int[n+1];
        int rightY[] = new int[n+1];
        leftN[0]=0;
        for(i=1;i<=n;i++)
        {
            char ch = s.charAt(i-1);
            if(ch=='N')
                leftN[i] = 1+leftN[i-1];
            else
                leftN[i] = leftN[i-1];
        }
        rightY[n]=0;
        for(i=n-1;i>=0;i--)
        {
            char ch = s.charAt(i);
            if(ch=='Y')
                rightY[i]= rightY[i+1]+1;
            else
                rightY[i]=rightY[i+1];
        }
        int minPenalty = Integer.MAX_VALUE;
        int minHour = 0;
        for(i=0;i<=n;i++)
        {
            int penalty = leftN[i]+rightY[i];
            if(penalty < minPenalty)
            {
                minPenalty = penalty;
                minHour = i;
            }
        }
        return minHour;
    }
	
	//Most optimal
	public int bestClosingTimeConstantSpace(String s) {
        int i,n=s.length(), minH = 0, minP = Integer.MAX_VALUE, penalty = 0;
        for(i=0;i<n;i++)
        {
            if(s.charAt(i)=='Y')    
                penalty++;
        }
        minP = penalty;
        for(i=0;i<n;i++)
        {
            if(s.charAt(i)=='Y')
                penalty--;
            else if(s.charAt(i)=='N')
                penalty++;
            if(penalty<minP)
            {
                minP = penalty;
                minH = i+1;
            }
        }
        return minH;
    }
}
