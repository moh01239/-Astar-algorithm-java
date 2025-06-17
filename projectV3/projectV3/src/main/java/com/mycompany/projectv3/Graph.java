package com.mycompany.projectv3;

import java.util.*;

public class Graph {
    private final Map<Node, List<Edge>> adjList = new HashMap<>();

    public void addEdge(Node from, Node to, int weight) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.get(from).add(new Edge(to, weight));
    }

    public void addUniEdge(Node start, Node end, int weight) {
        adjList.putIfAbsent(start, new ArrayList<>());
        adjList.putIfAbsent(end, new ArrayList<>());
        adjList.get(start).add(new Edge(end, weight));
        adjList.get(end).add(new Edge(start, weight));
    }

    public void printAStarShortestPath(Node start, Node goal) {
        if (!adjList.containsKey(start)) {
            System.out.println("Either start node is not in the graph or no connected to any other node in the graph");
            return;
        }
        if (start.equals(goal)) {
            System.out.println("Start Node is the same as Goal Node");
            return;
        }

        // To select minimum cost path in each loop
        PriorityQueue<PathNode> paths = new PriorityQueue<>(Comparator.comparingDouble(PathNode::cost));

        // To track minimum g cost of each node
        Map<Node, Double> gCosts = new HashMap<>();

        // init default values
        paths.add(new PathNode(null, start, 0, heuristic(start, goal)));
        gCosts.put(start, 0.0);

        // loop
        while(!paths.isEmpty()){
            PathNode currentPath = paths.poll();
            if(currentPath.current == goal){
                System.out.println(currentPath);
                return;
            }
            List<Edge> edges = adjList.get(currentPath.current);
            if(edges != null) {
                for (Edge edge : edges) {
                    double gCost = currentPath.gCost + edge.weight;
                    if (gCost < gCosts.getOrDefault(edge.to, Double.POSITIVE_INFINITY)) {
                        gCosts.put(edge.to, gCost);
                        paths.add(new PathNode(currentPath, edge.to, gCost, heuristic(edge.to, goal)));
                    }
                }
            }
        }

        System.out.println("No path exists between "+start.name+" and "+goal.name);
    }

    private double heuristic(Node a, Node b) {
        return Math.hypot(a.x - b.x, a.y - b.y);
    }
}
