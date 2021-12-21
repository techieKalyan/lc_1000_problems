package com.nelluri.trees;

import java.util.HashSet;
import java.util.Set;

/*
Given the roots of two binary search trees, root1 and root2,
return true if and only if there is a node in the first tree and a
node in the second tree whose values sum up to a given integer target.

https://leetcode.com/problems/two-sum-bsts/
 */
public class TwoSumBST {

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

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {

        Set<Integer> lookupSet = new HashSet<Integer>();

        traverseAndLog(root1,target,lookupSet);

        return traverseAndCheck(root2, lookupSet);
    }

    public void traverseAndLog(TreeNode curr, int target, Set<Integer> lookupSet) {
        if(curr == null) {
            return;
        }
        lookupSet.add(target - curr.val);
        traverseAndLog(curr.left,target,lookupSet);
        traverseAndLog(curr.right, target, lookupSet);

    }

    public boolean traverseAndCheck(TreeNode curr, Set<Integer> lookupSet) {
        if(curr == null) {
            return false;
        }
        if(lookupSet.contains(curr.val)) {
            return true;
        }

        boolean retVal = traverseAndCheck(curr.left, lookupSet);
        return retVal || traverseAndCheck(curr.right, lookupSet);

    }

}
