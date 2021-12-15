package com.nelluri.graphs;

import java.util.LinkedList;

public class BFS {

    public boolean breadthFirstSearch(GraphAL graph, int source, int dest) {
        int nodes = graph.getNodes();
        boolean[] visited = new boolean[nodes];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        visited[source] = true;
        while(queue.isEmpty() == false) {
            int current = queue.remove();
            LinkedList<GraphAL.Edge> currentList = graph.adjList.get(current);
            for(GraphAL.Edge edge : currentList) {
                if(visited[edge.dest] == false) {
                    visited[edge.dest] = true;
                    queue.add(edge.dest);
                }
            }
        }
        return visited[dest];
    }

    public static void main(String[] args) {
        GraphAL graphAL = new GraphAL(5);
        graphAL.addDirectedEdge(0,1,3);
        graphAL.addDirectedEdge(0,4,2);
        graphAL.addDirectedEdge(1,2,1);
        graphAL.addDirectedEdge(2,3,1);
        graphAL.addDirectedEdge(4,1,-2);
        graphAL.addDirectedEdge(4,3,1);

        BFS bfs = new BFS();
        System.out.println(bfs.breadthFirstSearch(graphAL, 0,3));
    }
}
