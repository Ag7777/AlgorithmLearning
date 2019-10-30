package com.hjx.leetcodeStart;

//142. Linked List Cycle II
/*
主要思想和上一个算法前面基本一样，也是设置一个快指针fp和一个慢指针sp，所不同的是这回是要求出如果链表存在环，那么求出环入口的起始结点。接下来我们就是要从上面的算法中做出一定程度的改变就可以完成题目的要求了。我首先说一下具体的解法，推导过程后面再说。
如果链表中存在环，那么fp和sp一定会相遇，当两个指针相遇的时候，我们设相遇点为c，此时fp和sp都指向了c，接下来令fp继续指向c结点，sp指向链表头结点head，此时最大的不同是fp的步数变成为每次走一步，令fp和sp同时走，每次一步，那么它们再次相遇的时候即为环的入口结点。
————————————————
版权声明：本文为CSDN博主「will_duan」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/willduan1/article/details/50938210
 */
public class Leetcode142 {
    public ListNode detectCycle(ListNode head){
        if(head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }

        if(fast == null || fast.next == null){
            return null;
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

