package com.nelluri.sorting;

/*
Selection problem is used to find element at kth position once the array gets sorted without sorting the array.

Use median-of-medians approach when choosing pivot element to bring the complexity down to O(n).
Otherwise worst case complexity if O(n2), avg case is O(nlogn)
 */

public class Selection {

    private void quickSelect(int[] input, int start, int stop, int k) {
        if(stop <= start) {
            return;
        }
        int begin = start;
        int end = stop;
        int pivot = input[start];

        while(begin < end) {
            while(input[begin] <= pivot) {
                begin++;
            }
            while(input[end] >= pivot) {
                end--;
            }
            if( begin < end ) {
                int tmp = input[begin];
                input[begin] = input[end];
                input[end] = tmp;
                begin++;
                end--;
            }
        }
        input[start] = input[end];
        input[end] = pivot;
        // end now contains the correct position for selected pivot.
        if(k == end+1) {
            return;
        }
        if(k < end+1) {
            quickSelect(input, start, end-1,k);
        } else {
            quickSelect(input, end+1, stop, k);
        }
    }

    public int get(int[] elements, int k) {
        int left = 0;
        int right = elements.length - 1;
        quickSelect(elements, left, right, k);
        return elements[k-1];
    }

    public static void main(String[] args) {
        int[] elements = new int[]{8,1,2,4,3,6,5,7,9};
        Selection selection = new Selection();
        int element = selection.get(elements,7);
        System.out.println("element at position 7 is " + element);
    }
}
