package com.nelluri.arrays;

/*
Compute product of array elemts without using division.

https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/quiz/5209732#overview
 */
public class ArrayProducts {

    public int[] computeArrayProducts(int[] elements) {
        int n= elements.length;
        int[] leftProducts = new int[n];
        leftProducts[0]=1;
        int[] rightProducts = new int[n];
        rightProducts[n-1] = 1;
        for(int i=1; i < n ; i++) {
            leftProducts[i] = leftProducts[i-1] * elements[i-1];
            rightProducts[n-i-1] = rightProducts[n-i] * elements[n-i];
        }

        int[] result = new int[n];

        for(int i=0; i < n; i++) {
            result[i] = leftProducts[i] * rightProducts[i];
        }

        return result;
    }


    public static void main(String[] args) {
        ArrayProducts arrayProducts = new ArrayProducts();
        int[] input = new int[] {1,2,3,4,5};
        int[] result = arrayProducts.computeArrayProducts(input);

        for(int x:result) {
            System.out.println(x);
        }
    }
}
