package com.hjx.Graph;
/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
 */
import java.util.List;
import java.util.ArrayList;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 1 || prerequisites.length <= 1) return true;
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        //0: not visited 1: visiting 2: visited
        int[] nodeState = new int[numCourses];
        //构造课程图
        for(int i = 0; i < numCourses; i ++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < prerequisites.length; i ++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i = 0; i < numCourses; i ++){
            if(DFS(graph, nodeState, i)) return false;
        }
        return true;

    }

    //true: has cycle, false: no cycle
    public boolean DFS(List<List<Integer>> graph, int[] nodeState, int current){
        if(nodeState[current] == 1) return true;
        if(nodeState[current] == 2) return false;
        nodeState[current] = 1;
        for(int i = 0; i < graph.get(current).size(); i ++){
            if(DFS(graph, nodeState, graph.get(current).get(i))) return true;
        }
        nodeState[current] = 2;
        return false;
    }
}
