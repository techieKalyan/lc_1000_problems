package com.nelluri.arrays;

import java.util.ArrayList;
import java.util.List;

/*

Print all triplets sorted internally and across

 */
public class FindAllTriplets {

    private static class Triplet<T> {
        T ele1, ele2, ele3;
        Triplet(T ele1, T ele2, T ele3) {
            this.ele1 = ele1;
            this.ele2 = ele2;
            this.ele3 = ele3;
        }

        @Override
        public String toString() {

            return "( " + this.ele1 + ", " + this.ele2 + " , " + this.ele3 + " )";
        }

    }

    public List<Triplet<Integer>> findTriplets(int[] input, int target) {
        // assuming input array is sorted.
        int size = input.length;
        int startIndex, endIndex = size-1;
        List<Triplet<Integer>> result = new ArrayList<>();

        for(int i=0; i < size; i++) {
            int curr = input[i];
            int remaining = target - curr;
            startIndex = i + 1;
            endIndex = size-1;

            while(startIndex < endIndex ){

                if(input[startIndex] + input[endIndex] > remaining) {
                    endIndex--;
                } else if(input[startIndex] + input[endIndex] < remaining) {
                    startIndex++;
                } else {
                    Triplet triplet = new Triplet(curr, input[startIndex], input[endIndex]);
                    startIndex++;
                    endIndex--;
                    result.add(triplet);

                }

            }

        }
        return result;

    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5,6,7,8,9,15};
        FindAllTriplets findAllTriplets = new FindAllTriplets();
        List<Triplet<Integer>> result = findAllTriplets.findTriplets(input, 18);

        for(Triplet triplet : result) {
            System.out.println(triplet.toString());
        }
    }

}
