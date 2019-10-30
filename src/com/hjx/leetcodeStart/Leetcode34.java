package com.hjx.leetcodeStart;

/*
34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
 */
public class Leetcode34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, -1};
          int[] res = new int[2];
          int index = binarySearch(nums, 0, nums.length - 1, target);
          if(index == -1){
              res[0] = -1;
              res[1] = -1;
              return res;
          }
          int left = index;
          int right = index;
          while(left >= 0){
              if(nums[left] != target){
                  res[0] = left + 1;
                  break;
              }
              if(nums[left] == target && left == 0) {
                  res[0] = 0;
              }
              left --;
          };
          while(right < nums.length){
              if(nums[right] != target){
                  res[1] = right - 1;
                  break;
              }
              if(nums[right] == target && right == nums.length - 1){
                  res[1] = nums.length - 1;
              }
              right ++;
          }
          return res;

    }

    public int binarySearch(int[] nums, int left, int right, int target){
        if(left > right){
            return -1;
        }
        int mid = (left + right)/2;
        if(nums[mid] > target){
            return binarySearch(nums, left, mid - 1, target);
        }
        if(nums[mid] < target){
            return binarySearch(nums, mid + 1, right, target);
        }
        else{
            return mid;
        }
    }

}
