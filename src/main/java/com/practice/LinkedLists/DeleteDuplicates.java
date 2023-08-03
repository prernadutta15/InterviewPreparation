package com.practice.LinkedLists;

import lombok.AllArgsConstructor;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 */
public class DeleteDuplicates {

	@AllArgsConstructor
	public class ListNode
	{
		int val;
		ListNode next;
	}
	 public ListNode deleteDuplicates(ListNode head) {
	        if(head==null || head.next==null)return head; //imp
	        
	        ListNode p=head;
	        while(p.next!=null)
	        {
	            if(p.val == p.next.val)
	            {
	                p.next = p.next.next;
	            }
	            else
	                p=p.next;
	        }
	        return head;
	    }
}
