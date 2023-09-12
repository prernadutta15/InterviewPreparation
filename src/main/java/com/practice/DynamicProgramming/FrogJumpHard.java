package com.practice.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/frog-jump/description/
 */
public class FrogJumpHard {

	public boolean canCross(int[] stones) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<stones.length;i++)
        {
            map.put(stones[i],i);
        }
        Boolean dp[][] = new Boolean[stones.length][stones.length];
        return f(stones, 0, 0, map, dp);
    }
    public boolean f(int stones[], int curStonePosition, int prevJump, Map<Integer,Integer> map, Boolean dp[][])
    {
        if(curStonePosition == stones.length-1)
            return true;
        if(dp[curStonePosition][prevJump]!=null)
            return dp[curStonePosition][prevJump];
        boolean ans = false;
        for(int nextJump = prevJump - 1; nextJump<=prevJump+1; nextJump++)
        {
            if(nextJump>0)
            {
                int nextStone = stones[curStonePosition] + nextJump;
                if(map.containsKey(nextStone))
                    ans = ans || f(stones,map.get(nextStone), nextJump, map, dp);
            }
        }
        return dp[curStonePosition][prevJump] = ans;
    }
}
