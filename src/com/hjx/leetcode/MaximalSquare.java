package com.hjx.leetcode;

class MaximalSquare {
    public static void main(String[] args){
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
        System.out.println('A' + 1);
    }

    public static int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < matrix[0].length; j ++){
                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j] - '0';
                    continue;
                }

                else if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
