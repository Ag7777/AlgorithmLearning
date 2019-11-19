package com.hjx.HeapOrStack;
/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args){
        String s = "100[leetcode]";
        System.out.println(decodeString(s));
    }
    public static String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < s.length(); i ++){
//            if(s.charAt(i) == '[') stack.push("[");
            if(s.charAt(i) == ']'){
                String tmp = "";
                while(!stack.peek().equals("[")){
                    tmp = stack.pop() + tmp;
                }
                stack.pop();

                if(stack.peek().charAt(0) - '0' >= 0 && stack.peek().charAt(0) - '0' <= 9){
                    String times = "";
                    while(!stack.empty() && stack.peek().charAt(0) - '0' >= 0 && stack.peek().charAt(0) - '0' <= 9){
                        times = stack.pop() + times;
                    }
                    String cur = "";
                    for(int j = 0; j < Integer.parseInt(times); j ++){
                        cur += tmp;
                    }
                    stack.push(cur);
                }
                else{
                    stack.push(tmp);
                }

            }
            else{
                stack.push(s.substring(i, i + 1));
            }
        }
        String res = "";
        while(!stack.empty()){
            res = stack.pop() + res;
        }
        return res;
    }

}
