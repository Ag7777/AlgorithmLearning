package com.hjx.leetcode;

public class Zhongshu {
    public static String Zhongshu(int n, int[] number){
        if(n != number.length) return "_";
        StringBuilder sb = new StringBuilder("");
        int length = 0;
        for(int i = 0; i < number.length; i ++){
            length += number[i];
        }
        help(n, number, sb, length);
        return sb.toString();
    }

    public static void help(int n, int[] number, StringBuilder sb, int length){
        if(sb.length() == length){
            return ;
        }
        for(int i = 0; i <= n ; i ++){
            if(Character.toString(sb.charAt(sb.length() - 1)) == Integer.toString(i + 1) || number[i] == 0) {
                continue;
            }

        }
    }
}
