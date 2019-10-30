package com.hjx.Graph;
/*
200. Number of Islands
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
Example 1:
Input:
11110
11010
11000
00000

Output: 1
 */
public class NumberOfIland {
    public int numIslands1(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        int[][] used = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == '1' && used[i][j] == 0){
                    DFS1(grid, used, i, j);
                    res ++;
                }
            }
        }
        return res;
    }

    public void DFS1(char[][] grid, int[][] used, int i, int j){
        used[i][j] = 1;
        if(i >= 1 && grid[i - 1][j] == '1'){
            DFS1(grid, used, i - 1, j);
        }
        if(j >= 1 && grid[i][j - 1] == '1'){
            DFS1(grid, used, i, j - 1);
        }
        if(i < grid.length - 1 && grid[i + 1][j] == '1'){
            DFS1(grid, used, i + 1, j);
        }
        if(j < grid[0].length - 1 && grid[i][j + 1] == '1'){
            DFS1(grid, used, i, j + 1);
        }
    }

    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == '1'){
                    DFS(grid, i, j);
                    res ++;
                }
            }
        }
        return res;
    }

    public void DFS(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFS(grid, i, j - 1);
        DFS(grid, i , j + 1);
        DFS(grid, i - 1, j);
        DFS(grid, i + 1, j);

    }
}
