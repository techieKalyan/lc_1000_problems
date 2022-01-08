package com.nelluri.trees;

/*
https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/lecture/25978302#overview

important problem.
 */
public class NodesAtDistanceK {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.data = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public void printNodesAtK(TreeNode curr, int k) {
        if(curr == null) {
            return;
        }
        if(k==0) {
            System.out.println(curr.data);
            return;
        }

        printNodesAtK(curr.left, k-1);
        printNodesAtK(curr.right, k-1);

    }
    
    public int getNodesAtDistanceK(TreeNode root, TreeNode target, int k) {
        if(root == null) {
            return -1;
        }

        if(root == target) {
            // if the target node is found , print all its descendants and return 0.
            printNodesAtK(target,k);
            return 0;
        }

        int left_distance = getNodesAtDistanceK(root.left, target, k);
        if(left_distance != -1) {
            // target node is on the left
            if(left_distance + 1 == k) {
                System.out.println(root.data);
            } else {
                printNodesAtK(root.right, k - left_distance - 2);
            }
            return 1+left_distance;
        }

        int right_distance = getNodesAtDistanceK(root.right, target, k);
        if(right_distance != -1) {
            if(right_distance + 1 == k) {
                System.out.println(root.data);
            } else {
                printNodesAtK(root.left,  k - right_distance - 2);
            }
            return 1+right_distance;

        }
        // if target is not found in either left subtree or right subtree , return -1.
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);

        root.left.right.right.left = new TreeNode(9);
        root.left.right.right.right = new TreeNode(10);



        NodesAtDistanceK nodesAtDistanceK = new NodesAtDistanceK();
        nodesAtDistanceK.getNodesAtDistanceK(root, root.left.right, 2);
    }
}
