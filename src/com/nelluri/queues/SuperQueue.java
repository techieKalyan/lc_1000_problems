package com.nelluri.queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SuperQueue {
    Queue<Integer> queue;
    Deque<Integer> deque;

    SuperQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public void enqueue(int element) {
        queue.add(element);
        while(deque.isEmpty() == false && deque.getLast() <= element) {
            deque.removeLast();
        }
        deque.addLast(element);
    }

    public int dequeue() {
        int data = queue.remove();
        if(deque.getFirst() == data) {
            deque.removeFirst();
        }
        return data;
    }

    /*
    Maintain the elements in the decreasing order
     */
    public int findMax() {
        if(deque.isEmpty() == false) {
            return deque.getFirst();
        }
        return -1;
    }

    public static void main(String[] args) {
        SuperQueue superQueue = new SuperQueue();
        superQueue.enqueue(30);
        superQueue.enqueue(40);
        superQueue.enqueue(20);
        superQueue.enqueue(10);
        superQueue.enqueue(9);
        superQueue.enqueue(16);
        System.out.println(superQueue.findMax());
        superQueue.dequeue();
        System.out.println(superQueue.findMax());
        superQueue.dequeue();
        System.out.println(superQueue.findMax());
        superQueue.dequeue();
        System.out.println(superQueue.findMax());


    }
}
