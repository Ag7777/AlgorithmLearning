package com.hjx.DP;
/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
 */
//f(i) = Math.max(f(i - 1), f(i - 2) + nums[i])
//f(0) = nums[0];
//f(1) = Math.max(nums[0], nums[1]
public class HouseRober {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int dp0 = nums[0];
        int dp1 = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i ++){
            int tmp = Math.max(dp0 + nums[i], dp1);
            dp0 = dp1;
            dp1 = tmp;
        }
        return Math.max(dp0, dp1);
    }
}
