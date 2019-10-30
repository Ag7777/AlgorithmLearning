package com.hjx.Search;
/*
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class LetterCasePermutation {
    public static void main(String[] args){
        String S = "a1b2";
        List<String> res = letterCasePermutation(S);
        for(String s : res){
            System.out.println(s);
        }
    }
    public static List<String> letterCasePermutation(String S) {
        if(S == null || S.length() == 0) return new ArrayList<String>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<String> q = new LinkedList<String>();
        q.offer(S);
        for(int i = 0; i < S.length(); i ++){
            if(Character.isDigit(S.charAt(i))) continue;
            int size = q.size();
            for(int j = 0; j < size; j ++){
                char[] array = q.remove().toCharArray();
                array[i] = Character.toLowerCase(array[i]);
                q.offer(new String(array));
                array[i] = Character.toUpperCase(array[i]);
                q.offer(new String(array));
            }
        }
        return new LinkedList<String>(q);
    }



}
