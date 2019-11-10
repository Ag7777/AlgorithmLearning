package com.hjx.DP;

public class BestTimeBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int dp = 0;
        for(int i = 1; i < prices.length; i ++){
            if(prices[i] > prices[i - 1]){
                dp = dp + prices[i] - prices[i - 1];
            }
        }
        return dp;
    }
}
