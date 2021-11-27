package com.nelluri.sorting;

public class QuickSort {

    public QuickSort() {
        // default constructor
    }

    public void sort(int[] input) {
        int startIndex = 0;
        int endIndex = input.length-1;
        // array has more than 1 elements
        if(input.length > 1) {
            quickSort(input, startIndex, endIndex);
        }
    }

    private void quickSort(int[] elements,int start, int end) {
        if(end <= start) {
            return;
        }
        int lower = start;
        int upper = end;

        // choosing first element as pivot
        int pivot = elements[start];

        while(lower < upper) {
            while (elements[lower] <= pivot) {
                lower++;
            }
            while (elements[upper] >= pivot) {
                upper--;
            }
            if (lower < upper) {
                // swap elements present at indexes lower, upper.
                int temp = elements[lower];
                elements[lower] = elements[upper];
                elements[upper] = temp;
                lower++;
                upper--;
            }
        }

        // Position at index 'upper' is the correct position for pivot.
        elements[start] = elements[upper];
        elements[upper]   = pivot;
        // recursively apply quicksort for all elements before pivot and after pivot.
        quickSort(elements, start, upper - 1);
        quickSort(elements, upper+1, end);
    }

    public void printElements(int[] input) {
        for(int ele:input) {
            System.out.print(ele + "\t");
        }
    }
    public static void main(String[] args) {
        int[] input = new int[]{12,34,11,9,8,25,11,12,0};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(input);
        quickSort.printElements(input);
    }
}
