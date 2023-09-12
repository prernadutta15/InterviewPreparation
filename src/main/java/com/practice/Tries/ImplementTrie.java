package com.practice.Tries;

/**
 * 
 * @author prerna.dutta
 *
 */
/*
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 */
public class ImplementTrie {

    Node root;
    public class Node
    {
        Node children[];
        boolean isEnd;
        Node()
        {
            children = new Node[26];
            isEnd = false;
        }
    
    }
    public ImplementTrie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node cur = root;
        for(int i=0;i<word.length();i++)
        {
            int index = word.charAt(i)-'a';
            if(cur.children[index]==null)
            {
                cur.children[index]=new Node();
            }
            cur = cur.children[index];
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        Node cur = root;
        for(int i=0;i<word.length();i++)
        {
            int index = word.charAt(i)-'a';
            if(cur.children[index]==null)
                return false;
            cur=cur.children[index];
        }
        return cur.isEnd;
    }
    
    public boolean startsWith(String prefix) {
         Node cur = root;
        for(int i=0;i<prefix.length();i++)
        {
            int index = prefix.charAt(i)-'a';
            if(cur.children[index]==null)
                return false;
            cur=cur.children[index];
        }
        return true;
    }
	
}
