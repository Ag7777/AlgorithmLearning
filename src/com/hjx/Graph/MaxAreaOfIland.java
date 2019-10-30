package com.hjx.Graph;
/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 */

public class MaxAreaOfIland {

    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == 1){
                    res = Math.max(res, DFS(grid, i, j));
                }
            }
        }
        return res;
    }

    public int DFS(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) return 0;
        grid[i][j] = 0;
        return DFS(grid, i - 1, j) + DFS(grid, i, j -1) + DFS(grid, i + 1, j) + DFS(grid, i, j + 1) + 1;
    }
}
