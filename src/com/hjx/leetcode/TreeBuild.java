package com.hjx.leetcode;

public class TreeBuild {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    public static void main(String[] args){
        int[] inorder = new int[]{2,1};
        int[] postorder = new int[]{2,1};
        TreeNode root = buildTree(inorder, postorder);
        inorderPrintTree(root);
        postorderPrintTree(root);
    }

    //中序打印二叉树
    public static void inorderPrintTree(TreeNode root){
        if(root == null) return;
        inorderPrintTree(root.left);
        System.out.printf(root.val + " ");
        inorderPrintTree(root.right);
    }

    //前序打印二叉树
    public static void preorderPrintTree(TreeNode root){
        if(root == null) return;
        System.out.printf(root.val + " ");
        preorderPrintTree(root.left);
        preorderPrintTree(root.right);
    }

    //后序打印二叉树
    public static void postorderPrintTree(TreeNode root){
        if(root == null) return;
        postorderPrintTree(root.left);
        postorderPrintTree(root.right);
        System.out.printf(root.val + " ");
    }

    //根据中序数组和后序数组重建二叉树
    public static TreeNode buildTree(int[] inorder, int[] postorder){
        if(inorder.length == 0 || postorder.length == 0) return null;
        return dfsHelp(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);

    }

    public static TreeNode dfsHelp(int[] inorder, int inLeft, int inRight, int[] postorder, int preLeft, int preRight){
        if(inLeft < 0 || inRight >= inorder.length  || preLeft < 0 || preRight >= postorder.length ||inLeft > inRight || preLeft > preRight)
            return null;

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
