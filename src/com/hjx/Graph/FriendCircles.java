package com.hjx.Graph;
/*
547. Friend Circles
There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

Example 1:
Input:
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
The 2nd student himself is in a friend circle. So return 2.
 */

public class FriendCircles {
    public int findCircleNum(int[][] M) {
        if(M.length == 0 || M[0].length == 0) return 0;
        int res = 0;
        int[] used = new int[M.length];
        for(int i = 0; i < used.length; i ++){
            if(used[i] == 0){
                DFS(M, used, i);
                res ++;
            }
        }
        return res;

    }

    public void DFS(int[][] M, int[] used, int index){
        used[index] = 0;
        for(int i = 0; i < M[0].length; i ++){
            if(M[index][i] == 1 && used[i] == 0){
                DFS(M, used, i);
            }
        }
    }

}
