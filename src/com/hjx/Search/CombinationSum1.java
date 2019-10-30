package com.hjx.Search;

/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
The same repeated number may be chosen from candidates unlimited number of times.
Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CombinationSum1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        DFS(candidates, target, 0, 0, new ArrayList<>(), res);
        return res;

    }
    public void DFS(int[] candidates, int target, int sum, int start, List<Integer> current, List<List<Integer>> res){
        if(sum == target){
            res.add(current);
        }
        for(int i = start; i < candidates.length; i ++){
            if(sum + candidates[i] > target) break;
            current.add(candidates[i]);
            DFS(candidates, target, sum + candidates[i], i, new ArrayList<Integer>(current), res);
            current.remove(current.size() - 1);
        }
    }
}
