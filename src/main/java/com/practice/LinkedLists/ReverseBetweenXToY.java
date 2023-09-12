package com.practice.LinkedLists;

/**
 * 
 * @author prerna.dutta
 *
 */

public class ReverseBetweenXToY {

	/*
	 * Reverse a linked list A from position B to C.

NOTE: Do it in-place and in one-pass.



Problem Constraints
1 <= |A| <= 106

1 <= B <= C <= |A|



Input Format
The first argument contains a pointer to the head of the given linked list, A.

The second arugment contains an integer, B.

The third argument contains an integer C.



Output Format
Return a pointer to the head of the modified linked list.



Example Input
Input 1:

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 2
 C = 4

Input 2:

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 1
 C = 5


Example Output
Output 1:

 1 -> 4 -> 3 -> 2 -> 5
Output 2:

 5 -> 4 -> 3 -> 2 -> 1

	 */
	public TestNode reverseBetween(TestNode head, int start, int end) 
    {
        /*Logic: we bring element to be reversed at the front of the list, so we 
        maintain before, cur and after pointers for the same. First we delete the after pointer, 
        and then insert it to the front pointer, ie, after the before pointer
        */
        if(head==null || start>=end)
            return head;
        
        TestNode dummy = new TestNode(-1);
        dummy.next = head;
        TestNode before = dummy, cur, after;
        for(int pos = 1; pos< start; pos++)
            before = before.next;
        cur = before.next;
        after = cur.next;
        while(start<end)
        {
            after = cur.next;
            cur.next = after.next; //deleted after 
            after.next = before.next; //inserted after at starting
            before.next = after;
            start++;
        }
        return dummy.next;
    }
}
