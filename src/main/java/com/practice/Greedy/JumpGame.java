package com.practice.Greedy;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/jump-game/description/
 */

public class JumpGame {

	public boolean canJump(int[] a) {
        int i,n=a.length, reach=0;
        for(i=0;i<n;i++)
        {
            if(i>reach)return false;
            reach = Math.max(reach, a[i]+i);
        }
        return true;
    }
}
