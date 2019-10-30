package com.hjx.leetcodeStart;

/*
287. Find the Duplicate Number
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
 */
import java.util.Set;
import java.util.HashSet;

public class Leetcode287 {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int result = -1;
        for(int i = 0; i < nums.length; i ++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }
            else{
                result = nums[i];
                break;
            }
        }
        return result;
    }

    public int findDuplicate1(int[] nums){
        int l = 1;
        int r = nums.length;
        while(l < r){
            int m = (r - l)/2 + l;
            int count = 0;
            for(int num : nums){
                if(num <= m){
                    count ++;
                }
            }
            if(count <= m){
                l = m + 1;
            }
            else{
                r = m;
            }
         }
        return l;

    }

}
