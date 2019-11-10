package com.hjx.DP;
/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
//buy[i] = Math.max(buy[i - 1], sell[i - 2] - price[i])
//sell[i] = Math.max(sell[i - 1], buy[i - 1] + price[i])

public class BestTimeBuyAndSellWithColldown {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int preBuy = Integer.MIN_VALUE;
        int curBuy = Integer.MIN_VALUE;
        int preSell = 0;
        int curSell = 0;
        for(int i = 0; i < prices.length; i ++){
            preBuy = curBuy;
            curBuy = Math.max(preBuy, preSell - prices[i]);
            preSell = curSell;
            curSell = Math.max(preSell, preBuy + prices[i]);
        }
        return curSell;
    }
}
