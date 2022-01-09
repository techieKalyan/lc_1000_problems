package com.nelluri.bsearch;

/*
Excellent problem and explanation.
https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/lecture/24412866#overview
 */
public class RotatedSearch {

    public int search(int[] input, int key) {
        int start = 0;
        int end = input.length - 1;
        int mid;

        while(start <= end) {
            mid = start + (end-start)/2;
            if(key == input[mid]) {
                return mid;
            } else if(input[start] <= input[mid]) {
                // mid lies in the first monotonic increasing array
                if(input[start] <= key && key <= input[mid]) {
                    // if key lies between first range
                    end = mid-1;
                } else {
                    start = mid + 1;
                }
            } else if(input[end] >= input[mid]){
                // mid lies in the second monotonic increasing array.
                if(input[mid] <= key && key <= input[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        RotatedSearch rotatedSearch = new RotatedSearch();
        int[] input = new int[] {22,24,26,28,12,14,18,20};
        System.out.println(rotatedSearch.search(input, 18));
    }
}
