package com.nelluri.graphs;

import java.util.LinkedList;
/*
    This class represents Adjacency list representation of a graph.
    T.C to search whether there is an edge b/w vertex i and j is O(E).
    S.C: O(E + V)
 */

public class GraphAL {
    /*
        Edge class represents the edge between src node and dest code and also
        captures the cost of the edge.
     */
    private static class Edge {
        int dest;
        int cost;
        Edge(int dest,int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    int nodes;

    LinkedList<LinkedList<Edge>> adjList;

    GraphAL(int nodes) {
        this.nodes = nodes;
        this.adjList = new LinkedList<>();
        for(int i=0; i < this.nodes ; i++) {
            this.adjList.add(new LinkedList<Edge>());
        }
    }

    public void addDirectedEdge(int src, int dest, int cost) {
        Edge edge = new Edge(dest,cost);
        this.adjList.get(src).add(edge);
    }

    public void addDirectedEdge(int src, int dest) {
        this.addDirectedEdge(src,dest,1);
    }

    public void addUndirectedEdge(int src, int dest, int cost) {
        this.addDirectedEdge(src,dest,cost);
        this.addDirectedEdge(dest,src,cost);
    }

    public void addUndirectedEdge(int src, int dest) {
        this.addUndirectedEdge(src,dest,1);
    }

    public void printGraph() {
        for(int i=0 ; i < this.nodes; i++) {
            LinkedList<Edge> eachList = this.adjList.get(i);
            System.out.print("\nNode " + i + " is connected to ");
            for(int j=0; j < eachList.size(); j++) {
                System.out.print(" ( " + eachList.get(j).dest + "," + eachList.get(j).cost + " ) ");
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
        graphAL.printGraph();


    }

}
