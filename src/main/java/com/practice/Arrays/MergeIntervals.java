package com.practice.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {

	class Pair implements Comparable<Pair>
    {
        int start,end;
        Pair()
        {
            start = end = 0;
        }
        Pair(int s,int e)
        {
            start=s;
            end = e;
        }
        @Override
        public int compareTo(Pair p)
        {
            return this.start-p.start;
        }
    }
    public int[][] merge(int[][] intervals) {
        int i,n=intervals.length;
        List<Pair> list = new ArrayList<>();
        List<Pair> newPair = new ArrayList<>();
        if(n<=1)
            return intervals;
        for(i=0;i<n;i++)
        {
            list.add(new Pair(intervals[i][0],intervals[i][1]));
        }
        Collections.sort(list);
        Pair temp = list.get(0);
        for(i=1;i<n;i++)
        {
            Pair curPair = list.get(i);
            if(curPair.start<=temp.end)
            {
                temp = new Pair(Math.min(curPair.start,temp.start),Math.max(curPair.end,temp.end));
            }
            else
            {
                newPair.add(temp);
                temp = curPair;
            }
                
        }
        newPair.add(temp);
        int out[][]=new int[newPair.size()][2];
        for(i=0;i<newPair.size();i++)
        {
            out[i][0]=newPair.get(i).start;
            out[i][1]=newPair.get(i).end;
        }
        return out;
    }
}
