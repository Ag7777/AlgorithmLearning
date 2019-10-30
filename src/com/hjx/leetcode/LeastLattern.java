package com.hjx.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LeastLattern{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] length = new int[t];
        String[] roads = new String[t];
        for(int i=0;i<t;i++) {
            length[i] = Integer.parseInt(br.readLine());
            roads[i] = br.readLine();
        }
        for(int i=0;i<t;i++) {
            System.out.println(MinLight(roads[i]));
        }
    }

    public static int MinLight(String road){
        int count = 0;
        int i = 0;
        while(i < road.length()){
            if(road.charAt(i) == '.'){
                count ++;
                i = i + 3;
            }
            else{
                i ++;
            }
        }
        return count;

    }
}
