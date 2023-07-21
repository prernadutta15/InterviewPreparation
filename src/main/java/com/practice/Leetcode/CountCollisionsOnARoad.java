package com.practice.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/count-collisions-on-a-road/description/
 */
public class CountCollisionsOnARoad {
	
	class Pair
    {
        char ele;
        int freq;
        Pair(char c, int f)
        {
            ele = c;
            freq = f;
        }
    }
    public int countCollisions(String directions) {
        int i,c=0,ans = 0;
        List<Pair> list = new ArrayList<>();
        for(i=0;i<directions.length();i++)
        {
            c=1;
            while(i+1<directions.length() && directions.charAt(i)==directions.charAt(i+1))
            {
                c++;
                i++;
            }
            list.add(new Pair(directions.charAt(i),c));
        }
        for(i=0;i<list.size()-1;i++)
        {
            Pair first = list.get(i);
            Pair second = list.get(i+1);
            if(first.ele == 'R' && second.ele == 'S')
                ans += first.freq;
            else if(first.ele == 'S' && second.ele == 'L')
                ans += second.freq;
            else if(first.ele == 'R' && second.ele == 'L')
                ans += second.freq + first.freq;
        }
        return ans;
    }
	
	public int countCollisionsWrongApproach(String s) {
        Stack<Character> stack = new Stack<>();
        // stack.push(s.charAt(0));
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(!stack.isEmpty() && findCollisionCost(stack.peek(), ch)!=0)
            {
                count+=findCollisionCost(stack.peek(), ch);
                char peek = stack.pop();
                // if(peek=='S' || ch=='S')
                stack.push('S');
                
            }
            else 
                stack.push(ch);
        }
        return count;
    }
    int findCollisionCost(char first, char second)
    {
        if(first=='R' && second == 'L')
            return 2;
        else if(first=='R' && second == 'S')
            return 1;
        else if(first=='S' && second == 'L')
            return 1;
        else 
            return 0;
    }
}
