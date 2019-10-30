package com.hjx.leetcode;

import java.util.Stack;

public class StackBuildQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args){
        StackBuildQueue sbq = new StackBuildQueue();
        sbq.push(1);
        sbq.push(2);
        sbq.push(3);
        System.out.println(sbq.pop());
        System.out.println(sbq.pop());
        sbq.push(4);
        sbq.push(5);
        System.out.println(sbq.pop());
        System.out.println(sbq.pop());
        System.out.println(sbq.pop());

    }

    public void push(int node) {
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);

    }

    public int pop() {
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        if(!stack2.empty()){
            return stack2.pop();
        }
        return -1;
    }
}