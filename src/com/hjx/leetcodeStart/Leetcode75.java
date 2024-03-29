package com.hjx.leetcodeStart;

/*
75. Sort Colors
Share
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,
with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Note: You are not suppose to use the library's sort function for this problem.

Example:
Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
Accepted
 */

public class Leetcode75 {
    public void sortColors(int[] nums) {
        if(nums.length <= 1) return;
        int red = 0;
        int white = 0;
        int blue = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == 0) red ++;
            else if(nums[i] == 1) white ++;
            else if(nums[i] == 2) blue ++;
        }
        int index = 0;
        for(int i = 0; i < red; i ++){
            nums[index ++] = 0;
        }
        for(int i = 0; i < white; i ++){
            nums[index ++] = 1;
        }
        for(int i = 0; i < blue; i ++){
            nums[index++] = 2;
        }
    }

    public void sortColors2(int[] nums){
        if(nums.length <= 1) return;
        int red = 0;
        int blue = nums.length - 1;
        for(int i = 0; i <= blue; i ++){
            if(nums[i] == 0) {
                swap(nums, i, red++);
            }
            else if(nums[i] == 2){
                swap(nums, i, blue--);
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        if(i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
