package com.practice.LinkedLists;

import com.practice.DynamicProgramming.UniqueBSTsII.TreeNode;
import com.practice.LinkedLists.DeleteDuplicates.ListNode;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 */
public class ConvertSortedListToBSTree {

	public TreeNode sortedListToBST(ListNode head) {
        return makeTree(head);
    }

    TreeNode makeTree(ListNode head) {
        if(head==null)return null;
        if(head.next==null)return new TreeNode(head.val);
        ListNode slow=head, fast = head, slow_prev = null;
        while(fast!=null && fast.next!=null)
        {
            slow_prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        slow_prev.next = null;
        root.left = makeTree(head);
        root.right = makeTree(slow.next);
        slow.next = null;
        return root;
    }
}
