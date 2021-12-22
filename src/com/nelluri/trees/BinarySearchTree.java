package com.nelluri.trees;

public class BinarySearchTree {

    public static class Node {
        int data;
        Node left, right;

        Node(int val) {
            this.data = val;
            this.left = this.right = null;
        }
    }

    public boolean search(Node root, int key) {
        if(root == null) {
            return false;
        }
        Node curr = root;
        while(curr != null) {
            if (key == curr.data) {
                return true;
            } else if (key < root.data) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }

        }
        return false;
    }

    public Node insertElement(Node root, int element) {
        if(root == null) {
            Node curr = new Node(element);
            return curr;
        }

        if(element < root.data) {
            root.left = insertElement(root.left, element);
        } else {
            root.right = insertElement(root.right, element);
        }
        return root;

    }

    public void printInOrder(Node root) {
        if(root!=null) {
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }

    public Node deleteElement(Node root, int element) {
        if(root == null) {
            return null;
        }

        if(element < root.data) {
            root.left = deleteElement(root.left, element);
            return root;
        } else if (element > root.data) {
            root.right = deleteElement(root.right, element);
            return root;
        } else {
            // case 1
            if(root.left != null && root.right != null) {
                Node inorderSuccessor = findInorderSuccessor(root);
                root.data = inorderSuccessor.data;
                root.right = deleteElement(root.right,inorderSuccessor.data);
                return root;
            } else {
                Node tmp = (root.left != null) ? root.left: root.right;
                return tmp;
            }

        }

    }

    public boolean checkIfBSTOrNot(Node root, int prev) {
        if(root == null) {
            return true;
        }
        boolean left = checkIfBSTOrNot(root.left,prev);
        if(left == false || prev > root.data) {
            return false;
        }
        prev = root.data;
        return checkIfBSTOrNot(root.right,prev);

    }

    public Node findInorderSuccessor(Node root) {
        if(root == null) {
            return root;
        }
        Node tmp = root.right;
        while(tmp!= null && tmp.left != null) {
            tmp = tmp.left;
        }
        return tmp;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Node root = null;
        root = binarySearchTree.insertElement(root,10);
        root = binarySearchTree.insertElement(root,20);
        root = binarySearchTree.insertElement(root,3);
        root = binarySearchTree.insertElement(root,5);
        root = binarySearchTree.insertElement(root,9);
        binarySearchTree.printInOrder(root);
        System.out.println("Is BST or not ? " + binarySearchTree.checkIfBSTOrNot(root, Integer.MIN_VALUE));
        System.out.println("Is Key present ?" + binarySearchTree.search(root, 3));
        System.out.println("Is Key present ?" + binarySearchTree.search(root, 30));
        root = binarySearchTree.deleteElement(root,5);
       // root = binarySearchTree.deleteElement(root,3);

        //root = binarySearchTree.deleteElement(root,20);
        root = binarySearchTree.deleteElement(root,10);
        //binarySearchTree.deleteElement(root,9);

        binarySearchTree.printInOrder(root);


    }


}
