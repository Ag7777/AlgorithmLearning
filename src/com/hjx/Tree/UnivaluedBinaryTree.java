package com.hjx.Tree;
/*
A binary tree is univalued if every node in the tree has the same value.
Return true if and only if the given tree is univalued.

 */
public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        if(root.left != null){
            if(root.val != root.left.val) return false;
            if(!isUnivalTree(root.left)) return false;
        }
        if(root.right != null){
            if(root.val != root.right.val) return false;
            if(!isUnivalTree(root.right)) return false;
        }
        return true;
    }
}
