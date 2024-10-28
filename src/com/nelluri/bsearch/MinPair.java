package com.nelluri.bsearch;

import java.util.Arrays;

public class MinPair {

    int findLowerBound(int key, int[] arr2) {
        int start = 0;
        int end = arr2.length;
        int answer = -1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(arr2[mid] >= key) {
               answer = mid;
               end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }

    void printMinPair(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;

        Arrays.sort(arr2);

        int globalMin = Integer.MAX_VALUE;
        int ans1 = -1, ans2 = -1;
        for(int i=0; i<len1; i++) {
            int ele1 = arr1[i];
            int ele2Index = findLowerBound(ele1, arr2);
            if(ele2Index > 0) {
                if ((Math.abs(ele1 - arr2[ele2Index]) < Math.abs(ele1 - arr2[ele2Index - 1]))) {
                    if (Math.abs(ele1 - arr2[ele2Index]) < globalMin) {
                        ans1 = ele1;
                        ans2 = arr2[ele2Index];
                        globalMin = Math.abs(ele1 - arr2[ele2Index]);
                    }
                } else {
                    ans1 = ele1;
                    ans2 = arr2[ele2Index - 1];
                    globalMin = Math.abs(ele1 - arr2[ele2Index - 1]);
                }
            }

        }
        System.out.println(String.format("%d and %d", ans1, ans2));
    }

    public static void main(String[] args) {
        MinPair minPair = new MinPair();
        int[] arr1 = new int[] {-1,5,10,20,3};
        int[] arr2 = new int[] {26,134,135,15,17};
        minPair.printMinPair(arr1, arr2);
//        Arrays.sort(arr2);
//        System.out.println(minPair.findLowerBound(20, arr2));
    }
}
