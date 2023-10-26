package com.practice.StacksAndQueues;

import java.util.Stack;

/*
 * https://leetcode.com/problems/find-the-town-judge/description/
 */
public class CelebrityProblem {

	public int findJudge(int n, int[][] trust) {
        int[][] mat = new int[n + 1][n + 1];

        for (int i = 0; i < trust.length; i++) {
            mat[trust[i][0]][trust[i][1]] = 1;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= n; i++) 
        	stack.push(i);

        while (stack.size() > 1) {
            int first = stack.pop();
            int second = stack.pop();

            if (mat[first][second] == 1) {
                stack.push(second);
            } else {
                stack.push(first);
            }
        }
        int potential = stack.peek();
        for (int i=1;i<= n;i++) {
            if(i!=potential)
            {
                if (mat[potential][i] == 1 || mat[i][potential]==0) 
                    return -1;
            }
        }
        return potential;
    }
}
