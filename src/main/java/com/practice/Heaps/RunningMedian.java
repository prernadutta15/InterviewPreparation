package com.practice.Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 */
public class RunningMedian {

	PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public RunningMedian() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();   
    }
    
    public void addNum(int num) {
        
        if(max.isEmpty())
            max.add(num);
        else if(num>max.peek())
        {
            // System.out.println("Adding to min");
            min.add(num);
            if(min.size()>max.size())
            {
                // System.out.println("Shifting "+num+" from min to max");
                max.add(min.poll());
            }
                
        }
        else if(num<=max.peek())
        {
            //  System.out.println("okay");
            max.add(num);
            if(max.size()-min.size()>1)
                min.add(max.poll());
        }
    }
    
    public double findMedian() {
        int currentSize = min.size() + max.size();
        // System.out.println(currentSize+" "+min.peek()+" "+max.peek());
        if(currentSize%2!=0)
            return (double)max.peek();
        return ((double)max.peek()+(double)min.peek())/2.0;
    }
}
