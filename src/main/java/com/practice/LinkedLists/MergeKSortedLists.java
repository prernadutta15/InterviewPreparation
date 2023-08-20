package com.practice.LinkedLists;

import com.practice.LinkedLists.DeleteDuplicates.ListNode;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {

	 public ListNode mergeKLists(ListNode[] lists) {
	        return mergeKLists(lists, 0, lists.length-1);
	    }

	    ListNode mergeKLists(ListNode[] lists, int start, int end)
	    {
	        if(start>end)return null;
	        if(start==end)return lists[start];

	        int mid = start+(end-start)/2;
	        ListNode left = mergeKLists(lists, start, mid);
	        ListNode right = mergeKLists(lists, mid+1, end);
	        ListNode mergedOutput = mergeTwoLists(left, right);
	        return mergedOutput;
	    }

	    ListNode mergeTwoLists(ListNode left, ListNode right)
	    {
	        if(left==null && right==null)return null;
	        if(left==null)return right;
	        if(right==null)return left;
	        if(left.val<right.val)
	        {
	            left.next = mergeTwoLists(left.next, right);
	            return left;
	        }
	        else
	        {
	            right.next = mergeTwoLists(left, right.next);
	            return right;
	        }
	    }
}
