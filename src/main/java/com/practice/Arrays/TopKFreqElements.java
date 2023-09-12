package com.practice.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/top-k-frequent-words/description/
 */

class Pair implements Comparable<Pair> {
	String s;
	int count;

	Pair(String s, int count) {
		this.s = s;
		this.count = count;
	}

	@Override
	public int compareTo(Pair ob) {
		if (this.count != ob.count)
			return this.count - ob.count;
		else
			return ob.s.compareTo(this.s);
	}
}

class TopKFreqElements {
	public List<String> topKFrequent(String[] words, int k) {
		List<String> res = new ArrayList<>();
		HashMap<String, Integer> hm = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			hm.put(words[i], hm.getOrDefault(words[i], 0) + 1);
		}
		PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (String key : hm.keySet()) {
			pq.add(new Pair(key, hm.get(key)));
		}
		while (k-- > 0) {
			res.add(pq.poll().s);
		}

		return res;
	}
}