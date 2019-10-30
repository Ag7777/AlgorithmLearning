package com.hjx.leetcode;
import java.util.Scanner;

public class Tianjiazuishaokuohao {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }


    public static int solution(String s){
        if(s.length() == 0) return 0;
        int[][] dp = new int[s.length()][s.length()];

        for(int i = 0; i < s.length (); i ++){
            for(int j = i; j >= 0; j --){
                if(i == j){
                    dp[i][j] = 0;
                }
                if(s.charAt(i) == ')' && s.charAt(j) == '('){
                    dp[i][j] = dp[i - 1][j + 1];
                }
                else if(i > 0 && j < s.length() - 1){
                    dp[i][j] = dp[i - 1][j + 1] + 2;
                }
            }
        }
        return dp[s.length() - 1][0];
    }
}
