package com.hjx.leetcode;

public class PostAndInorder {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        //根据中序数组和后序数组重建二叉树
        public TreeNode buildTree(int[] inorder, int[] postorder){
            if(inorder.length == 0 || postorder.length == 0) return null;
            return dfsHelp(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);

        }

        public TreeNode dfsHelp(int[] inorder, int inLeft, int inRight, int[] postorder, int preLeft, int preRight){
            if(inLeft > inRight)
                return null;
            if(inLeft == inRight) return new TreeNode(postorder[preRight]);

            TreeNode root = new TreeNode(postorder[preRight]);
            int index = 0;
            for(int i = inLeft; i <= inRight; i ++){
                if(inorder[i] == root.val){
                    index = i;
                    break;
                }
            }

            int leftNum = index - inLeft;

            root.left = dfsHelp(inorder, inLeft, index - 1, postorder, preLeft, preLeft + leftNum - 1);
            root.right = dfsHelp(inorder, index + 1, inRight, postorder, preLeft + leftNum, preRight - 1);
            return root;
        }
    }
}
