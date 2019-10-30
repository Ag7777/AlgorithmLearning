package com.hjx.Graph;
/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
 */
import java.util.*;

public class CourseSchedule2 {
    public static void main(String[] args){
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};
        int[] res = findOrder(numCourses, prerequisites);
    }

    //DFS Topological sort
    public static int[] findOrderDFS(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return new int[0];

        //build graph
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < prerequisites.length; i ++){
            if(!graph.containsKey(prerequisites[i][1])){
                graph.put(prerequisites[i][1], new ArrayList<Integer>());
            }
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        List<Integer> list = new ArrayList<Integer>();
        //0: unknown, 1: visiting, 2: visited
        int[] state = new int[numCourses];

        for(int i = 0; i < numCourses; i ++){
            if(DFS(graph, i, state, list)) return new int[0];
        }
        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i ++){
            res[i] = list.get(list.size() - 1 - i);
        }
        return res;
    }

    //true: has cycle, false: no cycle
    public static boolean DFS(Map<Integer, List<Integer>> graph, int current, int[] state, List<Integer> list){
        if(state[current] == 1) return true;
        if(state[current] == 2) return false;
        state[current] = 1;
        if(!graph.containsKey(current)) {
            state[current] = 2;
            list.add(current);
            return false;
        }
        for(Integer course : graph.get(current)){
            if(DFS(graph, course, state, list)) return true;
        }
        state[current] = 2;
        list.add(current);
        return false;
    }

    //BFS topological sort
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return new int[0];
        //build graph
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses; i ++){
            graph.add(new ArrayList<Integer>());
        }
        //节点入度
        int[] inNumber = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i ++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inNumber[prerequisites[i][0]] ++;
        }

        List<Integer> list = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < inNumber.length; i ++){
            if(inNumber[i] == 0){
                q.offer(i);
                list.add(i);
            }
        }
        while(!q.isEmpty()){
            int current = q.remove();
            for(Integer course : graph.get(current)){
                inNumber[course] --;
                if(inNumber[course] == 0){
                    q.offer(course);
                    list.add(course);
                }
            }
        }
        for(int i = 0; i < inNumber.length; i ++){
            if(inNumber[i] > 0) return new int[0];
        }
        int[] res = new int[numCourses];
        for(int i = 0; i < res.length; i ++){
            res[i] = list.get(i);
        }

        return res;
    }
}
