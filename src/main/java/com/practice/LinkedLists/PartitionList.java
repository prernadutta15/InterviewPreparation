package com.practice.LinkedLists;



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
		public ListNode(int val) {
			super();
			this.val = val;
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
	
	public ListNode partitionList(ListNode A, int B) 
    {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode b1, b2, p;
        dummy1.next = dummy2;
        dummy2.next = A;
        b1 = dummy1;
        b2 = dummy2;
        p=A;
        for(p=A;p!=null;p=p.next)
        {
            if(p.val<B)
            {
                b1.next = p;
                b1=p;
            }
            else
            {
                b2.next = p;
                
                b2=p;
            }
        }
        b2.next = null;
        b1.next = dummy2.next;
        return dummy1.next;
    }
}
