package com.hjx.leetcodeStart;

/*
236. Lowest Common Ancestor of a Binary Tree

 */
public class Leetcode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null)
            return root;
        else{
            return left != null? left : right;
        }
    }
}
