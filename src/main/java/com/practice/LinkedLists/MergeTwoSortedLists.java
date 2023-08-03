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

	public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode res = null;
        if(A==null)return B;
        if(B==null)return A;
        if(A.val<B.val)
        {
            res = A;
            res.next = mergeTwoLists(A.next, B);
        }
        else
        {
            res = B;
            res.next = mergeTwoLists(A, B.next);
        }
        return res;
    }
}
