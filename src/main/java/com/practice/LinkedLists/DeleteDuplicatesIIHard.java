package com.practice.LinkedLists;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;

/**
 * 
 * @author prerna.dutta
 *
 */

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 */
public class DeleteDuplicatesIIHard {
	
	@AllArgsConstructor
	public class ListNode
	{
		int val;
		ListNode next;
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		Set<Integer> set = new HashSet<>();
		return deleteBuild(head, set);
	}
	
	public ListNode deleteBuild(ListNode head, Set<Integer> set)
	{
		boolean isBuild = false;
		while(head!=null)
		{
			if(head.next!=null)
			{
				if(head.val!=head.next.val && !set.contains(head.val))
					isBuild=true;
				else 
					set.add(head.val);
			}
			else
			{
				if(!set.contains(head.val))
					isBuild = true;
			}
			
			if(isBuild)
			{
				return new ListNode(head.val, deleteBuild(head.next, set));
			}
			else
				head = head.next;
		}
		return null;
	}
	
}
