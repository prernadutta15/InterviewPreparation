package com.practice.LinkedLists;

import com.practice.LinkedLists.DeleteDuplicates.ListNode;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 */

public class LLCycleII {

	public ListNode detectCycle(ListNode head) 
    {
        ListNode s= findCycle(head);
        ListNode p,q;
        if(s==null)
            return s;
        for(p=head,q=s;p!=q;p=p.next,q=q.next);
        return p;
    }
    public ListNode findCycle(ListNode head)
    {
        ListNode fast=head,slow=head;
        while(fast!=null && fast.next !=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return fast;
        }
        return null;
    }
}
