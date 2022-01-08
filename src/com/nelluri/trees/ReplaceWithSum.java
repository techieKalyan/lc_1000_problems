package com.nelluri.trees;

import org.apache.poi.ss.formula.functions.Replace;

/**
 * https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/lecture/25926266#overview
 */

public class ReplaceWithSum {
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


    public int replace(TreeNode root) {

        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.data;
        }

        int leftSum = replace(root.left);
        int rightSum = replace(root.right);

        int tmp = root.data;
        root.data = leftSum + rightSum;

        return tmp + root.data;


    }

    public void printTree(TreeNode root) {
        if(root != null) {
            printTree(root.left);
            System.out.println(root.data);
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        root.left.right.left = new TreeNode(7);

        ReplaceWithSum replace = new ReplaceWithSum();
        replace.replace(root);

        replace.printTree(root);
    }
}
