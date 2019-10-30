package com.hjx.leetcode;

public class ReConstructBinaryTree {
    public static void main(String[] args){
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 8, 6};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 6, 8};
        TreeNode root = reConstructBinaryTree(pre, in);
        printPreOrder(root);
        System.out.println();
        printInOrder(root);



    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in){
        if(pre.length == 0) return null;
        return DFS(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    public static TreeNode DFS(int[] pre, int[] in,  int preStart, int preEnd, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        if(preStart == preEnd){
            return new TreeNode(pre[preStart]);
        }
        TreeNode root = new TreeNode(pre[preStart]);

        for(int i = inStart; i <= inEnd; i ++){
            if(root.val == in[i]){
                root.left = DFS(pre, in, preStart + 1,  preStart + i - inStart, inStart, i - 1);
                root.right = DFS(pre, in, preStart + i - inStart + 1, preEnd, i + 1, inEnd);
                break;
            }
        }

        return root;

    }

    public static void printPreOrder(TreeNode root){
        if(root == null) return;
        System.out.printf(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void printInOrder(TreeNode root){
        if(root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        val = x;
    }
}
