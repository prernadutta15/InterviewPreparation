package com.practice.LinkedLists;

import com.practice.LinkedLists.DeleteDuplicates.ListNode;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */

public class RemoveNthEndFromList {

	public ListNode removeNthFromEnd(ListNode head, int B) {
        int i;
       ListNode p=head,q=head;
       for(i=1;i<=B && p!=null;i++)
           p=p.next;
       if(p==null)
       {
           //this edge case is important for [1]
           return head.next;
       }
       for(q=head;p!=null && p.next!=null;p=p.next,q=q.next);
      
       q.next = q.next.next;
      
       return head;
   }
}
