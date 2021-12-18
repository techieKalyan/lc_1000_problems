package com.nelluri.queues;

public class QueueUsingLL {
    public static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    Node tail= null;
    int size = 0;
    /*
    Elements should be added at the end via tail pointer.
     */
    public void enqueue(int element) {
        Node tmp;
        if(tail == null) {
            tail = new Node(element,tail);
            tail.next = tail;
            return;
        } else if(tail.next == tail) {
            tail.next = new Node(element,tail.next);
            tail = tail.next;
        } else {
            tail.next = new Node(element, tail.next);
             tail = tail.next;
        }
        size++;
    }

    /*
    We are making list as circular so that it is easier to dequeue.
    Elements should be dequeued from the front of the list.
     */
    public int dequeue() throws IllegalStateException {
        if(tail == null) {
            throw new IllegalStateException("Queue is empty");
        } else if(tail.next == tail) {
            int data = tail.data;
            tail = null;
            size--;
            return data;
        } else {
            int data = tail.next.data;
            tail.next = tail.next.next;
            size--;
            return data;
        }
    }
    /*
    Should return value from the front of queue
     */
    public int peek() throws IllegalStateException {
        if(tail == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return tail.next.data;
    }

    public static void main(String[] args) {
        QueueUsingLL queueUsingLL = new QueueUsingLL();
        queueUsingLL.enqueue(10);
        queueUsingLL.enqueue(20);
        queueUsingLL.enqueue(30);
        queueUsingLL.enqueue(40);
        queueUsingLL.enqueue(50);

        for(int i=0; i < 5; i++) {
            System.out.println(queueUsingLL.dequeue());
        }
    }

}
