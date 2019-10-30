package com.hjx.leetcodeStart;

/*
56. Merge Intervals
Given a collection of intervals, merge all overlapping intervals.
Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Leetcode56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;
        Integer[][] inter = new Integer[intervals.length][2];

        for(int i = 0; i < inter.length; i ++){
            inter[i][0] = intervals[i][0];
            inter[i][1] = intervals[i][1];
        }
        Arrays.sort(inter, (Integer[] a, Integer[] b) -> a[0] - b[0]);
        ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
        int[] tmp = new int[]{inter[0][0], inter[0][1]};
        for(int i = 1; i < inter.length; i ++){
            if(tmp[1] >= inter[i][0] && tmp[1] < inter[i][1]){
                tmp[1] = inter[i][1];
            }
            else if(tmp[1] < inter[i][0]){
                ArrayList<Integer> current = new ArrayList<Integer>();
                current.add(tmp[0]);
                current.add(tmp[1]);
                resList.add(current);
                tmp[0] = inter[i][0];
                tmp[1] = inter[i][1];
            }
        }
        int[][] res = new int[resList.size() + 1][2];
        for(int i = 0; i < resList.size(); i ++){
            res[i][0] = resList.get(i).get(0);
            res[i][1] = resList.get(i).get(1);
        }
        res[res.length - 1][0] = tmp[0];
        res[res.length - 1][1] = tmp[1];
        return res;

    }

}

class MyComparator implements Comparator<Integer[]> {

    @Override
    public int compare(Integer[] a, Integer[] b) {
        return a[0] - b[0];
    }
}
