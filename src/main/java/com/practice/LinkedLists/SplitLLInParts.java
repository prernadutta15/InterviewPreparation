package com.practice.LinkedLists;

import com.practice.LinkedLists.SinglyLinkedList.Node;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/split-linked-list-in-parts/description
 *  
 * Pg: 302 explained
 */
public class SplitLLInParts {

	public Node[] splitListToParts(Node head, int k) {
        Node result[] = new Node[k];
        if(head==null)return result;
        int i,c;
        int totalCount = countTotalNodesInList(head);
        int nodesPerBucket = totalCount/k;
        int extraNodes = totalCount%k;
        Node cur=head, prev=null;
        for(i=0;i<k;i++)
        {
            result[i]=cur;
            for(c=1;c<=nodesPerBucket+(extraNodes>0?1:0);c++)
            {
                prev=cur;
                cur=cur!=null?cur.next:null;
                if(cur==null)return result;
            }
            prev.next = null;
            extraNodes--;
        }
        return result;
    }
    int countTotalNodesInList(Node head)
    {
        int c=0;
        Node p = head;
        for(;p!=null;p=p.next,c++);
        return c;
    }
}
