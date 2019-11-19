package com.hjx.DP;
/*
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3.
Output: 5
Explanation:

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
 */

import java.util.*;

public class TargetSum {
    public static void main(String[] args){
        int[] nums = new int[]{0,0,0,0,0,0,0,0,1};
        int S = 1;
        System.out.println(findTargetSumWays(nums, S));
    }
    //DFS
    private int res;
    public int findTargetSumWaysDFS(int[] nums, int S) {
        if(nums == null || nums.length == 0) return 0;
        DFS(nums, S, 0, 0);
        return res;
    }
    public void DFS(int[] nums, int S, int cur, int start){
        if(start == nums.length){
            if(cur == S) res++;
            return;
        }

        DFS(nums, S, cur + nums[start], start + 1);
        DFS(nums, S, cur - nums[start], start + 1);
    }

    public static int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(nums[0], 1);
        map.put(-nums[0], map.getOrDefault(-nums[0], 0) + 1);

        for(int i = 1; i < nums.length; i ++){
            Map<Integer, Integer> tmp = new HashMap<Integer, Integer>();
            for(Integer key : map.keySet()){
                if(!tmp.containsKey(key + nums[i])){
                    tmp.put(key + nums[i], 0);
                }
                if(!tmp.containsKey(key - nums[i])){
                    tmp.put(key - nums[i], 0);
                }
                tmp.put(key + nums[i], tmp.get(key + nums[i]) + map.get(key));
                tmp.put(key - nums[i], tmp.get(key - nums[i]) + map.get(key));
            }
            map = tmp;
        }
        return map.containsKey(S) ? map.get(S) : 0;

    }
}
