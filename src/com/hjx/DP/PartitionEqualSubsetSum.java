package com.hjx.DP;
/*
Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:

Each of the array element will not exceed 100.
The array size will not exceed 200.


Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].


Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
 */
//dp[i][j]  表示前i个数是都可以组成和为j的子数组
//dp[i][j] = true if(dp[i - 1][j-nums[i]] == true)
public class PartitionEqualSubsetSum {
    //Time = O(n * sum)
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
        }
        if(sum % 2 == 1) return false;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for(int i = 0; i < nums.length; i ++){
            for(int j = sum; j >= nums[i] ; j --){
                if(dp[j]) continue;
                if(dp[j - nums[i]]) dp[j] = true;
            }
        }
        return dp[sum/2];
    }

}
