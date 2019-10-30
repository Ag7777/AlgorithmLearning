package com.hjx.Graph;
/*
Given a reference of a node in a connected undirected graph,
return a deep copy (clone) of the graph.
Each node in the graph contains a val (int) and a list (List[GraphNode]) of its neighbors.
 */
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class GraphNode {
    public int val;
    public List<GraphNode> neighbors;
    GraphNode(){}
    GraphNode(int val){
        this.val = val;
    }
}
public class CloneGraph {
    public GraphNode cloneGraph(GraphNode node) {
        if(node == null) return null;
        Set<GraphNode> done = new HashSet<GraphNode>();
        Queue<GraphNode> q = new LinkedList<GraphNode>();
        Map<GraphNode, GraphNode> map = new HashMap<GraphNode, GraphNode>();
        q.offer(node);
        while (!q.isEmpty()){
            GraphNode n = q.remove();
            if(done.contains(n)) continue;
            done.add(n);

            if(!map.containsKey(n)){
                map.put(n, new GraphNode(n.val));
            }
            GraphNode tmp = map.get(n);
            for(GraphNode no : n.neighbors){
                if(!map.containsKey(no)){
                    map.put(no, new GraphNode(no.val));
                }
                q.offer(no);
                tmp.neighbors.add(map.get(no));
            }
        }
        return map.get(node);

    }
}
