package com.hjx.LCAProblem;


public class LCABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode head, TreeNode u, TreeNode v){
        int left = u.value <= v.value ? u.value : v.value;
        int right = u.value > v.value ? u.value : v.value;

        while(head != null){
            if(head.value < left){
                head = head.right;
            }
            else if(head.value > right){
                head = head.left;
            }
            else{
                return head;
            }
        }
        return null;
    }
}
