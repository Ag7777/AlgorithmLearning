package com.hjx.DP;
/*
Given an array nums of integers, you can perform operations on the array.

In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

You start with 0 points. Return the maximum number of points you can earn by applying such operations.

Example 1:

Input: nums = [3, 4, 2]
Output: 6
Explanation:
Delete 4 to earn 4 points, consequently 3 is also deleted.
Then, delete 2 to earn 2 points. 6 total points are earned.


Example 2:

Input: nums = [2, 2, 3, 3, 3, 4]
Output: 9
Explanation:
Delete 3 to earn 3 points, deleting both 2's and the 4.
Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
9 total points are earned.
 */
//dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i])
public class DeleteOrEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0) return 0;
        int max = 0;
        for(int i = 0; i < nums.length; i ++){
            max = Math.max(max, nums[i]);
        }
        int[] help = new int[max];
        for(int i = 0; i < nums.length; i ++){
            help[nums[i] - 1] += nums[i];
        }
        return rob(help);
    }

    public int rob(int[] nums){
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
