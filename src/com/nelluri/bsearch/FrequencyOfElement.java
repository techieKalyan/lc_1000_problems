package com.nelluri.bsearch;

/*
https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/lecture/24025190#overview
 */

public class FrequencyOfElement {

    public int findLowerBound(int[] input, int key) {
        int start = 0;
        int end = input.length - 1;
        int mid;
        int answer = -1;

        while(start <= end) // while there is atleast one element in the array
        {
            mid = start + (end-start)/2;
            if(key == input[mid]) {
                answer = mid;
                end = mid-1;
            } else  if(key > input[mid]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return answer;
    }

    public int findUpperBound(int[] input, int key) {
        int start = 0;
        int end = input.length - 1;
        int mid;
        int answer = -1;

        while(start <= end) // while there is atleast one element in the array
        {
            mid = start + (end-start)/2;
            if(key == input[mid]) {
                answer = mid;
                start = mid+1;
            } else  if(key > input[mid]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        FrequencyOfElement frequencyOfElement = new FrequencyOfElement();
        int[] input = new int[] {0,1,1,1,2,2,2,2,5,5,9,9};
        int key = 0;
        System.out.println("Frequency is " + (frequencyOfElement.findUpperBound(input, key) -frequencyOfElement.findLowerBound(input, key) + 1));
    }
}
