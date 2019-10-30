package com.hjx.BiShi;

import java.util.Scanner;

public class Tengxun3 {
    private static int gap = Integer.MAX_VALUE;
    private static int min;
    private static int max;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i ++){
            int m = sc.nextInt();
            int[] array = new int[m];
            for(int j = 0; j < m; j++){
                array[j] = sc.nextInt();
            }
            solution(m, array);
            System.out.println(min + " " + max);
            gap = Integer.MAX_VALUE;
        }
    }

    public static void solution(int m, int[] array){
        int total = 0;
        int[] res = new int[2];
        for(int i = 0; i < m; i ++){
            total += array[i];
        }
        help(m, array, 0, 0, total, 0);


    }

    public static void help(int m, int[] array, int number, int index, int total, int current){
        if(index >= m) return;
        if(number == m/2){
            if(gap > Math.abs(total - 2 * current)){
                min = Math.min(current, total - current);
                max = total - min;
                gap = max - min;
            }
        }
        for(int i = index; i < m; i ++){
            help(m, array, number + 1, i + 1, total, current + array[i]);
        }

    }

}
