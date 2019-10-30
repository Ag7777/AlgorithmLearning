package com.hjx.leetcodeStart;

/*
932. Beautiful Array
For some fixed N, an array A is beautiful if it is a permutation of the integers 1, 2, ..., N, such that:

For every i < j, there is no k with i < k < j such that A[k] * 2 = A[i] + A[j].

Given N, return any beautiful array A.  (It is guaranteed that one exists.)

Example 1:
Input: 4
Output: [2,1,4,3]

Example 2:
Input: 5
Output: [3,1,2,5,4]
 */

public class Leetcode932 {
    public static void main(String[] args){
        int N = 7;
        for(int num : beautifulArray(N)){
            System.out.print(num + " ");
        }

    }

    public static int[] beautifulArray(int N) {
        if(N == 1) return new int[]{1};
        int[] left = beautifulArray((N + 1)/2);
        int[] right = beautifulArray(N/2);
        int[] sum = new int[N];
        int i = 0;
        for(int num : left){
            sum[i++] = num * 2 - 1;
        }
        for(int num : right){
            sum[i++] = num * 2;
        }
        return sum;
    }

}
