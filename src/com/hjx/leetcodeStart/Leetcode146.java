package com.hjx.leetcodeStart;

import java.util.Map;
import java.util.HashMap;


public class Leetcode146 {

}

class LRUCache{
    private Node head = null;
    private Node tail = null;
    private Map<Integer, Node> map = new HashMap<Integer, Node>();
    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node t = map.get(key);
        removeNode(t);
        offerNode(t);
        return t.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node t = map.get(key);
            t.value = value;
            removeNode(t);
            offerNode(t);
        }
        else if(size < capacity){
            Node t = new Node(key, value);
            offerNode(t);
            map.put(key, t);
            size ++;
        }
        else{
            map.remove(head.key);
            removeNode(head);
            Node t = new Node(key, value);
            offerNode(t);
            map.put(key, t);
        }

    }



    public void offerNode(Node n){
        if(tail != null){
            tail.next = n;
        }
        n.prev = tail;
        tail = n;
        if(head == null){
            head = tail;
        }

    }

    public void removeNode(Node n){
        if(n.prev != null){
            n.next.prev = n.prev;
        }
        else{
            head = n.next;
            head.prev = null;
        }

        if(n.next != null){
            n.prev.next = n.next;
        }
        else{
            tail = n.prev;
            tail.next = null;
        }

    }
}

class Node{
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
