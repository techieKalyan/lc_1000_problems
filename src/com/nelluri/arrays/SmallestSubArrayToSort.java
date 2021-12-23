package com.nelluri.arrays;

/*

Find smallest sub-array that needs to be sorted to make the entire array as sorted.
e.g: A[] = {1,2,3,4,5,8,6,7,9,10,11};
o/p: 5,7
which means elements between [8,6,7] needs to be sorted so that entire array will be sorted.

Discussed here: https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/lecture/25191994#announcements

Approach: Identify the elements which are out of order. Figure out the min and max elements among out of order elements.
Find the right indices in sorted array for min and max out of order elements.

 */

public class SmallestSubArrayToSort {
    SmallestSubArrayToSort() {

    }

    public int[] subArrayToSort(int[] input, int length) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        for(int i=0; i < length ; i++) {
            int x = input[i];
            if(this.outOfOrder(input,i)) {
                smallest = Math.min(smallest, x);
                largest = Math.max(largest, x);
            }
        }
        System.out.println(" smallest = " + smallest);
        System.out.println(" largest = " + largest);

        if(smallest == Integer.MAX_VALUE) {
            return new int[]{-1,-1};
        }

        // find correct positions of smallest element in the array

        int left=0;

        while(smallest > input[left]) {
            left++;
        }

        int right = input.length-1;
        while(largest < input[right]) {
            right--;
        }
        return new int[] {left, right};
    }

    public boolean outOfOrder(int[] input, int index) {
        int x = input[index];

        if(index == 0) {
            return x > input[1];
        }
        if(index == input.length - 1) {
            return x < input[index-1];
        }

        return x < input[index-1] || x > input[index+1];
    }

    public static void main(String[] args) {
        SmallestSubArrayToSort smallestSubArrayToSort = new SmallestSubArrayToSort();
        int[] input = new int[] {1,2,3,4,5,8,6,7,9,10,11};
        int[] result = smallestSubArrayToSort.subArrayToSort(input, input.length);
        System.out.println(" { " + result[0] + ", " + result[1] + " } ");
    }
}
