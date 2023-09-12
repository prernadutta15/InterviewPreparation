package com.practice.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/minimum-window-substring/description/
 */
public class MinimumWindowSubstringHard 
{
	public String minWindow(String s1, String t) 
	{
        Map<Character,Integer> map = new HashMap<>();
        int i, need, min=Integer.MAX_VALUE, windowSize = Integer.MAX_VALUE, startI = 0, s=0, e=0;
        
        for(i=0;i<t.length();i++)
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        
        need = t.length();
  
        for(e=0;e<s1.length();e++)
        {
            char ch = s1.charAt(e);
            if(map.containsKey(ch) && map.get(ch)>0)
            {
                need--;
            }
           
            if(map.containsKey(ch))
            	map.put(ch,map.get(ch)-1);
           
            while(need==0)
            {
                char ch1 = s1.charAt(s);
                windowSize = e-s+1;
                if(min>windowSize)
                {
                    min = windowSize;
                    startI = s;
                }
                
                if(map.containsKey(ch1))
                	map.put(ch1, map.get(ch1)+1);
                
                if(map.containsKey(ch1) && map.get(ch1)>0)
                    need++;
                s++;
            }
        }
        return min==Integer.MAX_VALUE?"":s1.substring(startI, startI+min);
    }
}
