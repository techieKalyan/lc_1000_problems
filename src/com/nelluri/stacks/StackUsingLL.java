package com.nelluri.stacks;

public class StackUsingLL {
    int size=0;
    Node head = null;

    private static class Node {
        int data;
        Node next;
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void push(int element) {
        head = new Node(element, head);
        size++;
    }

    public int peek() {
        if(head == null) {
            return -1;
        }
        return head.data;
    }

    public int pop() {
        if(head == null) {
            return -1;
        }
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public void displayElements() {
        Node curr = head;
        while(curr!= null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        StackUsingLL stackUsingLL = new StackUsingLL();
        stackUsingLL.push(10);
        stackUsingLL.push(3);
        stackUsingLL.push(1);
        stackUsingLL.push(2);
        stackUsingLL.push(9);
        stackUsingLL.displayElements();
        stackUsingLL.pop();
        stackUsingLL.pop();
        System.out.println(" ");
        stackUsingLL.displayElements();
    }
}
