package com.practice.LinkedLists;

import com.practice.LinkedLists.DeleteDuplicates.ListNode;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoLL {

	public ListNode getIntersectionNode(ListNode A, ListNode B) {
        int countA=0,countB=0;
        ListNode p=null;
        for(p=A;p!=null;p=p.next, countA++);
        for(p=B;p!=null;p=p.next, countB++);
        if(countA>countB)
        {
            p=A;
            int x = countA-countB;
            while(x-->0)
            {
                p=p.next;
            }
            for(ListNode q = B;p!=q;p=p.next,q=q.next);
            return p;
        }
        else
        {
            p=B;
            int x = countB-countA;
            while(x-->0 && p!=null)
            {
                p=p.next;
            }
            for(ListNode q = A;p!=q;p=p.next,q=q.next);
            return p;
        }

    }
}
