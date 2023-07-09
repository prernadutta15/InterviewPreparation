package com.practice.StacksAndQueues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaximumWindow 
{
	/*
	 * Problem Description Given an array of integers A. There is a sliding window
	 * of size B, moving from the very left of the array to the very right. You can
	 * only see the B numbers in the window. Each time the sliding window moves
	 * rightwards by one position. You have to find the maximum for each window.
	 * 
	 * Return an array C, where C[i] is the maximum value in the array from A[i] to
	 * A[i+B-1].
	 * 
	 * Refer to the given example for clarity.
	 * 
	 * NOTE: If B > length of the array, return 1 element with the max of the array.
	 * 
	 * 
	 * 
	 * Problem Constraints 1 <= |A|, B <= 106
	 * 
	 * 
	 * 
	 * Input Format The first argument given is the integer array A.
	 * 
	 * The second argument given is the integer B.
	 * 
	 * 
	 * 
	 * Output Format Return an array C, where C[i] is the maximum value of from A[i]
	 * to A[i+B-1].
	 * 
	 * 
	 * 
	 * Example Input Input 1:
	 * 
	 * A = [1, 3, -1, -3, 5, 3, 6, 7] B = 3 
	 * 
	 * Example Output Output 1:
	 * [3, 3, 5, 5, 6, 7] 
	 * Example Explanation Explanation 1:
	 * 
	 *Window position     | Max
	 --------------------|-------
	 [1 3 -1] -3 5 3 6 7 | 3
	 1 [3 -1 -3] 5 3 6 7 | 3
	 1 3 [-1 -3 5] 3 6 7 | 5
	 1 3 -1 [-3 5 3] 6 7 | 5
	 1 3 -1 -3 [5 3 6] 7 | 6
	 1 3 -1 -3 5 [3 6 7] | 7
	 * 
	 * 
	 * Input 2:
	 * 
	 * A = [1, 2, 3, 4, 2, 7, 1, 3, 6] B = 6
	 * 
	 * Output 2:
	 * [7, 7, 7, 7]
	 * 
	 *  Window position     | Max
	 --------------------|-------
	 [1 2 3 4 2 7] 1 3 6 | 7
	 1 [2 3 4 2 7 1] 3 6 | 7
	 1 2 [3 4 2 7 1 3] 6 | 7
	 1 2 3 [4 2 7 1 3 6] | 7
	 * 
	 * 
	 */
	 public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
	        ArrayList<Integer> a=new ArrayList<Integer>();
	        if(B>A.size()) return a;
	        Deque<Integer> q=new LinkedList<Integer>();
	        for(int i=0;i<B;i++){
	            updateDeque(q,(int)A.get(i));   
	        }
	        a.add(q.peekFirst());
	        for(int s=1,e=B;e<A.size();s++,e++){
	           
	            int incoming=A.get(e);
	            updateDeque(q,incoming);
	           
	            int outgoing=A.get(s-1);
	            if(outgoing==q.peekFirst()) q.pollFirst();

	            a.add(q.peekFirst());
	            
	        }
	        return a;
	    }
	    private void updateDeque(Deque<Integer> s, int temp){
	        while(!s.isEmpty() && s.peekLast()<temp){
	            s.pollLast();
	        }
	        s.addLast(temp);
	    }
}
