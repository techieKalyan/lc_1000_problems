package com.nelluri.trees;

public class Tree {
    Node root;
     static class Node {
        int data;
        Node left, right;
        Node(int val) {
            this.data = val;
            this.left = this.right = null;

        }

        Node(int val, Node leftVal, Node rightVal) {
            this.data = val;
            this.left = leftVal;
            this.right = rightVal;
        }

    }

    public Tree() {
        root = null;
    }

    public Node createCompleteBT(int[] input,int startIndex) {
        Node curr = new Node(input[startIndex]);
        int leftChild = 2 * startIndex + 1;
        if(leftChild < input.length) {
            curr.left = createCompleteBT(input,leftChild);
        }
        int rightChild = 2 * startIndex + 2;
        if(rightChild < input.length) {
            curr.right = createCompleteBT(input, rightChild);
        }
        return curr;
    }

    public void displayTreeInPreOrder(Node root) {
        if(root != null) {
            System.out.print(root.data + " ");
            displayTreeInPreOrder(root.left);
            displayTreeInPreOrder(root.right);
        }
    }

    public boolean search(Node root , int key) {
        if(root == null) {
            return false;
        }
        if(root.data == key) {
            return true;
        }
        boolean left = search(root.left, key);
        if(left == false) {
            return search(root.right, key);
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        Node root = t.createCompleteBT(new int[]{1,2,3,4,5,6,7,8,9,10}, 0);
        t.displayTreeInPreOrder(root);
        System.out.println(t.search(root,11));
    }

}
