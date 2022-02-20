package com.nelluri.arrays;

/*
Take array of input numbers
return length of the longest mountain.

e.g: [5,6,1,2,3,4,5,4,3,2,0,1,2,3,-2,4]

length of longest mountain is 9 with peak at element 4
(1,2,3,4,5,4,3,2,0)

Prob here: https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/lecture/24429144#overview
 */
public class Mountain {

    public int findLongestMountain(int[] elements) {
        if(elements.length < 3) {
            return -1;
        }
        // Mountain will have at-least 3 elements.
        // Find peak of the mountain, then you can easily figure out length of the mountain.
        int longestMountain = Integer.MIN_VALUE;
        for(int i=1; i< elements.length - 1; ) {
            if(elements[i] > elements[i-1] && elements[i] > elements[i+1]) {
                // found peak;
                int count = 1;
                int j = i;
                while(j > 0 && elements[j-1] < elements[j]) {
                    j--;
                    count++;
                }
                while(i < elements.length - 2 && elements[i+1] < elements[i]) {
                    i++;
                    count++;
                }
                longestMountain = Math.max(longestMountain, count);
            } else {
                i++;
            }
        }
        return longestMountain;
    }

    public static void main(String[] args) {
        Mountain mountain = new Mountain();
        int[] input = new int[]{5, 6, 1, 2, 3, 4, 5, 4, 3, 2, 0, 1, 2, 3, -2, 4};
        int longestPeak = mountain.findLongestMountain(input);
        System.out.println("Length of the longest mountain is " + longestPeak);
    }
}
