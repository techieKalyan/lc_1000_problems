package com.nelluri.lists;

import com.nelluri.lists.CustomLinkedList.Node;

public class RemoveLoop {

    public boolean detectLoop(CustomLinkedList list) {
        Node head = list.head;
        Node slowPtr, fastPtr;
        slowPtr=head;
        fastPtr=head;
        if(head == null || head.next == null) {
            return false;
        }
        if(head.next == head) {
            return true;
        }

        while(fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr) {
                return true;
            }
        }
        return false;

    }

    public void removeLoop(CustomLinkedList list) {
        Node head = list.head;
        Node slowPtr, fastPtr;
        slowPtr=head;
        fastPtr=head;
        if(head == null || head.next == null) {
            return;
        }
        if(head.next == head) {
            head.next = null;
            return;
        }

        while(fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr) {
                // Loop is detected

                // Step1: find length of the loop
                int lenOfLoop = findLengthOfLoop(slowPtr);

                // Step2: Initialize slow and fast pointers at a distance of lenOfLoop
                slowPtr = head;
                fastPtr = head;
                while(lenOfLoop > 0) {
                    fastPtr = fastPtr.next;
                    lenOfLoop--;
                }
                // step3: Keep moving ptrs until they meet.
                Node tmp = null;
                while(slowPtr != fastPtr) {
                    slowPtr = slowPtr.next;
                    tmp = fastPtr;
                    fastPtr = fastPtr.next;
                }
                tmp.next = null;
            }
        }
    }

    public int findLengthOfLoop(Node slowPtr) {
        Node tmpPtr = slowPtr;
        slowPtr = slowPtr.next;
        int length = 1;
        while(slowPtr != tmpPtr) {
            length++;
            slowPtr = slowPtr.next;
        }
        return length;
    }

    public static void main(String[] args) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addHead(3);
        customLinkedList.addHead(2);
        customLinkedList.addHead(1);
        customLinkedList.addTail(4);
        customLinkedList.addTail(5);
        customLinkedList.addTail(6);

        // create a loop in the linked list
        customLinkedList.head.next.next.next.next.next =  customLinkedList.head.next;

        RemoveLoop removeLoop = new RemoveLoop();
        System.out.println("is Loop detected ? " + removeLoop.detectLoop(customLinkedList));

        removeLoop.removeLoop(customLinkedList);

        customLinkedList.printList();

    }
}
