package com.practice.LinkedLists;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 */
public class CopyNodeWithRandomPointer {

	public static class Node
	{
		int val;
		Node next;
		Node random;
		Node(){}
		Node(int v)
		{
			val = v;
			next = null;
			random = null;
		}
	}
	
	public Node copyRandomListFirstWayUsingMap(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node cur=head, prev=null, newHead = null;
        while(cur!=null)
        {
            Node temp = new Node(cur.val);
            map.put(cur, temp);
            if(newHead==null)
            {
                newHead = prev = temp;
            }
            else
            {
                prev.next = temp;
                prev = temp;
            }
            cur = cur.next;
        }
        cur = head;
        prev = newHead;
        while(cur!=null)
        {
            prev.random = map.get(cur.random);
            cur = cur.next;
            prev = prev.next;
        }
        return newHead;
    }
	
	public Node copyRandomListUsingConstantSpace(Node head) {
		
        if(head==null)return null;
        
        //insert or intertwine nodes
        Node cur,curNext;
        cur = head;
        while(cur!=null)
        {
            curNext = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = curNext;
            cur = curNext;
        }

        //copy random pointers
        cur=head;
        while(cur!=null)
        {
            if(cur.random==null)
                cur.next.random = null;
            else
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        //separate out nodes
        Node newHead = head.next, newCur = newHead;
        cur = head;
        while(cur!=null && newCur!=null)
        {
            cur.next = cur.next==null?null:cur.next.next;
            newCur.next = newCur.next==null?null:newCur.next.next;
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }
}
