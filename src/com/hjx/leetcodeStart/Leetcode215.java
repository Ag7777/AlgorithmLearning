package com.hjx.leetcodeStart;

/*
215. Kth Largest Element in an Array
Find the kth largest element in an unsorted array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
*/
import java.util.Arrays;

public class Leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];

    }
}

