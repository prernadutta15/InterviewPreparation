package com.practice.LinkedLists;

import com.practice.LinkedLists.DeleteDuplicates.ListNode;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

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
	
	public ListNode mergeTwoLists2(ListNode A, ListNode B) {
        ListNode res = null;
        if(A==null)return B;
        if(B==null)return A;
        if(A.val<B.val)
        {
            res = A;
            res.next = mergeTwoLists2(A.next, B);
        }
        else
        {
            res = B;
            res.next = mergeTwoLists2(A, B.next);
        }
        return res;
    }
}
