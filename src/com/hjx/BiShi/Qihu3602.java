package com.hjx.BiShi;

import java.util.Scanner;

public class Qihu3602 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i ++){
            array[i] = sc.nextInt();
        }

        int max = 0;
        for(int i = 0; i < m; i ++){
            max += array[i];
        }
        int left = 0;
        int right = m;
        int current = max;
        if(m >= n) System.out.println(String.format("%.3f", (double)max/m));
        else {
            while (right < n) {
                current = current - array[left] + array[right];
                max = Math.max(max, current);
                left++;
                right++;
            }
            System.out.println(String.format("%.3f", (double) max / m));
        }

     }

}
