package com.practice.DynamicProgrammingRevision.Phase1;
import java.util.Scanner;

/*
 * https://atcoder.jp/contests/dp/tasks/dp_b
 */

public class Q3FrogJump2 {

	//N K
	//h1 h2 ... hN
	
	//example_1 -> 	5 3
	//				10 30 40 50 20
	//output -> 30

	//example_2 -> 	3 1
	//				10 20 10
	//output -> 20
	
	//example_3 -> 	2 100
	//				10 10
	//output -> 0
	
	//example_3 -> 	10 4
	//				40 10 20 70 80 10 20 70 80 60
	//output -> 40
	
	//Okay
	public static void main(String[] args) {
		
	    Scanner scanner = new Scanner(System.in);
	    int n = scanner.nextInt();
	    int k = scanner.nextInt();

	    int[] b = new int[n];
	    for (int i=0; i<n; i++)
	        b[i] = scanner.nextInt();
	    
	    //System.out.println(frongJump2Recursion(b, n-1, k));
	    //System.out.println(frongJump2TopDown(b, n-1, k));
	    System.out.println(frongJump2BottomUp(b, n-1, k));
	}
	
	// Recursion
	public static int frongJump2Recursion(int[] b, int index, int k) {
		if(index == 0) return 0;
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=k; i++) {
			if(index>=i)
				min = Math.min(min, frongJump2Recursion(b, index-i, k) + Math.abs(b[index] - b[index-i]));
		}
		return min;
	}
	
	// Top down
	public static int frongJump2TopDown(int[] b, int n, int k) {
	    int[] dp = new int[n+1];
	    for(int i=0; i<=n; i++)
	      dp[i] = -1;
	    return frongJump2TopDownHelper(b, dp, n, k);
	}
	
	public static int frongJump2TopDownHelper(int[] b, int[] dp, int n, int k) {
		if(n == 0) return 0;
		if(dp[n] != -1)
			return dp[n];
		dp[n] = Integer.MAX_VALUE;
		for(int i=1; i<=k; i++) {
			if(n>=i)
				dp[n] = Math.min(dp[n], frongJump2TopDownHelper(b, dp, n-i, k) + Math.abs(b[n] - b[n-i]));
		}
		return dp[n];
	}
   
    // Bottom up
	public static int frongJump2BottomUp(int[] b, int n, int k) {
		if(n == 0) return 0;
	    int[] dp = new int[n+1];
	    dp[0] = 0;
	    for(int i=1; i<=n; i++) {
			dp[i] = Integer.MAX_VALUE;
			for(int j=1; j<=k && i>=j; j++)
				dp[i] = Math.min(dp[i], dp[i-j] + Math.abs(b[i] - b[i-j]));
	    }
		return dp[n];
	}
}