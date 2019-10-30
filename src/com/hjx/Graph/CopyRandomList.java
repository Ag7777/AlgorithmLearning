package com.hjx.Graph;
/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.
 */

import java.util.Map;
import java.util.HashMap;

//class Node{
//    int val;
//    GraphNode next;
//    GraphNode random;
//    Node(){};
//    Node(int val){
//        this.val = val;
//    }
//}
//public class CopyRandomList {
//    public GraphNode copyRandomList(GraphNode head) {
//        if(head == null) return null;
//        GraphNode dumy = new GraphNode(0);
//        GraphNode tail = dumy;
//        GraphNode h = head;
//        Map<GraphNode, GraphNode> map = new HashMap<GraphNode, GraphNode>();
//        while(h != null){
//            GraphNode tmp = new GraphNode(h.val);
//            tmp.random = h.random;
//            tail.next = tmp;
//            map.put(h, tail);
//            tail = tmp;
//            h = h.next;
//        }
//        h = dumy.next;
//        while(h != null){
//            if(h.random != null) {
//                h.random = map.get(h.random);
//            }
//            h = h.next;
//        }
//        return dumy.next;
//    }
//
//    public GraphNode copyRandomList1(GraphNode head){
//        if(head == null) return null;
//        GraphNode h = head;
//        //拷贝每个节点
//        while(h != null){
//            GraphNode tmp = new GraphNode(h.val);
//            tmp.random = h.random;
//            GraphNode next = h.next;
//            tmp.next = next;
//            h.next = tmp;
//            h = next;
//        }
//        //调整random指针
//        h = head.next;
//        while(h != null){
//            if(h.random != null) h.random = h.random.next;
//            if(h.next == null) break;
//            h = h.next.next;
//        }
//
//        GraphNode dumy = new GraphNode(0);
//        GraphNode tail = dumy;
//        h = head;
//        while(h != null){
//            GraphNode tmp = h.next;
//            tail.next = tmp;
//            tail = tail.next;
//            h.next =tmp.next;
//            h = h.next;
//        }
//        return dumy.next;
//    }
//}
