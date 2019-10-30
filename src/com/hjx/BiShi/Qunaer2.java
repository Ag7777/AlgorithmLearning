package com.hjx.BiShi;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Qunaer2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        if(s1.charAt(s1.length() - 1) == ' ');
        s1 = s1.substring(0,s1.length() - 1);
        char[] inOrder = s1.toCharArray();
        char[] postOrder = br.readLine().toCharArray();
        TreeNode root = buildTree(inOrder, postOrder);
        preOrderPrintTree(root);

    }

    static class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;
        TreeNode(char val){
            this.val = val;
        }
    }

    public static void preOrderPrintTree(TreeNode node){
        if(node == null) return;
        System.out.printf(String.valueOf(node.val));
        preOrderPrintTree(node.left);
        preOrderPrintTree(node.right);
    }

    public static TreeNode buildTree(char[] inorder, char[] postorder){
        if(inorder.length == 0 || postorder.length == 0) return null;
        return dfsHelp(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);

    }

    public static TreeNode dfsHelp(char[] inorder, int inLeft, int inRight, char[] postorder, int preLeft, int preRight){
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
