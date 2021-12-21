package com.nelluri.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
https://leetcode.com/problems/tree-diameter/
 */

public class TreeDiameter {

    public int treeDiameter(int[][] edges) {

        // representing graph as an adjacency list
        List<LinkedList<Integer>> adjList = new LinkedList<LinkedList<Integer>>();

        // no of nodes
        int n = edges.length + 1;

        for(int i = 0 ;i < n; i++) {
            adjList.add(i,new LinkedList<Integer>());
        }

        for(int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        /* Step1 : Use BFS to count number of levels from Node 0 and
        find out the farthest node.
        */
        int[] farthestNode = bfs(0,adjList);

        System.out.println(farthestNode[0] + "\t" + farthestNode[1]);

        /* Step2: from the farthestNode computed in step1 , get the farthest node from
        this Node and this will be the diameter.
        */
        int[] nextFarthest = bfs(farthestNode[0], adjList);

        System.out.println(nextFarthest[0] + "\t" + nextFarthest[1]);

        return nextFarthest[1];

    }

    public int[] bfs(int start, List<LinkedList<Integer>> adjList) {
        int n = adjList.size();
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<Integer>();

        int count=0;

        queue.add(start);

        int numLevels = -1;
        int lastElement = -1;
        while(queue.isEmpty() == false) {
            count = queue.size();
            while(count > 0) {
                int element = queue.remove();
                visited[element] = true;
                for(int i = 0; i < adjList.get(element).size(); i++) {
                    int ele = adjList.get(element).get(i);
                    if(visited[ele] == false) {
                        queue.add(ele);
                        lastElement = ele;
                    }
                }
                count--;
            }

            numLevels++;

        }
        return new int[] {lastElement, numLevels};
    }
}
