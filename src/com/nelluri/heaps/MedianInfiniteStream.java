package com.nelluri.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/*
Prob4
Computing median element in continuous stream of integers.
 */
public class MedianInfiniteStream {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    MedianInfiniteStream() {
        minHeap = new PriorityQueue<Integer>(); // creates min heap by default
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder()); // creates max heap.
    }

    public void addElement(int element) {
        if(maxHeap.size() ==0 || maxHeap.peek() >= element) {
            maxHeap.add(element);
        } else {
            minHeap.add(element);
        }
        // re-balance the heaps post addition of input element.
        if(maxHeap.size()-minHeap.size() > 1) {
            int data = maxHeap.remove();
            minHeap.add(data);
        } else if(minHeap.size()-maxHeap.size() > 1) {
            int data = minHeap.remove();
            maxHeap.add(data);
        }
    }

    public int getMedian() {
        if(maxHeap.size() == 0 && minHeap.size() == 0) {
            return -1;
        }
        if(maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek())/2;
        } else if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianInfiniteStream medianInfiniteStream = new MedianInfiniteStream();
        int[] arr = new int[]{1,9,2,8,3,7};

        for(int ele:arr) {
            medianInfiniteStream.addElement(ele);
            System.out.println("Median of elements after addition of " + ele + " is " + medianInfiniteStream.getMedian());
        }

    }
}
