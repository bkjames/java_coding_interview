package zcode01;

import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;

class Node{
    int key;
    int value;
    Node pre;
    Node next;
 
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
	
	
    public static void main(String[] args) throws Exception
    {
        LRUCache cache = new LRUCache(2);
        cache.set(1, 1);
        cache.set(2, 2);
        System.out.println(cache.get(1));
        cache.set(3,3);
        System.out.println(cache.get(2));
        cache.set(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
	
	    int capacity;
	    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	    Node head=null;
	    Node end=null;
	 
	    public LRUCache(int capacity) {
	        this.capacity = capacity;
	    }
	 
	    public int get(int key) {
	        if(map.containsKey(key)){
	            Node n = map.get(key);
	            remove(n);
	            setHead(n);
	            return n.value;
	        }
	 
	        return -1;
	    }
	 
	    public void remove(Node n){
	        if(n.pre!=null){
	            n.pre.next = n.next;
	        }else{
	            head = n.next;
	        }
	 
	        if(n.next!=null){
	            n.next.pre = n.pre;
	        }else{
	            end = n.pre;
	        }
	 
	    }
	 
	    public void setHead(Node n){
	        n.next = head;
	        n.pre = null;
	 
	        if(head!=null)
	            head.pre = n;
	 
	        head = n;
	 
	        if(end ==null)
	            end = head;
	    }
	 
	    public void set(int key, int value) {
	        if(map.containsKey(key)){
	            Node old = map.get(key);
	            old.value = value;
	            remove(old);
	            setHead(old);
	        }else{
	            Node created = new Node(key, value);
	            if(map.size()>=capacity){
	                map.remove(end.key);
	                remove(end);
	                setHead(created);
	 
	            }else{
	                setHead(created);
	            }    
	 
	            map.put(key, created);
	        }
	    }
	}



package zExercise01;

import java.util.*;


/**
 * Created by gouthamvidyapradhan on 18/03/2017.
 Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 Follow up:
 Could you do both operations in O(1) time complexity?

 Example:

 LRUCache cache = new LRUCache( 2 /* capacity */ /*);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
        Show Company Tags
        Show Tags
        Show Similar Problems
        */

public class LRUCache {

    public static class DLinkList
    {
        int key, value;
        DLinkList left;
        DLinkList right;
        DLinkList(int key, int value)
        {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Map<Integer, DLinkList> cache;
    private DLinkList head, tail;
    private int capacity, currentSize;

    /**
     * Pop head node
     * @return
     */
    private DLinkList popHead()
    {
        if(!head.right.equals(tail))
        {
            DLinkList node = head.right;
            head.right = node.right;
            node.right.left = head;
            node.right = null;
            node.left = null;
            return node;
        }
        return null;
    }

    /**
     * Push to tail
     * @param node
     */
    private void offer(DLinkList node)
    {
        tail.left.right = node;
        node.left = tail.left;
        node.right = tail;
        tail.left = node;
    }

    /**
     * Move node to tail
     * @param node
     */
    private void moveToTail(DLinkList node)
    {
        node.left.right = node.right;
        node.right.left = node.left;
        offer(node);
    }
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        this.currentSize = 0;
        cache = new HashMap<>();
        head = new DLinkList(-1, -1);
        tail = new DLinkList(-1, -1);
        head.right = tail;
        tail.left = head;
    }

    public int get(int key)
    {
        if(cache.get(key) == null) return -1;
        DLinkList node = cache.get(key);
        moveToTail(node);
        return node.value;
    }

    public void put(int key, int value)
    {
        if(cache.containsKey(key))
        {
            DLinkList node = cache.get(key);
            node.value = value;
            moveToTail(node);
        }
        else
        {
            if(capacity == currentSize)
            {
                DLinkList head = popHead();
                if(head != null)
                {
                    cache.remove(head.key);
                    DLinkList node = new DLinkList(key, value);
                    offer(node);
                    cache.put(key, node);
                }
            }
            else
            {
                DLinkList node = new DLinkList(key, value);
                offer(node);
                cache.put(key, node);
                ++currentSize;
            }
        }
    }
}
