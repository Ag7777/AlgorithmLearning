package com.hjx.leetcodeStart;

/*
973. K Closest Points to Origin
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
(Here, the distance between two points on a plane is the Euclidean distance.)
You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

Example 1:
Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
*/
import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode973 {
    public static void main(String[] args){
        int[][] points = new int[][]{{1, 0}, {0, 1}};
        int K = 2;
        int[][] result = kClosest2(points, K);
        for(int i = 0; i < K; i ++){
            System.out.println(result[i][0] + "," + result[i][1]);
        }
    }

    public static int[][] kClosest(int[][] points, int K) {
        if(points.length == 1) return points;
        int[][] result = new int[K][2];
        PriorityQueue<Integer[]> queue = new PriorityQueue<Integer[]>(
                (Integer[] a, Integer[] b ) -> (a[0] * a[0] + a[1] * a[1] - (b[0] * b[0] + b[1] * b[1])));
        for(int i = 0; i < points.length; i ++){
            queue.offer(new Integer[]{points[i][0], points[i][1]});
        }
        for(int i = 0; i < K; i ++){
            Integer[] tmp = queue.remove();
            result[i][0] = tmp[0];
            result[i][1] = tmp[1];
        }
        return result;
    }

    public static int[][] kClosest1(int[][] points, int K){
        if(points.length == 1) return points;
        int[] distance = new int[points.length];
        for(int i = 0; i < points.length; i ++){
            distance[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
        }
        Arrays.sort(distance);
        int disK = distance[K - 1];
        int[][] result = new int[K][2];
        int j = 0;
        for(int i = 0; i < points.length; i ++){
            if(points[i][0] * points[i][0] + points[i][1] * points[i][1] <= disK){
                result[j][0] = points[i][0];
                result[j][1] = points[i][1];
                j ++;
            }
        }
        return result;
    }

    public static int[][] kClosest2(int[][] points, int K){
        if(points.length == 1) return points;
        int[] distance = new int[points.length];
        int[][] result = new int[K][2];
        for(int i = 0; i < points.length; i ++){
            distance[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
        }
        getK(distance, K, 0, distance.length - 1);
        int disK = distance[K - 1];
        int j = 0;
        for(int i = 0; i < points.length; i ++){
            if(points[i][0] * points[i][0] + points[i][1] * points[i][1] <= disK){
                result[j][0] = points[i][0];
                result[j][1] = points[i][1];
                j ++;
            }
        }
        return result;
    }

    public static void getK(int[] array, int K, int left, int right){
        int mid = (right - left) / 2 + left;
        swap(array, mid, right);
        int i = left;
        int j = right - 1;
        while(i <= j){
            if(array[i] > array[right] && array[j] < array[right]){
                swap(array, i, j);
                i ++;
                j --;
                continue;
            }
            if(array[i] <= array[right]){
                i ++;
            }
            if(array[j] > array[right]){
                j --;
            }
        }
        swap(array, i, right);
        if(i < K - 1){
            getK(array, K,i + 1, right);
        }
        else if(i > K - 1){
            getK(array, K, left, i - 1);
        }

    }

    public static void swap(int[] array, int i, int j){
        if(i == j) return;
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
