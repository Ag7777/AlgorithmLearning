package com.hjx.Array;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class SubArrayEqualsK {
    public int subarraySum1(int[] nums, int k) {
        int res = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1; i < sum.length; i ++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for(int i = 0; i < nums.length; i ++){
            for(int j = i + 1; j < nums.length; j ++){
                if(sum[j + 1] - sum[i] == k)
                    res ++;
            }
        }
        return res;
    }

    public int subarraySum(int[] nums, int k){
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int sum = 0;
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

}
