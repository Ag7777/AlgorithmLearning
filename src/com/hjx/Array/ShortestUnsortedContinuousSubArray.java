package com.hjx.Array;
/*
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.
 */
public class ShortestUnsortedContinuousSubArray {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length == 0) return 0;
        int[] help = new int[nums.length];
        help[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i --){
            help[i] = Math.min(nums[i], help[i + 1]);
        }
        int start = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] != help[i]) {
                start = i;
                break;
            }
        }
        help[0] = nums[0];
        for(int i = 1; i < nums.length; i ++){
            help[i] = Math.max(nums[i], help[i - 1]);
        }
        int end = -1;
        for(int i = nums.length - 1; i >= 0; i --){
            if(nums[i] != help[i]){
                end = i;
                break;
            }
        }
        return end - start + 1;

    }
}
