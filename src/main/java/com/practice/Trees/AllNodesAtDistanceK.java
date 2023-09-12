package com.practice.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */
class Node {
	int val;
	Node left, right;

	Node(int v) {
		val = v;
		left = right = null;
	}
}

public class AllNodesAtDistanceK {

	public static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.val + " ");
			inorder(root.right);
		}
	}

	public static Node findPath(List<Node> list, int key, Node root) {
		if (root == null)
			return root;
		if (root.val == key) {
			list.add(root);
			return root;
		}
		Node left = findPath(list, key, root.left);
		Node right = findPath(list, key, root.right);
		if (left == null && right == null)
			return null;
		list.add(root);
		if (left != null)
			return left;
		return right;
	}

	public static void main(String[] args) {
		Node root = new Node(0);
		root.left = new Node(1);
		root.left.left = new Node(3);
		root.left.right = new Node(2);

		int k = 1;
		List<Integer> out = new ArrayList<>();
		List<Node> list = new ArrayList<>();
		findPath(list, 2, root);

		findDistance(list.get(0), out, k);

		for (int i = 1; i < list.size(); i++) {
			Node curr = list.get(i);
			k--;
			if (k == 0) {
				out.add(curr.val);
			} else if (curr.left == list.get(i - 1))
				findDistance(curr.right, out, k - 1);
			else
				findDistance(curr.left, out, k - 1);

		}
		System.out.println(out);
	}
	
	public static void findDistance(Node root, List<Integer> output, int k) {
		
		if(root==null)return;
		if(k==0)
		{
			output.add(root.val);
			return;
		}
		findDistance(root.left, output, k-1);
		findDistance(root.right, output, k-1);
}

}
