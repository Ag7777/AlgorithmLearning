package com.hjx.leetcodeStart;
//169. Majority Element
/*
Given an array of size n, find the majority element.
The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
 */
import java.util.HashMap;
import java.util.Map;

public class Leetcode169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i ++){
            int number = map.getOrDefault(nums[i], 0);
            map.put(nums[i], number + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > nums.length/2)
                return entry.getKey();
        }
        return -1;
    }
}
