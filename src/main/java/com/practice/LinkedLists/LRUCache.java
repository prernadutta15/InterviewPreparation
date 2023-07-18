package com.practice.LinkedLists;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author prerna.dutta
 *
 */

public class LRUCache {
    
    int capacity;
    public class Node
    {
        int key;
        int value;
        Node next;
        Node prev;
        Node()
        {
        }
        Node(int k,int v)
        {
            key = k;
            value = v;
        }
    }
    Node tail,head;
    Map<Integer,Node> cacheMap;
    public void addFirst(Node node)
    {
        Node nbr = head.next;
        head.next = node;
        node.prev = head;
        node.next = nbr;
        nbr.prev = node;
    }
    public Node removeLast()
    {
        Node toBeDeleted = tail.prev;
        Node prevNode = toBeDeleted.prev;
        prevNode.next = tail;
        tail.prev = prevNode;
        toBeDeleted.prev = toBeDeleted.next = null;
        return toBeDeleted;
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail = new Node(-1,-1);
        head = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        cacheMap = new HashMap<Integer,Node>();
    }
    public void removeNode(Node node)
    {
       Node prevNode = node.prev;
       Node nextNode = node.next;
       prevNode.next = nextNode;
       nextNode.prev = prevNode;
       node.prev = node.next = null;
    }
    
    public int get(int key) 
    {
        Node node = cacheMap.get(key);
        if(node == null)
            return -1;
        removeNode(node);
        addFirst(node);
        return node.value;
    }
    
    public void set(int key, int value) 
    {
       Node node = cacheMap.get(key);
       if(node == null)
       {
           Node newNode = new Node(key,value);
           if(cacheMap.size() == capacity)
           {
               Node last = removeLast();
               cacheMap.remove(last.key);
           }
           addFirst(newNode);
           cacheMap.put(key,newNode);
       }
       else
       {
           node.value = value;
           removeNode(node);
           addFirst(node);
       }
    }
}
