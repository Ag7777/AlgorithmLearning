package com.hjx.Graph;
/*
Given a reference of a node in a connected undirected graph,
return a deep copy (clone) of the graph.
Each node in the graph contains a val (int) and a list (List[GraphNode]) of its neighbors.
 */
import java.util.*;


public class CloneGraph {

    class Node{
        public int val;
        public List<Node> neighbors;
        public Node(int val){
            this.val = val;
        }
        public Node(int val, List<Node> neighbors){
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    //BFS
    public Node cloneGraphBFS(Node node) {
        Map<Node, Node> map = new HashMap<Node, Node>();
        Queue<Node> q = new LinkedList<Node>();
        Set<Node> set = new HashSet<Node>();
        q.add(node);
        while(!q.isEmpty()){
            Node n = q.remove();
            if(set.contains(n)) continue;
            if(!map.containsKey(n)){
                map.put(n, new Node(n.val, new ArrayList<Node>()));
            }
            Node n1 = map.get(n);
            for(Node nei : n.neighbors){
                if(!map.containsKey(nei)){
                    map.put(nei, new Node(nei.val, new ArrayList<Node>()));
                }
                n1.neighbors.add(map.get(nei));
                q.add(nei);
            }
            set.add(n);
        }
        return map.get(node);
    }

    //DFS
    public Node cloneGraph(Node node){
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<Node, Node>();
        Set<Node> set = new HashSet<Node>();
        Node n1 = new Node(node.val, new ArrayList<Node>());
        map.put(node, n1);
        DFS(node, n1, map, set);
        return n1;
    }

    public void DFS(Node node, Node n1, Map<Node, Node> map, Set<Node> set){
        if(set.contains(node)) return;
        set.add(node);
        for(Node n : node.neighbors){
            if(!map.containsKey(n)){
                map.put(n, new Node(n.val, new ArrayList<Node>()));
            }
            n1.neighbors.add(map.get(n));
            DFS(n, map.get(n), map, set);
        }

    }
}
