package com.practice.LinkedLists;

/**
 * 
 * @author prerna.dutta
 *
 */

public class SinglyLinkedList {
	public static class Node
	{
		int val;
		Node next;
		Node(){}
		Node(int v)
		{
			val = v;
			next = null;
		}
	}

	Node head;
	public SinglyLinkedList() {
//		if(head == null)
//			head = new Node();
		head=null;
	}
	
	public void insertAtLast(int ele)
	{
		if(head==null)
			head = new Node(ele);
		else
		{
			Node newNode = new Node(ele);
			Node p;
			for(p=head;p.next!=null;p=p.next);
			p.next = newNode;
		}
	}
	public void display()
	{
		Node p;
		for(p=head;p.next!=null;p=p.next)
			System.out.print(p.val+" -> ");
		System.out.println(p.val);
	}
	public void insertAtPositionUsingRecursion(int val, int pos, Node node) {
		Node newNode = new Node(val);
		if(pos==1)
		{
			newNode.next = node.next;
			node.next = newNode;
			return;
		}
		insertAtPositionUsingRecursion(val, pos-1, node.next);
	}
	public static void main(String[] args) {
		SinglyLinkedList ob = new SinglyLinkedList();
		ob.insertAtLast(1);
		ob.insertAtLast(2);
		ob.insertAtLast(3);
		ob.insertAtLast(4);
		ob.display();
		ob.insertAtPositionUsingRecursion(5,2,ob.head);
		ob.display();
	}
}

