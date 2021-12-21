package com.nelluri.trees;

import com.nelluri.trees.Tree.*;
public class MorrisTraversal {

    public void inorderTraversal(Node root) {

        while(root != null) {
            if(root.left == null) {
                System.out.print(root.data + " ");
                root = root.right;
            } else {
                Node tmp = root.left;
                while(tmp.right != null && tmp.right != root) {
                    tmp = tmp.right;
                }
                if(tmp.right == null) {
                    tmp.right = root;
                    root = root.left;
                } else {
                    System.out.print(root.data + " ");
                    tmp.right = null;
                    root = root.right;
                }
            }
        }

    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.createCompleteBT(new int[]{1,2,3,4,5,6,7,8,9,10}, 0);
        MorrisTraversal morrisTraversal = new MorrisTraversal();
        morrisTraversal.inorderTraversal(root);
    }
}
