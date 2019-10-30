package com.hjx.Tree;
/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode current = q.poll();
                list.add(current.val);
                if(current.left != null) q.offer(current.left);
                if(current.right != null) q.offer(current.right);
            }
            res.add(list);
        }
        return res;
    }
}
