package com.hjx.Greedy;
/*
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.


Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class QueueReconstructionByHeight {
    //先按身高从高到低排好序，身高相同的按照第二个数的升序排序
    //然后从高到低将身高插入到对应的位置

    public int[][] reconstructQueue(int[][] people) {
        if(people.length == 0) return new int[0][0];
        List<int[]> res = new ArrayList<int[]>();
        Arrays.sort(people, (int[] a1, int[] a2) -> {if(a1[0] == a2[0]) return a1[1] - a2[1]; else return a2[0] - a1[0];});
        for(int i = 0; i < people.length; i ++){
            res.add(people[i][1], people[i]);
        }
        for(int i = 0; i < people.length; i ++){
            people[i] = res.get(i);
        }
        return people;
    }
}
