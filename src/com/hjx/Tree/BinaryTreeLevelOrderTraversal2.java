package com.hjx.Tree;
/*
Share
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;


public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(Node root){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < size; i ++){
                Node current = q.poll();
                list.add(current.val);
                for(Node node : current.children){
                    q.offer(node);
                }
            }
            res.add(list);
        }
        return res;
    }

    class Node {
        public int val;
        public List<Node> children;
        public Node(){}
        public Node(int val){
            this.val = val;
        }
    }
}

