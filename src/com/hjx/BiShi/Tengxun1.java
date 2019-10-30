package com.hjx.BiShi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Tengxun1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i ++){
            int length = Integer.parseInt(br.readLine());
            String number = br.readLine();
            System.out.println(solution(number, length));
        }
    }

    public static boolean solution(String number, int length){
        if(length < 11) return false;
        for(int i = 0; i < length - 10; i ++){
            if(number.charAt(i) == '8') return true;
        }
        return false;
    }

}
