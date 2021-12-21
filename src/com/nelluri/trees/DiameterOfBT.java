package com.nelluri.trees;

/*

LC : https://leetcode.com/problems/diameter-of-binary-tree
 */
class DiameterOfBT {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    int diameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {

        int retVal = diameterOfBinaryTreeUtil(root);
        return diameter;

    }

    public int diameterOfBinaryTreeUtil(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = diameterOfBinaryTreeUtil(root.left);
        int rightHeight = diameterOfBinaryTreeUtil(root.right);
        diameter = Math.max(diameter, leftHeight + rightHeight );

        return Math.max(leftHeight, rightHeight) + 1;
    }
}