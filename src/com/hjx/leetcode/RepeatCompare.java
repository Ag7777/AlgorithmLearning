package com.hjx.leetcode;


import java.util.Scanner;

public class RepeatCompare {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int k1 = sc.nextInt();
        int x2 = sc.nextInt();
        int k2 = sc.nextInt();
        System.out.println(solution(x1, k1, x2, k2));
    }

    public static String solution(int x1, int k1, int x2, int k2){
        int n1 = String.valueOf(x1).length();
        int n2 = String.valueOf(x2).length();
        if(n1 * k1 > n2 * k2) return "Greater";
        if(n1 * k1 < n2 * k2) return "Less";
        String str1 = "";
        String str2 = "";
        for(int i = 0; i < k1; i ++){
            str1 += String.valueOf(x1);
        }
        for(int j = 0; j < k2; j ++){
            str2 += String.valueOf(x2);
        }
        for(int i = 0; i < n1 * k1; i ++){
            if(str1.charAt(i) > str2.charAt(i)){
                return "Greater";
            }
            if(str1.charAt(i) < str2.charAt(i)){
                return "Less";
            }
        }
        return "Equal";
    }
}
