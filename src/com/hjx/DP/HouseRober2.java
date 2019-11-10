package com.hjx.DP;

public class HouseRober2 {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        //不带最后一个
        int dp0 = nums[0];
        int dp1 = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length - 1; i ++){
            int tmp = Math.max(dp0 + nums[i], dp1);
            dp0 = dp1;
            dp1 = tmp;
        }
        int max1 = Math.max(dp0, dp1);
        //不带第一个
        dp0 = nums[1];
        dp1 = Math.max(nums[1], nums[2]);
        for(int i = 3; i < nums.length; i ++){
            int tmp = Math.max(dp0 + nums[i], dp1);
            dp0 = dp1;
            dp1 = tmp;
        }
        int max2 = Math.max(dp0, dp1);
        return Math.max(max1, max2);
    }
}
