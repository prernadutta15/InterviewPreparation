package com.practice.Tries;

/**
 * 
 * @author prerna.dutta
 *
 */

public class SpellingChecker {

	class Node
    {
        Node children[];
        boolean isEnd;
        Node()
        {
            children = new Node[26];
            isEnd = false;
        }
    }
    public int[] solve(String[] A, String[] B) 
    {
        Node head = new Node();
        int out[]=new int[B.length];
        int k=0;
        for(int i=0;i<A.length;i++)
        {
            head = insertToTrie(A[i], head);
        }
        for(int i=0;i<B.length;i++)
        {
            if(search(B[i],head))
                out[k++]=1;
            else
                out[k++]=0;
        }
        return out;
    }
    Node insertToTrie(String s, Node root)
    {
        Node cur = root;
        for(int i=0;i<s.length();i++)
        {
            int index = s.charAt(i)-'a';
            if(cur.children[index] == null)
                cur.children[index] = new Node();
            cur = cur.children[index];
        }
        cur.isEnd = true;
        return root;
    }
    boolean search(String s, Node root)
    {
        Node cur = root;
        for(int i=0;i<s.length();i++)
        {
            int index = s.charAt(i)-'a';
            if(cur.children[index]==null)
                return false;
            cur = cur.children[index];
        }
        return cur.isEnd;
    }
}

