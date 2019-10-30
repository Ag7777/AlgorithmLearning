package com.hjx.leetcodeStart;

/*
39. Combinations Sum
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.
The same repeated number may be chosen from candidates unlimited number of times.
Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
 */

import java.util.List;
import java.util.ArrayList;

public class Leetcode39_2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0) return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(candidates, target, 0, res, 0, new ArrayList<Integer>());
        return res;
    }

    public void dfs(int[] candidates, int target, int sum, List<List<Integer>> res, int start, List<Integer> tmp){
        if(sum > target || start >= candidates.length) return;
        if(sum == target){
            res.add(tmp);
            return;
        }

        for(int i = start; i < candidates.length; i ++){
            if(sum + candidates[i] <= target){
                tmp.add(candidates[i]);
                dfs(candidates, target, sum + candidates[i], res, i, new ArrayList<Integer>(tmp));
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
