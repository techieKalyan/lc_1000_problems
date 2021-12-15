package com.nelluri.graphs;

import java.util.LinkedList;
import com.nelluri.graphs.GraphAL.Edge;

public class DFS {

    public boolean depthFirstSearch(GraphAL graphAL, int source, int dest) {
        boolean[] visited = new boolean[graphAL.getNodes()];
        dfsUtil(graphAL, source,visited);
        return visited[dest];
    }

    public void dfsUtil(GraphAL graph, int source, boolean[] visited) {
        visited[source] = true;
        LinkedList<Edge> eachList = graph.adjList.get(source);
        for(Edge edge: eachList) {
            if(visited[edge.dest] == false) {
                dfsUtil(graph, edge.dest, visited);
            }
        }
    }

    public static void main(String[] args) {
        GraphAL graphAL = new GraphAL(5);
        graphAL.addDirectedEdge(0,1,3);
        graphAL.addDirectedEdge(0,4,2);
        graphAL.addDirectedEdge(1,2,1);
        graphAL.addDirectedEdge(2,3,1);
        graphAL.addDirectedEdge(4,1,-2);
        graphAL.addDirectedEdge(4,3,1);

        DFS dfs = new DFS();
        System.out.println(dfs.depthFirstSearch(graphAL, 4,0));
    }
}
