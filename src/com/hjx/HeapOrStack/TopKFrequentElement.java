package com.hjx.HeapOrStack;
/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
import java.util.*;

public class TopKFrequentElement {
    // max heap
    public List<Integer> topKFrequent1(int[] nums, int k) {
        if(k == 0) return new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i ++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<Map.Entry<Integer, Integer>>
                ((o1, o2) -> o2.getValue() - o1.getValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            q.offer(entry);
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < k; i ++){
            res.add(q.remove().getKey());
        }
        return res;
    }

    //bucket sort
    public List<Integer> topKFrequent(int[] nums, int k){
       if(k == 0) return new ArrayList<>();
       Map<Integer, Integer> map = new HashMap<Integer, Integer>();
       for(int num : nums){
           map.put(num, map.getOrDefault(num, 0) + 1);
       }

       List<Integer>[] bucket = new List[nums.length + 1];
       for(Integer key : map.keySet()){
           int frequency = map.get(key);
           if(bucket[frequency] == null){
               bucket[frequency] = new ArrayList<>();
           }
           bucket[frequency].add(key);
       }
       List<Integer> res = new ArrayList<Integer>();
       for(int i = bucket.length - 1; i >= 0 && res.size()< k; i --){
           if(bucket[i] != null){
               res.addAll(bucket[i]);
           }
       }
       return res;
    }
}
