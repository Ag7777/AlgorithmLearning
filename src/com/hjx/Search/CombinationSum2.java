package com.hjx.Search;
/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
 */
import java.util.*;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        DFS(candidates, target, 0, 0, new ArrayList<>(), res);
        return res;
    }
    public void DFS(int[] candidates, int target, int sum, int start, List<Integer> current, List<List<Integer>> res){
        if(start > candidates.length) return ;
        if(sum == target) {
            res.add(current);
            return;
        }
        for(int i = start;  i < candidates.length; i ++){
            if(sum + candidates[i] > target) return;
            if(i > start && candidates[i] == candidates[i - 1]) continue;
            current.add(candidates[i]);
            DFS(candidates, target, sum + candidates[i], i + 1, new ArrayList(current), res);
            current.remove(current.size() - 1);
        }
    }
}
