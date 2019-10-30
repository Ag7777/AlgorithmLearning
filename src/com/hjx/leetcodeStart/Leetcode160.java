package com.hjx.leetcodeStart;

//160. Intersection of Two Linked Lists
//找到较长链表与较短链表相同长度的节点，同时向后比较
public class Leetcode160 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null) return null;
            int lenA = 0;
            int lenB = 0;
            ListNode tmpA = headA;
            ListNode tmpB = headB;
            while(tmpA != null){
                lenA ++;
                tmpA = tmpA.next;
            }
            while(tmpB != null){
                lenB ++;
                tmpB = tmpB.next;
            }
            tmpA = headA;
            tmpB = headB;

            if(lenA > lenB){
              while(lenA > lenB){
                tmpA = tmpA.next;
                lenA --;
              }
            }
            else if(lenB > lenA){
                while(lenB > lenA){
                    tmpB = tmpB.next;
                    lenB --;
                }
            }
            while(tmpA != null && tmpB != null){
                if(tmpA == tmpB) return tmpA;
                tmpA = tmpA.next;
                tmpB = tmpB.next;
            }
            return null;
        }

}
