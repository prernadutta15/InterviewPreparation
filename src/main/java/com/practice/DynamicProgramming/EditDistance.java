package com.practice.DynamicProgramming;

import java.util.Arrays;

/**
 * 
 * @author prerna.dutta
 *
 */

public class EditDistance {

	public int minDistance(String A, String B) {

        int N=A.length();
        int M=B.length();
        int memoryArr[][]=new int[N][M];
        for(int[] row:memoryArr){
            Arrays.fill(row,-1);
        }
        return editDistance(A,B,memoryArr,N-1,M-1);
    }

    private int editDistance(String A, String B,int[][] memoryArr, int la,int lb){
        if(la<0){
            return lb+1;
        }
        if(lb<0){
            return la+1;
        }
        if(memoryArr[la][lb]!=-1){
            return memoryArr[la][lb];
        }
        if(A.charAt(la)==B.charAt(lb)){
            memoryArr[la][lb]=editDistance(A,B,memoryArr,la-1,lb-1);
        }else{
            int insert =1+editDistance(A,B,memoryArr,la,lb-1);
            int update =1+editDistance(A,B,memoryArr,la-1,lb-1);
            int delete =1+editDistance(A,B,memoryArr,la-1,lb);

            memoryArr[la][lb]=min(insert,update,delete);
        }
        return memoryArr[la][lb];
    }

    private int min(int a,int b,int c){
        int temp=a<b?a:b;
        return temp<c?temp:c;
    }
}
