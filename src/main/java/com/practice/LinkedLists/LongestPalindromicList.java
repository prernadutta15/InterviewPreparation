package com.practice.LinkedLists;

import com.practice.LinkedLists.DeleteDuplicates.ListNode;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * Given a linked list of integers. Find and return the length of the longest palindrome list that exists in that linked list.

A palindrome list is a list that reads the same backward and forward.


Input 1:
 2 -> 3 -> 3 -> 3
 
Output 1:
 3
 
Input 2:
 2 -> 1 -> 2 -> 1 ->  2 -> 2 -> 1 -> 3 -> 2 -> 2

Output 2:
 5
 */
public class LongestPalindromicList {

	public int solve(ListNode head) {
        ListNode r=null,p=head,q=p.next;
        int ans = 1;
        while(p.next!=null)
        {
            q = p.next;
            p.next = r;
            ans = Math.max(ans,2*countPalindromes(r,q)+1);//odd length
            ans = Math.max(ans,2*countPalindromes(p,q));//even length

            r=p;
            p=q;
        }
        return ans;
    }
    public int countPalindromes(ListNode backward,ListNode forward)
    {
        int c=0;
        while(backward!=null && forward!=null)
        {
            if(forward.val==backward.val)
                c++;
            else
                break;
            backward=backward.next;
            forward=forward.next;
        }
        return c;
    }
}
