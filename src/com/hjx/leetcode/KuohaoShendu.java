package com.hjx.leetcode;

import java.util.Scanner;

public class KuohaoShendu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solution(s));
    }
    public static int solution(String s){
        int max = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == '('){
                count ++;
            }
            else if(s.charAt(i) == ')'){
                count --;
            }
            max = Math.max(max, count);
        }
        return max;
    }

}


