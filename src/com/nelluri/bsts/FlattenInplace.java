package com.nelluri.bsts;

import com.nelluri.trees.Tree;

/*
We need to flatten the given binary search tree in to a linked list.
This needs to be done in place.

https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/lecture/26479964#overview
 */
/* idea is simple :

1. create linkedlist out of left subtree
2. create linkedlist out of right subtree
3. insert root node in the correct position of resulting list.

 */
public class FlattenInplace {

    public class LinkedList {
        Tree.Node head, tail;
        LinkedList() {
            head = tail = null;
        }
    }

    public LinkedList flatten(Tree.Node root) {
        LinkedList linkedList = new LinkedList();
        if(root == null) {
            linkedList.head = linkedList.tail = root;
        }
        if(root.left == null && root.right == null) {
            linkedList.head = linkedList.tail = root;
        } else if(root.left != null && root.right == null) {
            LinkedList linkedListLeft = flatten(root.left);
            linkedListLeft.tail.right = root;
            linkedList.head = linkedListLeft.head;
            linkedList.tail = root;

        } else if(root.left == null && root.right != null) {
            LinkedList linkedListRight = flatten(root.right);
            root.right = linkedListRight.head;
            linkedList.head = root;
            linkedList.tail = linkedListRight.tail;

        } else {
            LinkedList linkedListLeft = flatten(root.left);
            linkedListLeft.tail.right = root;
            linkedList.head = linkedListLeft.head;
            LinkedList linkedListRight = flatten(root.right);
            root.right = linkedListRight.head;
            linkedList.tail = linkedListRight.tail;
        }
        return linkedList;
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        Tree.Node root = t.createCompleteBT(new int[]{1,2,3,4,5,6,7,8,9,10}, 0);
        FlattenInplace inplace = new FlattenInplace();
        LinkedList linkedList = inplace.flatten(root);

        Tree.Node curr = linkedList.head;
        while(curr != null) {
            System.out.print(curr.data + "==>");
            curr = curr.right;
        }



    }
}
