package com.hjx.leetcodeStart;

//merge sort
public class Leetcode148 {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
         ListNode fast =head;
         ListNode slow = head;
         ListNode pre = null;

         while(fast != null && fast.next != null){
             pre = slow;
             slow = slow.next;
             fast = fast.next.next;
         }

         pre.next = null;
         return merge(sortList(head), sortList(slow));
    }

    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                current.next = head1;
                head1 = head1.next;
            }
            else{
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }
        if(head1 != null){
            current.next = head1;
        }
        if(head2 != null){
            current.next = head2;
        }
        return dummy.next;
    }
}


