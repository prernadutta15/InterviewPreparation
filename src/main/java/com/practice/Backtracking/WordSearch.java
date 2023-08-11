package com.practice.Backtracking;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/word-search/description/
 */
public class WordSearch {

	public boolean exist(char[][] board, String word) {
        int i,j;
        for(i=0;i<board.length;i++)
        {
            for(j=0;j<board[0].length;j++)
                if(findWord(board, board.length, board[0].length, i,j,0,word))
                    return true;
        }
        return false;
        
    }

	public boolean findWord(char[][] board, int rowCount, int colCount, int x, int y, int i, String word) 
	{
		if (x < 0 || y < 0 || x >= rowCount || y >= colCount || i >= word.length() || board[x][y] != word.charAt(i))
			return false;
		char ch = board[x][y];
		board[x][y] = '$';

		if (i == word.length() - 1) //vimp condition
			return true;
		boolean ans = findWord(board, rowCount, colCount, x + 1, y, i + 1, word)
				|| findWord(board, rowCount, colCount, x - 1, y, i + 1, word)
				|| findWord(board, rowCount, colCount, x, y + 1, i + 1, word)
				|| findWord(board, rowCount, colCount, x, y - 1, i + 1, word);

		board[x][y] = ch;
		return ans;
	}
}
