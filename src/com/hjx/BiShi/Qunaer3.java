package com.hjx.BiShi;


import java.util.Scanner;

public class Qunaer3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n][n];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                array[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(array, n));

    }

    public static int solution(int[][] array, int n){
        if(array.length == 0) return 0;

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                int[][]dp = new int[n][n];
                dp[i][j] = array[i][j];
                max = Math.max(dp[i][j], max);
                for(int m = j + 1; m < n; m ++){
                    dp[i][m] = dp[i][m - 1] + array[i][m];
                    max = Math.max(dp[i][m], max);
                }
                for(int k = i + 1; k < n; k ++){
                    dp[k][j] = dp[k - 1][j] + array[k][j];
                    max = Math.max(dp[k][j], max);
                }
                for(int k = i + 1; k < n; k ++){
                    for(int m = j + 1; m < n; m ++){

                        dp[k][m] = dp[k - 1][m - 1] + array[k - 1][m] + array[k][m - 1] + array[k][m];
                        max = Math.max(dp[k][m], max);

                    }
                }
            }
        }
        return max;

    }
}
