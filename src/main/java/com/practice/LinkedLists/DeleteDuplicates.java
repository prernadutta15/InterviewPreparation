package com.practice.LinkedLists;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 */


public class DeleteDuplicates {

	public  class ListNode
	{		
		public int val;
		public ListNode next;
		public ListNode(int val, ListNode next) {
			super();
			this.val = val;
			this.next = next;
		}
		public ListNode(int val) {
			super();
			this.val = val;
			this.next = null;
		}
		
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
