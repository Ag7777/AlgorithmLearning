package com.hjx.leetcode;

public class LongestSubstringWithKReapting {

    public static int longestSubstring(String s, int k) {
        if(s.length() == 0) return 0;
        if(k == 0 || k == 1) return s.length();
        int result = 0;
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i ++){
            count[s.charAt(i) - 'a'] ++;
        }

        int temp = 0;
        for(int i = 0; i < s.length(); i ++){
            if(count[s.charAt(i) - 'a'] < k){

                result = Math.max(result, temp);
                temp = 0;
                continue;
            }
            else{
                temp ++;
                continue;
            }
        }
        result = Math.max(result, temp);
        return result;
    }

    public static void main(String args[]){
        String s = "ababacb";
        int k = 3;
        int result = longestSubstring(s, k);
        System.out.println(result);
    }
}
