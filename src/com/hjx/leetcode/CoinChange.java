package com.hjx.leetcode;


import java.util.Arrays;

public class CoinChange {
    private int minCount;

    public static void main(String[] args){
        int[] coins = new int[]{186,419,83,408};
        int amount = 6249;
        CoinChange c = new CoinChange();
        int res = c.coinChange(coins, amount);
        System.out.println(res);
    }

    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        Arrays.sort(coins);
        if(amount < coins[0]) return -1;
        minCount = Integer.MAX_VALUE;
        DFS(coins, amount, 0, coins.length - 1);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;

    }

    public void DFS(int[] coins, int amount, int tempCount, int index){
        if(index < 0) {
            return;
        }
        if(amount == 0){
            minCount = Math.min(minCount, tempCount);
            return;
        }

        for(int i = index; i >= 0; i --){
            if(amount >= coins[i]){
                DFS(coins, amount - coins[i], tempCount + 1, i);
            }
        }

        return;
    }
}