package com.nelluri.tries;

/*
Compute biggest XOR between elements of array in O(n) time complexity.
interesting problem.

https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/lecture/23544966#overview

 */


class BinaryTrie {
    // Lets create a binary trie. If it has left child , it indicates 0 and we dont have to store any other data.
    // if it has right child, it indicates bit 1.

    public class Node {
        Node left;
        Node right;
        boolean isLast;

        Node() {
            left = right = null;
            isLast = false;
        }
    }
    Node root;

    public BinaryTrie() {
        root = new Node();
    }

    public void addNumber(int input) {
        Node curr = root;

        if(curr == null) {
            curr = new Node();
        }

        for(int i=31; i >= 0; i--) {
            int eachBit = (input >> i) & 1;

            if(eachBit == 0) {
                if(curr.left != null) {
                    curr = curr.left;
                } else {
                    curr.left = new Node();
                    curr = curr.left;
                }
            } else {
                if(curr.right != null) {
                    curr = curr.right;
                } else {
                    curr.right = new Node();
                    curr = curr.right;
                }
            }

        }
        curr.isLast = true;

    }


}

public class BiggestXOR {

    public int searchLargestXOR(BinaryTrie trie, int element) {
        BinaryTrie.Node curr = trie.root;
        int currXOR = 0;
        for(int i=31 ; i >=0 ;i--) {
            if(curr == null) {
                return Integer.MIN_VALUE;
            }
            int currentBit = (element >> i) & 1;
            if(currentBit == 1) {
                if(curr.left != null) {
                    curr = curr.left;
                    currXOR += 1 << i;
                } else {
                    curr = curr.right;
                }
            } else {
                if(curr.right != null) {
                    curr = curr.right;
                    currXOR += 1 << i;
                } else {
                    curr = curr.left;
                }
            }
        }
        return currXOR;


    }

    public static void main(String[] args) {
        int[] input= new int[] {3,10,5,25,9,2};
        BinaryTrie trie = new BinaryTrie();
        BiggestXOR biggestXOR = new BiggestXOR();
        int maximumXOR = Integer.MIN_VALUE;
        for(int ele: input) {
            trie.addNumber(ele);
            int currentXOR = biggestXOR.searchLargestXOR(trie, ele);
            maximumXOR = Math.max(maximumXOR, currentXOR);
        }

        System.out.print(" Maximum XOR is " + maximumXOR);

    }







}
