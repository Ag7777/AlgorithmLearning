package com.hjx.leetcode;

import java.util.HashMap;
import java.util.Scanner;

public class NiuNiuZhaoGongZuo {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i ++){
            map.put(in.nextInt(), in.nextInt());
        }

    }
}
