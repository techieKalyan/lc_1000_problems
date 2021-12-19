package com.nelluri.trees;

import com.nelluri.trees.Tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    Queue<Node> queue;

    public BFS() {
        queue = new LinkedList<>();
    }

    public void search(Node curr) {
        if(curr == null) {
            return;
        }
        int count = 0;
        queue.add(curr);
        while(queue.isEmpty() == false) {
            count = queue.size();
            while (count > 0) {
                Node tmp = queue.remove();
                System.out.print(tmp.data + " ");
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
                count--;
            }
            System.out.println(" ");
        }

    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.createCompleteBT(new int[]{1,2,3,4,5,6,7,8,9,10}, 0);
        BFS bfs = new BFS();
        bfs.search(root);
    }
}
