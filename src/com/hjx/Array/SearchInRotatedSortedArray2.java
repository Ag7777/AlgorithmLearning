package com.hjx.Array;
/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?
 */
public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int l = 0;
        int r = nums.length;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] == nums[l]) l ++;
            else if(nums[mid] > nums[l]){
                if(target < nums[mid] && target >= nums[l]){
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }
            }
            else{
                if(target > nums[mid] && target <= nums[r]){
                    l = mid + 1;
                }
                else{
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
