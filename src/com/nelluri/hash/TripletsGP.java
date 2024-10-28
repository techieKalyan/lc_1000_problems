package com.nelluri.hash;

// Count number of triplets in given array with indices (i, j,k ) such that they are in GP with common ratio r and i < j < k
//Uses sliding hashing technique.

// Interesting problem - important.

import com.nelluri.trees.Tree;

import java.util.HashMap;

public class TripletsGP {

    public int countTripletsWithGP(int[] input, int r) {

        if(input.length < 3) {
            return 0;
        }

        HashMap<Integer, Integer> leftCount = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> rightCount = new HashMap<Integer, Integer>();

        // Initialize the left map with 0.
        for(int number: input) {
            leftCount.put(number, 0);
        }

        // Initialize right map with actual freq.
        for(int number: input) {
            rightCount.put(number, rightCount.getOrDefault(number, 0) + 1);
        }

        int totalCount = 0;

        for(int i=0; i< input.length;i++) {

            rightCount.put(input[i], rightCount.get(input[i]) - 1);

            if(input[i] % r == 0) {
                int a = input[i] / r;
                int b = input[i];
                int c = input[i] * r;
                totalCount += leftCount.getOrDefault(a, 0) * rightCount.getOrDefault(c, 0);
            }

            leftCount.put(input[i], leftCount.getOrDefault(input[i],0 ) + 1);


        }

        return totalCount;
    }

    public static void main(String[] args) {
        TripletsGP tripletsGP = new TripletsGP();

        int[] input = new int[]{1, 16, 4 , 16, 64, 16};
        int r = 4;
        int response = tripletsGP.countTripletsWithGP(input, r);

        System.out.println(String.format("%d is the number of GP triplets", response));
    }
}
