package com.hjx.Graph;
/*
Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].


The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class EvaluateDivision {

    //DFS
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        if(queries.size() == 0) return new double[0];
        //Build graph
        Map<String, Map<String, Double>> graph = new HashMap<String, Map<String, Double>>();
        for(int i = 0; i < equations.size(); i++){
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            double k = values[i];
            Map<String, Double> tmp1 = graph.getOrDefault(x, new HashMap<String, Double>());
            tmp1.put(y, k);
            Map<String, Double> tmp2 = graph.getOrDefault(y, new HashMap<String, Double>());
            tmp2.put(x, (1.0/k));
            graph.put(x, tmp1);
            graph.put(y, tmp2);
        }
        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i ++){
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            if(!graph.containsKey(x) || !graph.containsKey(y)){
                res[i] = -1.0;
            }
            else{
                res[i] = DFS(graph, x, y, new HashSet<String>());
            }
        }
        return res;

    }

    public double DFS(Map<String, Map<String, Double>> graph, String x, String y, Set<String> visited){
        if(x.equals(y)) return 1.0;
        visited.add(x);
        for(String s : graph.get(x).keySet()){
            if(visited.contains(s)) continue;
            visited.add(s);
            double d = DFS(graph, s, y, visited);
            if(d > 0){
                return d * graph.get(x).get(s);
            }
        }
        return -1.0;

    }

    //union find


}
