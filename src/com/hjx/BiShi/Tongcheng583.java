package com.hjx.BiShi;

import java.util.Scanner;

public class Tongcheng583 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] map = new int[m][n];
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                map[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(map,m,n));

    }

    public static int solution(int[][] map, int m, int n){
        if(map.length == 0) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = map[0][0];
        for(int i = 1; i < n; i ++){
            dp[0][i] = dp[0][i - 1] + map[0][i];
        }
        for(int i = 1; i < m; i ++){
            dp[i][0] = dp[i - 1][0] + map[i][0];
        }
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + map[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
