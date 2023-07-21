package com.practice.Leetcode;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/can-place-flowers/
 */
public class CanBuyFlowers {

	public boolean canPlaceFlowers(int[] a, int n) {
        //1010001001
        int i,c=0;
        for(i=0;i<a.length;i++)
        {
            if((i-1)>=0 && (i+1)<a.length && a[i-1]==0 && a[i+1]==0){
                 c++;
                 a[i]=1;
            }
               
        }
        if(c>=n)return true;
        return false;
    }
}
