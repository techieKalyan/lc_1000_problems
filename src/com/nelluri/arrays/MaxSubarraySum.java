package com.nelluri.arrays;

/*
 Max sub array sum.
 https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/quiz/5166020#overview
 */
public class MaxSubarraySum {

    /*
    using prefix sum approach.
     */
    public int maxSubarraySum(int[] inputs) {
        int n = inputs.length;
        int[] prefixSums = new int[n];
        prefixSums[0] = inputs[0] > 0 ? inputs[0]:0;
        int maxValue = Integer.MIN_VALUE;
        for(int i=1; i < n; i++) {
            int tmp = prefixSums[i-1] + inputs[i];
            prefixSums[i] = tmp > 0 ?tmp:0;
            maxValue = Math.max(maxValue, prefixSums[i]);
        }
        return maxValue;
    }

    /*
    Extra space can be avoided.
     */
    public int maxSubarraySum2(int[] inputs) {
        int n = inputs.length;
        int initialValue = inputs[0] > 0 ? inputs[0]:0;
        int maxValue = Integer.MIN_VALUE;
        for(int i=1; i < n; i++) {
            int tmp = initialValue + inputs[i];
            initialValue = tmp > 0 ?tmp:0;
            maxValue = Math.max(maxValue, initialValue);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        MaxSubarraySum maxSubarraySum = new MaxSubarraySum();
        int[] input = new int[] {1,2,3,4,-2,6,-8,3};
        System.out.println(maxSubarraySum.maxSubarraySum2(input));
    }
}
