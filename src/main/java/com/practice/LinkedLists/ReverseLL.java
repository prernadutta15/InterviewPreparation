package com.practice.LinkedLists;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/reverse-linked-list/description/
 */
public class ReverseLL {

	
	public TestNode reverseList(TestNode head) {
	       if(head==null||head.next==null)return head;
	       TestNode p=head,q;
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
