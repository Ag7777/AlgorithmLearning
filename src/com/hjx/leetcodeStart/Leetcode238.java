package com.hjx.leetcodeStart;

public class Leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];

        //计算i左侧的乘积
        leftProduct[0] = 1;
        for(int i = 1; i < nums.length; i ++){
            leftProduct[i] = nums[i - 1] * leftProduct[i - 1];
        }
        rightProduct[nums.length - 1] = 1;
        //计算i右侧的乘积
        for(int i = nums.length - 2; i >= 0; i --){
            rightProduct[i] = nums[i + 1] * rightProduct[i + 1];
        }

        for(int i = 0; i < nums.length; i ++){
            nums[i] = leftProduct[i] * rightProduct[i];
        }
        return nums;

    }

    public int[] productExceptSelf1(int[] nums) {
        int[] res = new int[nums.length];

        //计算i左侧的乘积
        res[0] = 1;
        for(int i = 1; i < nums.length; i++){
            res[i] = res[i - 1] * nums[i - 1];
        }
        //计算i右侧的乘积
        for(int i = nums.length - 2; i >= 0; i ++){
            res[i] = res[i] * nums[i + 1];
            nums[i] = nums[i] * nums[i + 1];
        }
        return res;

    }
}
