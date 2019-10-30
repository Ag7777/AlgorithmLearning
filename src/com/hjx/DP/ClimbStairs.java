package com.hjx.DP;
/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.
 */

public class ClimbStairs {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int dp0 = 1;
        int dp1 = 2;
        for(int i = 3; i <= n; i ++){
            int tmp = dp0 + dp1;
            dp0 = dp1;
            dp1 = tmp;
        }
        return dp1;
    }
}
