package com.nelluri.strings;

public class Trie {
    private static final int CHAR_COUNT = 26;

    private class Node {
        boolean isLast;
        Node[] childs;

        public Node(char c) {
            isLast = false;
            childs = new Node[CHAR_COUNT];
            for (Node node : childs) {
                node = null;
            }
        }
    }

    Node root;

    public Trie() {
        root = new Node(' ');
    }

    public void addString(String input) {
        if (input == null) {
            return;
        }
        addString(root, input, 0);
    }

    public Node addString(Node curr, String input, int index) {
        if (curr == null) {
            curr = new Node(' ');
        }
        if (index == input.length()) {
            curr.isLast = true;
        } else {
            curr.childs[input.charAt(index) - 'a'] = addString(curr.childs[input.charAt(index) - 'a'], input, index + 1);
        }
        return curr;
    }

    public void remove(String input) {
        if (input == null) {
            return;
        }
        remove(root, input, 0);
    }

    public void remove(Node curr, String input, int index) {
        if (curr == null) {
            return;
        }
        if (index == input.length()) {
            if (curr.isLast) {
                curr.isLast = false;
                return;
            }
        }
        remove(curr.childs[input.charAt(index) - 'a'], input, index + 1);
    }

    boolean find(String input) {
        if (input == null) {
            return false;
        }
        return find(root, input, 0);

    }

    boolean find(Node curr, String input, int index) {
        if(curr == null) {
            return false;
        }
        if(index == input.length()) {
            return curr.isLast;
        }
        return find(curr.childs[input.charAt(index)-'a'], input, index+1);
    }

    public boolean startsWith(String prefix) {
        if(prefix == null) {
            return false;
        }
        return startsWith(root, prefix,0);
    }

    public boolean startsWith(Node curr, String prefix, int index) {
        if(curr == null) {
            return false;
        }
        if(index == prefix.length()) {
            return true;
        }
        return startsWith(curr.childs[prefix.charAt(index)-'a'],prefix, index+1);
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addString("banana");
        trie.addString("apple");
        trie.addString("mango");
        System.out.println(trie.find("apple"));
        System.out.println(trie.find("mang"));
        trie.remove("apple");
        System.out.println(trie.find("apple"));
        trie.addString("mang");
        System.out.println(trie.find("mang"));
        System.out.println(trie.find("mango"));
        System.out.println(trie.startsWith("banb"));
    }
}
