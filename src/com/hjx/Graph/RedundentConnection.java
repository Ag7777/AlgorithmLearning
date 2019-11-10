package com.hjx.Graph;

/*
In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3
Example 2:
Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
    |   |
    4 - 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 */

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class RedundentConnection {

    public static void main(String[] args){
        int[][] edges = new int[][]{{3,4},{1,2},{2,4},{3,5},{2,5}};

    }
    //DFS
    public int[] findRedundantConnectionDFS(int[][] edges) {
        if(edges.length == 0) return new int[0];
        //build graph
        Map<Integer, List<Integer>> g = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < edges.length; i ++){
            int a = edges[i][0];
            int b = edges[i][1];

            if(!g.containsKey(a) || !g.containsKey(b)){
                List<Integer> tmp1 = g.getOrDefault(a, new ArrayList<Integer>());
                tmp1.add(b);
                g.put(a, tmp1);
                List<Integer> tmp2 = g.getOrDefault(b, new ArrayList<Integer>());
                tmp2.add(a);
                g.put(b, tmp2);
            }
            else{
                if(DFS(g, a, b, new HashSet<Integer>())){
                    return new int[]{a,b};
                }
                else{
                    List<Integer> tmp1 = g.getOrDefault(a, new ArrayList<Integer>());
                    tmp1.add(b);
                    g.put(a, tmp1);
                    List<Integer> tmp2 = g.getOrDefault(b, new ArrayList<Integer>());
                    tmp2.add(a);
                    g.put(b, tmp2);

                }
            }
        }
        return new int[0];

    }

    public boolean DFS(Map<Integer, List<Integer>> g, int a, int b, Set<Integer> visited){
        if(a == b) return true;
        visited.add(a);
        for(Integer n : g.get(a)){
            if(visited.contains(n)) continue;
            visited.add(n);
            if(DFS(g, n, b, visited)) return true;
        }
        return false;
    }

    //union find
    public int[] findRedundantConnection(int[][] edges){
        if(edges.length == 0) return new int[0];
        UnionFindSet unionFindSet = new UnionFindSet(edges.length);
        for(int i = 0; i < edges.length; i++){
            if(!unionFindSet.union(edges[i][0], edges[i][1])){
                return edges[i];
            }
        }
        return new int[0];

    }

    class UnionFindSet{
        int[] parents;
        int[] rank;
        UnionFindSet(int n){
            parents = new int[n];
            rank = new int[n];
        }

        public int find(int x){
            if(parents[x] == 0) return x;
            return parents[x] = find(parents[x]);
        }

        // Return false if x, y are connected.
        public boolean union(int x, int y){
            int rootx = find(x);
            int rooty = find(y);
            if(rootx == rooty) return false;
            if(rank[rootx] > rank[rooty]) parents[rooty] = rootx;
            else if(rank[rootx] < rank[rooty]) parents[rootx] = rooty;
            else{
                parents[rootx] = rooty;
                rank[rooty] ++;
            }
            return true;
        }
    }

}
