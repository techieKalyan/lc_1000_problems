package com.nelluri.trees;

public class ThreadedBT {

    private static class Node {
        int data;
        Node left, right;
        boolean isThreaded;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
            this.isThreaded = false;
        }

    }
    public Node convertToThreadedBT(Node root) {
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null) {
            return root;
        }
        /* Find inorder predecessor and point it to current node. */
        if(root.left != null) {
            Node tmp = convertToThreadedBT(root.left);
            tmp.right = root;
            tmp.isThreaded = true;
        }
        if(root.right == null) {
            return root;
        }
        // Recur for right subtree
        return convertToThreadedBT(root.right);

    }

    public Node getLeftMostNode(Node curr) {
        if(curr == null) {
            return curr;
        }
        while(curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public void inorderTraversal(Node root) {
        if(root == null) {
            return;
        }
        Node curr = getLeftMostNode(root);
        while(curr != null) {
            System.out.print(curr.data + " ");
            if (curr.isThreaded) {
                curr = curr.right;
            } else {
                curr = getLeftMostNode(curr.right);
            }
        }
    }


    public static void main(String args[])
    {
   /*       1
            / \
           2   3
          / \ / \
         4  5 6  7   */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ThreadedBT threadedBT = new ThreadedBT();
        threadedBT.convertToThreadedBT(root);
        System.out.println("Inorder traversal of created "+"threaded tree is\n");
        threadedBT.inorderTraversal(root);
    }
}
