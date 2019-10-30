package com.hjx.Search;

/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length == 0) return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        DFS(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    public void DFS(int[] nums, int s, List<Integer> current, List<List<Integer>> res){
        res.add(new ArrayList<Integer>(current));
        for(int i = s; i < nums.length; i ++){
            if(i > s && nums[i] == nums[i - 1]) continue;
            current.add(nums[i]);
            DFS(nums, i + 1, current, res);
            current.remove(current.size() - 1);

        }
    }
}
