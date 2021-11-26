package com.nelluri.sorting;

public class InsertionSort {

    public void sort(int[] input) {
        int size = input.length;
        // boundary cases. Size of array is 1 or input is null.
        if(size <= 1 || input == null) {
            return;
        }
        for(int i=1; i < size ; i++) {
            int temp= input[i]; // This elements needs to be placed in its correct position in initial sorted list.
            int j = i-1;
            while(j >= 0 && temp < input[j] ) {
                input[j+1] = input[j]; // create room for above temp element to be inserted in to sorted list.
                j--;
            }
            input[j+1] = temp; // insert element in to its correct position.
        }

    }

    public void printArray(int[] input) {
        for(int ele:input) {
            System.out.print(ele + "\t");
        }
    }

    public static void main(String[] args) {
        int[] unsortedArray = new int[]{0,3,6,9,15,30,0};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(unsortedArray);
        insertionSort.printArray(unsortedArray);
    }
}
