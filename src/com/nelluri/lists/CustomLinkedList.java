package com.nelluri.lists;

public class CustomLinkedList {

    /*
    Structure of the linked list node.
     */
    public static class Node {
        int data;
        Node next;
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    Node head;
    int size = 0;

    /*
    Adds the node at the beginning of the list
     */
    public void addHead(int val) {
        head = new Node(val, head);
        size++;
    }

    /*
    Adds the node at the end of the list
     */
    public void addTail(int val) {
        if(head == null) {
            head = new Node(val, head);
            size++;
            return;
        }
        Node curr = head;

        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(val, null);
        size++;
    }
    /*
    Use sentinel node for removal of nodes. This makes it very simple to code it.
     */
    public boolean removeOptimized(int val) {
        Node sentinel = new Node(-1,null);
        sentinel.next = head;
        Node curr = head;
        Node prev = sentinel;

        while(curr != null) {
            if(curr.data == val) {
                prev.next = curr.next;
                curr = curr.next;
                return true;
            } else {
                prev = prev.next;
                curr = curr.next;
            }

        }
        sentinel = null;
        return false;
    }


    /*
    searches for the element in the list and removes it if the element is found.
     */
    public boolean remove(int val) {
        if(size == 0) {
            return false;
        }
        if(head.next == null ) {
            if(head.data == val) {
                head = null;
                size--;
                return true;
            } else {
                return false;
            }
        }
        Node curr = head.next;
        Node prev = head;

        while(curr != null) {
            if(curr.data == val) {
                break;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        if(curr != null) {
            prev.next = curr.next;
            size--;
            return true;
        } else {
            return false;
        }

    }

    /*
    Reverses the linked list
     */
    public void reverseList() {
        if(size == 0 || size == 1) {
            return;
        }
        Node curr, prev;
        curr = head;
        prev = null;
        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        head = prev;

    }
    /*
    Prints the elements of the linked list.
     */
    public void printList() {
        if(size == 0) {
            return;
        }
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addHead(3);
        customLinkedList.addHead(2);
        customLinkedList.addHead(1);
        customLinkedList.printList();
        customLinkedList.addTail(4);
        customLinkedList.addTail(5);
        customLinkedList.addTail(6);
        customLinkedList.printList();
        customLinkedList.removeOptimized(2);
        customLinkedList.removeOptimized(6);
        customLinkedList.printList();
        customLinkedList.reverseList();
        customLinkedList.printList();
    }

}
