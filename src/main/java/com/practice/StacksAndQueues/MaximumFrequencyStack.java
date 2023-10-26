package com.practice.StacksAndQueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/maximum-frequency-stack/description/
 */

public class MaximumFrequencyStack {
	Map<Integer,Stack<Integer>> map;
    Map<Integer,Integer> freqMap;
    int maxFreq=1;
    public MaximumFrequencyStack() {
        map = new HashMap<>();
        freqMap = new HashMap<>();
        maxFreq=0;
    }
    
    public void push(int val) {
        int freq = freqMap.getOrDefault(val,0)+1;
        maxFreq = Math.max(maxFreq,freq);
        freqMap.put(val, freq);
        Stack<Integer> stack = map.get(freq);
        if(stack == null)
            stack = new Stack<>();
        stack.push(val);
        map.put(freq,stack); //required
    }
    
    public int pop() {
       Stack<Integer> stack = map.get(maxFreq);
       
       int ele = stack.pop();
       if(stack.isEmpty()){
           map.remove(maxFreq);
           maxFreq--;
       }
       /*
        * no need of else because stack gets updated
        */
//       else
//       map.put(maxFreq, stack);
       int freq = freqMap.get(ele)-1;

       if(freq==0)
       {
           freqMap.remove(ele);
       }else
            freqMap.put(ele,freq);
       return ele;
    }
    public static void main(String[] args) {
		System.out.println("ok");
	}
}
