package com.nelluri.sorting;

/*
Prob6
 */
public class MergeSort {
    int[] inputElements;

    MergeSort(int[] elements) {
        this.inputElements = elements;
    }

    public void mergeSort() {
        // Mergesort uses additional storage for sorting.
        int[] temp = new int[inputElements.length];

        this.helperMergeSort(this.inputElements,temp,0,this.inputElements.length-1);
    }

    private void helperMergeSort(int[] elements, int[] temp, int left, int right) {
        if(right <= left) {
            return;
        }
        int median = (left + right) /2;
        this.helperMergeSort(elements,temp, left, median);
        this.helperMergeSort(elements,temp, median + 1, right);
        merge(elements, temp,left,median,right);
    }

    public void merge(int[] input, int[] temp, int left, int median, int right) {
        int leftStart  = left;
        int leftEnd = median;
        int rightStart = median+1;
        int rightEnd = right;
        int k = 0;
        while(leftStart <= leftEnd && rightStart <= rightEnd) {
            if(input[leftStart] < input[rightStart]) {
                temp[k++] = input[leftStart];
                leftStart++;
            } else {
                temp[k++] = input[rightStart];
                rightStart++;
            }
        }
        while(leftStart <= leftEnd) {
            temp[k++] = input[leftStart];
            leftStart++;
        }
        while(rightStart <= rightEnd) {
            temp[k++] = input[rightStart];
            rightStart++;
        }

        for(int i= 0 ; i < k ; i++) {
            input[left++] = temp[i];
        }


    }

    public void printElements() {
        for(int ele: this.inputElements) {
            System.out.print(ele + "\t");
        }
    }

    public static void main(String[] args) {
        int[] unsortedElements = new int[]{23,12,10,4,5,34,0,99,12};
        MergeSort  mergeSort = new MergeSort(unsortedElements);
        mergeSort.mergeSort();
        mergeSort.printElements();
    }
}
