package com.hjx.Search;
/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
import java.util.List;
import java.util.ArrayList;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        DFS(nums, new ArrayList<Integer>(), res, 0);
        return res;
    }

    public void DFS(int[] nums, List<Integer> current, List<List<Integer>> res, int s){
        res.add(new ArrayList<Integer>(current));
        for(int i = s; i < nums.length; i ++){
            current.add(nums[i]);
            DFS(nums,  current, res, i + 1);
            current.remove(current.size() - 1);
        }
    }

}
