package com.nelluri.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class FindPair {

    public List<Integer> findPair(int[] input, int target) {
        Set<Integer> lookup = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        int size = input.length;
        for(int i=0; i < size; i++ ) {
            int remaining = target - input[i];
            if(lookup.contains(remaining)) {
                result.add(input[i]);
                result.add(remaining);
                return result;
            }
            lookup.add(input[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] sampleInput = new int[]{10,5,2, 3,-6,9,11};
        FindPair fp = new FindPair();
        System.out.println(fp.findPair(sampleInput, 4));

    }
}
