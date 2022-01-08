package com.nelluri.trees;

/**
 *
 * Nice problem
 * https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/lecture/25944562#overview

 */
public class MaxSubsetSumTree {

    public static class IncludeExcludePair {
        int inc;
        int exc;
        IncludeExcludePair() {
            this.inc = this.exc = 0;
        }
        IncludeExcludePair(int v1, int v2) {
            this.inc = v1;
            this.exc = v2;
        }
    }

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

    public IncludeExcludePair getMaxSubsetSum(TreeNode root) {
        IncludeExcludePair pair = new IncludeExcludePair();
        if(root == null) {
            pair.inc = pair.exc = 0;
            return pair;
        }

        IncludeExcludePair left = getMaxSubsetSum(root.left);
        IncludeExcludePair right = getMaxSubsetSum(root.right);

        pair.inc = root.data + left.exc + right.exc;
        pair.exc = Math.max(left.inc, left.exc) + Math.max(right.inc, right.exc);

        return pair;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        root.left.right.left = new TreeNode(7);

        MaxSubsetSumTree maxSubsetSumTree = new MaxSubsetSumTree();
        IncludeExcludePair pairResponse = maxSubsetSumTree.getMaxSubsetSum(root);

        System.out.println("Max subset sum value is " + Math.max(pairResponse.inc, pairResponse.exc));
    }

}
