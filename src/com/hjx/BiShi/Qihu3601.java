package com.hjx.BiShi;

import java.util.Scanner;

public class Qihu3601 {
    private static double max = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i ++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        dfs(arr, n, 0, 0, 0);
        System.out.println(String.format("%.1f",max));
    }

    public static void dfs(int[][] array, int n, int start, double currentL, int currentV){
        if(start >= n){
            max = Math.max(currentL, max);
            return;
        }

        for(int i = start; i < n; i ++){
            swap(array, i, start);
            currentL = currentV * array[start][1] + 0.5 * array[start][0] * array[start][1] * array[start][1];
            currentV += array[start][0] * array[start][1];
            dfs(array, n, start + 1, currentL, currentV);
            swap(array, i ,start);
        }
    }

    public static void swap(int[][] array, int i, int j){
        if(i == j) return;
        int tmp0 = array[i][0];
        int tmp1 = array[i][1];
        array[i][0] = array[j][0];
        array[i][1] = array[j][1];
        array[j][0] = tmp0;
        array[j][1] = tmp1;
    }
}
