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
 * https://leetcode.com/problems/non-overlapping-intervals/
 */

public class NonOverlappingIntervals {

	class Interval implements Comparable<Interval> {
		int start, end;

		Interval() {
			start = end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public int compareTo(Interval ob) {
			return (this.end - ob.end);
		}
	}

	public int eraseOverlapIntervals(int[][] intervals) {
		int n = intervals.length, i, count = 0;
		List<Interval> list = new ArrayList<>();
		for (i = 0; i < n; i++)
			list.add(new Interval(intervals[i][0], intervals[i][1]));
		Collections.sort(list);
		Interval prev = list.get(0);
		for (i = 1; i < n; i++) {
			if (list.get(i).start >= prev.end) {
				prev = list.get(i);
			} else
				count++;
		}
		return count;
	}
}
