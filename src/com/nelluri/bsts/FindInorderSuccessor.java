package com.nelluri.bsts;

import com.nelluri.trees.*;

import com.nelluri.bsts.BinarySearchTree.Node;
public class FindInorderSuccessor {

    public Node findInorderSuccessor(Node root, Node target) {
        if(root == null) {
            return root;
        }

        Node tmp = target.right;
        if(tmp != null) {
            while(tmp.left != null) {
                tmp = tmp.left;
            }
            return tmp;
        } else {
            Node successor = root;
            Node curr = root;

            while( curr != null) {
                if(curr.data > target.data) {
                    successor = curr;
                    curr = curr.left;
                } else if(curr.data < target.data){
                    curr = curr.right;
                } else {
                    break;
                }
            }
            return successor;
        }


    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        BinarySearchTree.Node root = null;
        root = binarySearchTree.insertElement(root,8);
        root = binarySearchTree.insertElement(root,3);
        root = binarySearchTree.insertElement(root,10);
        root = binarySearchTree.insertElement(root,1);
        root = binarySearchTree.insertElement(root,6);
        root = binarySearchTree.insertElement(root,14);
        root = binarySearchTree.insertElement(root,4);
        root = binarySearchTree.insertElement(root,7);
        root = binarySearchTree.insertElement(root,13);
      //  binarySearchTree.printInOrder(root);


        FindInorderSuccessor findInorderSuccessor = new FindInorderSuccessor();
        Node k1 = root.left.right.right;
        Node result = findInorderSuccessor.findInorderSuccessor(root, k1);
        System.out.println(result.data);
        Node k2= root.right;
        result = findInorderSuccessor.findInorderSuccessor(root, k2);
        System.out.println(result.data);

    }
}
