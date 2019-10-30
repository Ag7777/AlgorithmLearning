package com.hjx.Search;
/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
import java.util.List;
import java.util.ArrayList;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        DFS(k, n, 0, 1, 0, new ArrayList<Integer>(), res);
        return res;
    }

    public void DFS(int k, int n, int d, int s, int sum, List<Integer>current, List<List<Integer>> res){
        if(d == k){
            if(sum == n){
                res.add(new ArrayList<Integer>(current));
            }
            return;
        }
        for(int i = s; i <= 9; i ++){
            if(sum + i > n) break;
            current.add(i);
            DFS(k, n, d + 1, i + 1, sum + i, current, res);
            current.remove(current.size() - 1);
        }
    }
}
