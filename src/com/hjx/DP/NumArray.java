package com.hjx.DP;
/*
303. Range Sum Query - Immutable
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 */
public class NumArray {
    public int[] array;
    public int[] dp;
    public NumArray(int[] nums) {
        array = nums;
        dp = new int[array.length];
        dp[0] = array[0];
        for(int i = 1; i < array.length; i ++){
            dp[i] = dp[i - 1] + array[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i == j) return array[i];
        if(i == 0) return dp[j];
        return dp[j] - dp[i - 1];
    }

    public static void main(String[] args){
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}
