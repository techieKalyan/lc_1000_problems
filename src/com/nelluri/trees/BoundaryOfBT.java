package com.nelluri.trees;

import java.util.ArrayList;
import java.util.List;

/*

https://leetcode.com/problems/boundary-of-binary-tree

The boundary of a binary tree is the concatenation of the root, the left boundary, the leaves ordered from left-to-right, and the reverse order of the right boundary.
 */
public class BoundaryOfBT {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        public List<Integer> leftNodes = new ArrayList<Integer>();
        public List<Integer> rightNodes = new ArrayList<Integer>();
        public List<Integer> leaves = new ArrayList<Integer>();


        public List<Integer> boundaryOfBinaryTree(TreeNode root) {

            List<Integer> resultList = new ArrayList<Integer>();

            if (root.left == null && root.right == null) {
                resultList.add(root.val);
                return resultList;
            }

            getLeftBoundaryNodes(root.left);
            getRightBoundaryNodes(root.right);
            captureLeavesLeftToRight(root);

            // add root node
            resultList.add(root.val);
            // add nodes on left boundary
            resultList.addAll(leftNodes);
            // add leaves from left to right
            resultList.addAll(leaves);
            // add nodes from right boundary
            resultList.addAll(rightNodes);

            // return final result
            return resultList;
        }


        public void getLeftBoundaryNodes(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                // leaf node. do nothing
            }
            if (root.left != null) {
                leftNodes.add(root.val);
                getLeftBoundaryNodes(root.left);
            } else if (root.right != null) {
                leftNodes.add(root.val);
                getLeftBoundaryNodes(root.right);
            }

        }


        public void getRightBoundaryNodes(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                // leaf node. Do nothing.
            }
            if (root.right != null) {

                getRightBoundaryNodes(root.right);
                rightNodes.add(root.val);
            } else if (root.left != null) {

                getRightBoundaryNodes(root.left);
                rightNodes.add(root.val);
            }
        }

        public void captureLeavesLeftToRight(TreeNode root) {


            if (root != null) {
                captureLeavesLeftToRight(root.left);
                if (root.left == null && root.right == null) {
                    leaves.add(root.val);
                }
                captureLeavesLeftToRight(root.right);

            }

        }

    }
}
