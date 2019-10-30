package com.hjx.leetcode;

public class XuanLiangHao {
    public static String[] xuanLiangHao(int N, int K, String number) throws Exception {
        if(N != number.length() || N < K){
            throw new Exception("input wrong!");
        }
        String[] result = new String[2];
        if(K == 0) {
            result[0] = "0";
            result[1] = number;

        }


        return result;
    }
}
