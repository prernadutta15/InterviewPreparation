package com.practice.Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/fruit-into-baskets/description/
 */
/*
 * same as pick toys and same as find longest substring with k unique characters
 */
public class FruitsIntoBasketsOrPickToys {

	public int totalFruit(int[] fruits) {
        Map<Integer,Integer> map = new HashMap<>();
        int s=0,e=0,ans=0;
        for(e=0;e<fruits.length;e++)
        {
            map.put(fruits[e],map.getOrDefault(fruits[e],0)+1);
            while(map.size()>2)
            {
                map.put(fruits[s],map.get(fruits[s])-1);
                if(map.get(fruits[s])==0)
                    map.remove(fruits[s]);
                s++;
            }
            ans = Math.max(ans, e-s+1);
        }
        return ans;
    }

}
