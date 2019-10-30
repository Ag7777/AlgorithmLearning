package com.hjx.Tree;

/*
589. N-ary Tree Preorder Traversal
Given an n-ary tree, return the preorder traversal of its nodes' values.
For example, given a 3-ary tree:
 */
import java.util.List;
import java.util.ArrayList;
class Node{
    public int val;
    List<Node> children;
    public Node(){}
    public Node(int val, List<Node> children){
        this.val = val;
        this.children = children;
    }
}
public class NaryTreeTraversal {
    public List<Integer> preorder(Node root) {
        if(root == null) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        preOrderDFS(root, res);
        return res;
    }

    public void preOrderDFS(Node root, List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        for(Node n : root.children){
            preOrderDFS(n, res);
        }
    }

    public List<Integer> postorder(Node root) {
        if(root == null) return new ArrayList();
        List<Integer> res = new ArrayList<Integer>();
        postOrderDFS(root, res);
        return res;
    }

    public void postOrderDFS(Node root, List<Integer> res){
        if(root == null) return;
        for(Node n : root.children){
            postOrderDFS(n, res);
        }
        res.add(root.val);
    }
}
