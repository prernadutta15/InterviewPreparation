package com.practice.Tries;

/**
 * 
 * @author prerna.dutta
 *
 */

public class ShortestUniquePrefix {

	class Node
    {
        char data;
        Node children[];
        boolean isEnded;
        int count;
        Node(char d)
        {
            data = d;
            children = new Node[26];
            isEnded = false;
            count = 0;
        }
    }
    public String[] prefix(String[] A) 
    {
        Node head = new Node('#');
        int i,j;
        String s;
        String out[]=new String[A.length];
        for(i=0;i<A.length;i++)
            head = insertToTrie(A[i],head);
        for(i=0;i<A.length;i++)
        {
            out[i] = search(A[i],head);
        }
        return out;
    }
    String search(String s, Node root)
    {
        Node cur = root,child;
        int j;
        String ans="";
        for(j=0;j<s.length();j++)
        {
            int index = s.charAt(j) - 'a';
            child = cur.children[index];
            if(child.count!=1)
            {
                ans += child.data;
                cur = child;
            }
            else
            {
                ans += child.data;
                return ans;
            }
            
        }
        return ans;
    }
    Node insertToTrie(String s, Node root)
    {
        Node cur = root;
        for(int i=0;i<s.length();i++)
        {
            int index = s.charAt(i)-'a';
            if(cur.children[index] == null)
            {
                cur.children[index] = new Node( s.charAt(i));
                // cur.count = 1;
            }
            else
            {
                cur.count = cur.count + 1;
            }
            cur = cur.children[index];
            cur.count = cur.count + 1;
        }
        cur.isEnded = true;
        return root;
    }
}
