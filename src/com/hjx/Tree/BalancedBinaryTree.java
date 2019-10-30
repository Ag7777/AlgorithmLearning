package com.hjx.Tree;
/*
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as:
a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Example 1:
Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.
 */

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(height(root.left) - height(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root){
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }
}
