package com.practice.LinkedLists;

import com.practice.LinkedLists.DeleteDuplicates.ListNode;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/reverse-linked-list/description/
 */
public class ReverseLL {

	
	public ListNode reverseList(ListNode head) {
	       if(head==null||head.next==null)return head;
	       ListNode p=head,q;
	       while(p.next!=null)
	       {
	           q=p.next;
	           p.next = q.next;
	           q.next = head;
	           head = q;
	       }
	       return head;
	    }
}
