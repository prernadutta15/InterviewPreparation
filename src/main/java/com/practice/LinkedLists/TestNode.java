package com.practice.LinkedLists;

/**
 * 
 * @author prerna.dutta
 *
 */

public class TestNode
{		
	public int val;
	public TestNode next;
	public TestNode(int val, TestNode next) {
		super();
		this.val = val;
		this.next = next;
	}
	public TestNode(int val) {
		super();
		this.val = val;
		this.next = null;
	}
	
}