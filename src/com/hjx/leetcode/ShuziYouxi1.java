package com.hjx.leetcode;
import java.util.Arrays;
import java.util.Scanner;

public class ShuziYouxi1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] number = new int[n];
        for(int i = 0; i < n; i ++){
            number[i] = sc.nextInt();
        }
        System.out.println(solution(number));


    }

    public static int solution(int[] number){
        for(int i = 0; i < number.length; i ++){
           char[] numChar = String.valueOf(number[i]).toCharArray();
           Arrays.sort(numChar);
           number[i] = Integer.valueOf(String.valueOf(numChar));

        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < number.length; i ++){
            max = Math.max(max, number[i]);
        }
        return max;
    }
}
