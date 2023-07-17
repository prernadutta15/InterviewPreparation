package com.practice.LinkedLists;

import java.util.Stack;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 */

public class AddTwoNumbers {

	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1!=null)
        {
            s1.push(l1.val);
            l1=l1.next;
        }

        while(l2!=null)
        {
            s2.push(l2.val);
            l2=l2.next;
        }
        int sum=0,carry=0;
        ListNode head = null, start = null;
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            int val1 = s1.isEmpty()?0:s1.pop();
            int val2 = s2.isEmpty()?0:s2.pop();
            sum = val1 + val2 + carry;
            start = new ListNode(sum%10);
            start.next = head;
            head = start;
            carry = sum/10;
        }
        if(carry!=0)
        {
            start = new ListNode(carry);
            start.next = head;
            head = start;
        }
        return head;
    }
}
