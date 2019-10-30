package com.hjx.Search;
/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        if(n == 0 || k == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        DFS(n, 1, 0, k, new ArrayList<Integer>(), res);
        return res;
    }

    public void DFS(int n,int s, int d, int k, List<Integer> current, List<List<Integer>> res){
        if(d == k) {
            res.add(new ArrayList<Integer>(current));
            return;
        }
        for(int i = s; i <= n; i ++){
            current.add(i);
            DFS(n, i + 1, d + 1, k, current, res);
            current.remove(current.size() - 1);
        }
    }
}
