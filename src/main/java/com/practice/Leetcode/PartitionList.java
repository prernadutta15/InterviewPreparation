package com.practice.Leetcode;



/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/partition-list/description/
 */
public class PartitionList {

	public class ListNode
	{		
		public int val;
		public ListNode next;
		public ListNode(int val, ListNode next) {
			super();
			this.val = val;
			this.next = next;
		}
		
		
	}
	public ListNode partition(ListNode head, int x) {
		
	       ListNode lessThanXHead = new ListNode(0, null);// Dummy node for nodes < x
	        ListNode lessThanX = lessThanXHead;

	        ListNode greaterThanOrEqualToXHead = new ListNode(0, null); // Dummy node for nodes >= x
	        ListNode greaterThanOrEqualToX = greaterThanOrEqualToXHead;

	        while (head != null) {
	            if (head.val < x) {
	                lessThanX.next = head;
	                lessThanX = lessThanX.next;
	            } else {
	                greaterThanOrEqualToX.next = head;
	                greaterThanOrEqualToX = greaterThanOrEqualToX.next;
	            }
	            head = head.next;
	        }

	        greaterThanOrEqualToX.next = null; // Disconnect from the nodes >= x
	        lessThanX.next = greaterThanOrEqualToXHead.next; // Attach the two partitions

	        return lessThanXHead.next; // The new head after partitioning

	    }
}
