package com.practice.LinkedLists;

import com.practice.LinkedLists.DeleteDuplicates.ListNode;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * Given a singly linked list A

 A: A0 → A1 → … → An-1 → An 
reorder it to:

 A0 → An → A1 → An-1 → A2 → An-2 → … 
You must do this in-place without altering the nodes' values.
 */
public class ReorderList {

	public ListNode reorderList(ListNode head) 
    {
        ListNode fast = head,slow = head;
        for(;fast.next!=null && fast.next.next!=null;slow = slow.next, fast=fast.next.next);
        ListNode head2= slow.next;
        slow.next=null;
        //reverse 2nd list 
        head2 = reverseList(head2);
        ListNode p=head,q=head2,r,s;
        while(p!=null && q!=null)
        {
            r=p.next;
            s=q.next;
            p.next=q;
            q.next=r;
            p=r;
            q=s;
        }
        return head;
    }
    public ListNode reverseList(ListNode head) 
    {
        ListNode p=head,q;
        if(head==null || head.next==null)
            return head;
        while(p.next!=null)
        {
            q=p.next;
            p.next=q.next;
            q.next=head;
            head=q;
        }
        return head;
    }
}
