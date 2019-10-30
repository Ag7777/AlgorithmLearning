package com.hjx.leetcodeStart;

/*
23. Merge k Sorted Lists
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
Example:
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */
public class Leetcode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return mergeK(lists, 0, lists.length - 1);
    }

    public ListNode mergeK(ListNode[] lists, int l , int r){
        if(l > r) return null;
        if(l == r) return lists[l];
        int mid = l + (r - l) /2;
        return combine2SortList(mergeK(lists, l, mid), mergeK(lists, mid + 1, r));
    }

    public ListNode combine2SortList(ListNode l1, ListNode l2){
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dumy = new ListNode(-1);
        ListNode current = dumy;
        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                current.next = p1;
                p1 = p1.next;
                current = current.next;
                current.next = null;
            }
            else{
                current.next = p2;
                p2 = p2.next;
                current = current.next;
                current.next = null;
            }
        }
        if(p1 != null || p2 != null){
            current.next = p1 != null? p1 : p2;
        }
        return dumy.next;
    }
}
