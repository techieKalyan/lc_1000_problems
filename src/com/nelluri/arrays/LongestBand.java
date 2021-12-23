package com.nelluri.arrays;

/*

Given an array, find length of longest band.
band contains elements which are consecutive.
https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/lecture/24429162#announcements

Algo:
1. Identify the starting element of the band.
2. Lookup whether consecutive elements are present in the array or not using HashSet.
3. Compute length of the band and take max band length.

 */

import java.util.HashSet;
import java.util.Set;

public class LongestBand {

    LongestBand() {

    }

    public int getLengthOfLongestBand(int[] input, int length) {
        int maxLengthBand = 0;
        Set<Integer> hashSet = new HashSet<>();

        for(int x: input) {
            hashSet.add(x);
        }

        for(int i=0; i< length ; ) {
            int x = input[i];
            int parent = x-1;
            // check if this element is the start of the band or not.
            // if not continue to next iteration.
            if(hashSet.contains(parent)) {
                i++;
                continue;
            }
            // check for length of the band startng with this element.
            int next = x + 1;
            int lengthOfBand = 1;
            while(hashSet.contains(next)) {
                lengthOfBand++;
                next = next+1;
            }
            i++;
            // take the band which is the largest of all available bands.
            maxLengthBand = Math.max(maxLengthBand, lengthOfBand);
        }

        return maxLengthBand;
    }

    public static void main(String[] args) {
        LongestBand longestBand = new LongestBand();
        int res = longestBand.getLengthOfLongestBand(new int[] {1,9,3,0,18,5,2,4,10,7,12,6}, 12);
        System.out.println("longest band is " + res);
    }


}
