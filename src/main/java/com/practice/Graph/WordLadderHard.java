package com.practice.Graph;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/word-ladder/description/
 * 
 * Pg: 307
 */

class WordLadderHard {

	public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(startWord, 1));
		Set<String> st = new HashSet<String>();
		int len = wordList.length;
		for (int i = 0; i < len; i++) {
			st.add(wordList[i]);
		}
		st.remove(startWord);
		while (!q.isEmpty()) {
			String word = q.peek().first;
			int steps = q.peek().second;
			q.remove();

			if (word.equals(targetWord) == true)
				return steps;

			for (int i = 0; i < word.length(); i++) {
				for (char ch = 'a'; ch <= 'z'; ch++) {
					char replacedCharArray[] = word.toCharArray();
					replacedCharArray[i] = ch;
					String replacedWord = new String(replacedCharArray);

					if (st.contains(replacedWord) == true) {
						st.remove(replacedWord);
						q.add(new Pair(replacedWord, steps + 1));
					}
				}

			}
		}
        
        return 0;
    }
	
    public static void main(String[] args) throws IOException {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
            "des",
            "der",
            "dfr",
            "dgt",
            "dfs"
        };

        WordLadderHard obj = new WordLadderHard();
        int ans = obj.wordLadderLength(startWord, targetWord, wordList);

        System.out.print(ans);

        System.out.println();
    }
}

class Pair {
    String first;
    int second;
    Pair(String _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}
