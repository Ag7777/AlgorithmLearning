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
import java.util.Arrays;
import java.util.ArrayList;

public class Leetcode39 {


    private static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args){
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        combinationSum(candidates, target);
        for(int i = 0; i < res.size(); i ++){
            System.out.print(res.get(i).toArray());
        }
    }
    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0) return new ArrayList();
        Arrays.sort(candidates);
        for(int i = 1; i <=  target/candidates[0]; i ++){
            dfs(candidates, target, 0, 0, i, new ArrayList<Integer>());
        }
        return res;
    }

    public static void dfs(int[] candidates, int target, int sum, int start, int number, ArrayList<Integer> tmp){
        if(start > candidates.length || tmp.size() > number) return;
        if(tmp.size() == number){
            if(sum == target){
                res.add(tmp);
            }
            return;
        }


        for(int i = start; i < candidates.length; i ++){
            if(sum + candidates[i] <= target){
                tmp.add(candidates[i]);
                dfs(candidates, target, sum + candidates[i], i, number, new ArrayList<Integer>(tmp));
                tmp.remove(tmp.size() - 1);
            }
        }

    }
}
