package com.hjx.leetcode;

import java.util.Scanner;

public class Zhengchu3{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long l = in.nextLong();
        long r = in.nextLong();
        System.out.println(solution(l, r));

    }

    public static long solution(long l, long r){
        long count = 0;
        int sum = 0;
        for(long i = 1; i < l; i ++){
            sum = sum + (int) (i % 3);
        }
        for(long i = l; i <= r; i ++){
            sum = sum + (int)(i % 3);
            if(sum % 3 == 0){
                count ++;
            }
        }
        return count;
    }

    public static long solution1(long l, long r){
        long count = 0;
        StringBuilder sbl = new StringBuilder();
        for(long i = 1; i < l; i ++){
            sbl.append(i);
        }
        for(long i = l; i <= r; i ++){
            sbl.append(i);
            if(Integer.parseInt(sbl.toString()) % 3 == 0){
                count ++;
            }
        }
        return count;
    }
}