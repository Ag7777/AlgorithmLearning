package com.hjx.leetcode;

public class SortedListToBST {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static class TreeNode{
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    public static void main(String[] args){

    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode mid = findMiddle(head);
        if(mid == head){
            return new TreeNode(head.val);
        }

        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }





    public ListNode findMiddle(ListNode head){

        if(head == null) return null;
        ListNode pre = null;
        ListNode p1 = head;
        ListNode p2 = head;
        while(p1 != null && p1.next != null){
            pre = p2;
            p1 = p1.next.next;
            p2 = p2.next;
        }
        if(pre != null){
            pre.next = null;
        }
        return p2;
    }

}
