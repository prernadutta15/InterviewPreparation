package com.practice.LinkedLists;

import com.practice.LinkedLists.DeleteDuplicates.ListNode;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LLCycle {

	 public boolean hasCycle(ListNode head) {
        ListNode fast=head,slow=head;
        if(head==null || head.next==null)
            return false;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
            {
                return true;
            }
        }
        return false;
    }
}
