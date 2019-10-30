package com.hjx.leetcode;

import java.util.Scanner;

public class Aiqiyi1 {
    public static long count = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n - 1];
        for(int i = 0; i < n - 1; i ++){
            A[i] = sc.nextInt();
        }
        System.out.println(solution(n, A));

    }

    public static long solution(int n, int[] A){
        int[] nArray = new int[n];
        for(int i = 0; i < n; i ++){
            nArray[i] = i + 1;
        }
        dfs(nArray, A, 0);
        return count;
    }

    public static void dfs(int[] nArray, int[] A, int index){
        if(index > nArray.length) return;
        if(index == nArray.length - 1) {
            count ++;
            if(count > 1000000007)
                count = count % 1000000007;
            return;
        }


        for(int i = index; i < nArray.length - 1 ; i ++){
            for(int j = i; j < nArray.length; j ++){
                swap(nArray, i, j);
                if(A[i] == 1 && nArray[i] < nArray[i + 1])
                    continue;
                if(A[i] == 0 && nArray[i] > nArray[nArray.length - 1])
                    continue;
                dfs(nArray, A, index + 1);
                swap(nArray, i, j);
            }
        }
    }

    public static void swap(int[] array, int i, int j){
        if(i == j) return;
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
