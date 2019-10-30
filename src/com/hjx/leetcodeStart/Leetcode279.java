package com.hjx.leetcodeStart;

import java.util.Arrays;

/*
279. Perfect Squares
Share
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
Example 1:
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.

Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */
public class Leetcode279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for(int i = 0; i < dp.length; i ++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i <= n; i ++){
            for(int j = 1; j * j <= n; j ++){
                if(i + j * j > n) break;
                else{
                    dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
                }
            }
        }
        return dp[n];
    }

    public int numSquares1(int n){
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 1; i <= n; i ++){
            for(int j = 1; j * j <= i; j ++){
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}
