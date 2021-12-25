package com.nelluri.arrays;

import java.util.*;
import java.util.TreeMap;

/*
    We need to get min swaps required to sort the array.
    https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/lecture/24913944#overview
 */
public class MinSwapsRequiredToSortElements {

    public int getMinSwaps(int[] input) {
        int result = 0;
        int n = input.length;

        // Sort the given input elements and stored their old indices.
        Map<Integer, Integer> sortedArray = new TreeMap<>();
        for(int i=0; i < n ; i++) {
            sortedArray.put(input[i],i);
        }

        Set<Map.Entry<Integer, Integer> > entrySet
                = sortedArray.entrySet();
        // need to access sorted data in pairs.
        List<Map.Entry<Integer, Integer> > sortedPairs
                = new ArrayList<>(entrySet);

        // initially all the nodes are not visited.
        boolean[] visited = new boolean[n];

        for(int i=0; i < n ; i++) {

            // if new index position is same as old position or if the node
            // is already visited.
            if(visited[i] == true || i == sortedPairs.get(i).getValue()) {
                continue;
            }

            int node = i;
            int cycle = 0;
            while(visited[node] == false) {
                visited[node] = true;
                node = sortedPairs.get(node).getValue();
                cycle++;
            }
            // if cycle is of length n, no of swaps required are n-1
            result += (cycle - 1);

        }

        return result;

    }

    public static void main(String[] args) {
        MinSwapsRequiredToSortElements minSwapsRequiredToSortElements = new MinSwapsRequiredToSortElements();
        int[] elements = new int[] {10,11,5,4,3,2,1};
        int count = minSwapsRequiredToSortElements.getMinSwaps(elements);
        System.out.println("Min swaps required to sort array are " + count);

    }
}
