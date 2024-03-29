package com.hjx.DP;
/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
Example 2:

Input: 5
Output: [0,1,1,2,1,2]
Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
//i is even res[i] = res[i/2]
//i is odd res[i] = res[i/2] + 1
public class CountingBits {
    public int[] countBits(int num) {
        if(num == 0) return new int[1];
        int[] res = new int[num + 1];
        res[1] = 1;
        for(int i = 2; i <= num; i ++){
            if(i % 2 == 0)
                res[i] = res[i/2];
            else
                res[i] = res[i/2] + 1;
        }
        return res;
    }
}
