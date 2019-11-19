package com.hjx.Array;
/*
Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class DailyTenperatures {
    public static void main(String[] args){
        int[] T = new int[]{55,38,53,81,61,93,97,32,43,78};
        System.out.println(dailyTemperatures(T));
    }

    public static int[] dailyTemperatures(int[] T) {
        if(T.length == 0) return new int[0];
        int[] res = new int[T.length];
        res[T.length - 1] = 0;
        for(int i = T.length - 2; i >= 0; i --){
            int j = i + 1;
            while(j < T.length){
                if(T[j] > T[i]){
                    res[i] = j - i;
                    break;
                }
                if(res[j] == 0) break;
                j = res[j] + j;
            }
        }
        return res;
    }
}
