package com.hjx.Search;
/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutation2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        DFS(nums, new ArrayList<Integer>(), used, res);
        return res;
    }

    public void DFS(int[] nums, List<Integer> current, boolean[]used, List<List<Integer>> res){
        if(current.size() == nums.length){
            res.add(new ArrayList<Integer>(current));
            return;
        }
        for(int i = 0; i < nums.length; i ++){
            if(used[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            current.add(nums[i]);
            DFS(nums, current, used, res);
            used[i] = false;
            current.remove(current.size() - 1);

        }
    }


}
