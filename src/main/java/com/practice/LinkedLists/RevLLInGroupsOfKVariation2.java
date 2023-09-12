package com.practice.LinkedLists;


/**
 * 
 * @author prerna.dutta
 *
 */

/*
 *  A = [1, 2, 3, 4, 5]
 *  B = 3
 *  
 *  Output: [3, 2, 1, 5, 4]
 */
public class RevLLInGroupsOfKVariation2 {

	public TestNode reverseKGroup(TestNode head, int B) {
		if(head==null)
	        return head;
        TestNode p=head,q=head,r=null;
        int i=0;
        while(i<B && p!=null)
        {
            q=p.next;
            p.next=r;
            r=p;
            p=q;
            i++;
        }
        
        head.next = reverseKGroup(p,B);

        return r;
	}
}
