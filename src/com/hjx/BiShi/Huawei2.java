package com.hjx.BiShi;

import java.util.Scanner;

public class Huawei2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");

    }

    public void solution(String[] s){
        if(s.length == 0) return;
        for(int i = s.length - 1; i >= 0; i --){

        }
    }

    public void valid(String s){
        if(s == null) return;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i ++){
            if((s.charAt(i) - 'A' >= 0 && s.charAt(i) - 'A' <= 26) || (s.charAt(i) - 'a' >= 0 && s.charAt(i) - 'a' <= 26)){
                sb.append(s.charAt(i));
            };
            if(i == 0 && s.charAt(i) == '-'){

            }
        }
    }
}
