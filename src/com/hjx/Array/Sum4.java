package com.hjx.Array;

/*
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
import java.util.*;

public class Sum4 {
    public static void main(String[] args){
        int[] nums = new int[]{0,0,0,0};
        int target = 0;
        System.out.println(fourSum(nums, target).toString());
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length == 0) return res;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 3; i < nums.length; i ++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length - 3; i ++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length - 2; j ++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                if(nums[i] + nums[j] > target || nums[i] + nums[j] < target - nums[nums.length - 1] - nums[nums.length - 2]) break;
                for(int k = j + 1; k < nums.length - 1; k ++){
                    if(k > j + 1 && nums[k] == nums[k - 1]) continue;
                    int t = target - (nums[i] + nums[j] + nums[k]);
                    if(t < nums[k]) break;
                    if(map.containsKey(t) && map.get(t) > k){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(t);
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }

}
