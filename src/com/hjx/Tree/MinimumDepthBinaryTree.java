package com.hjx.Tree;
/*
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.
Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its minimum depth = 2.
 */
import java.util.Queue;
import java.util.LinkedList;

public class MinimumDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0)? left+ right + 1 : Math.min(left, right) + 1;
    }

    public int minDepthBFS(TreeNode root){
        if(root == null) return 0;
        int depth = 1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i ++){
                TreeNode current = q.poll();
                if(current.left != null){
                    q.offer(current.left);
                }
                if(current.right != null){
                    q.offer(current.right);
                }
                if(current.left == null && current.right == null){
                    return depth;
                }
            }
            depth ++;
        }
        return depth;
    }

}
