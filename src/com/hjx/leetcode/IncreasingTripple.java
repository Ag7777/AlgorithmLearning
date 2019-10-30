package com.hjx.leetcode;

public class IncreasingTripple {
    private static boolean result;

    public static void main(String args[]){
        int[] nums = {2,5,3,4,5};
        boolean result = increasingTriplet(nums);
        System.out.println("resule:" + result);
    }

    public static boolean increasingTriplet(int[] nums) {
        if(nums.length <= 2) return false;
        help(nums, Integer.MIN_VALUE, 0, 3);
        return result;
    }

    public static void help(int[] nums, int current, int start, int residue){
        if(residue == 0) {
            result = true;
            return;
        }

        for(int i = start; i <= nums.length - residue; i ++){
            if(nums[i] > current){
                help(nums, nums[i], i + 1, residue - 1);
            }
        }
        return;
    }
}
