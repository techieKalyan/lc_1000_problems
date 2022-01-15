package com.nelluri.tries;

/*
Interesting problem using Trie + Hash
https://www.udemy.com/course/cpp-data-structures-algorithms-levelup-prateek-narang/learn/lecture/23510300#overview
 */
import java.util.Set;
import java.util.HashSet;

public class CuteCatImpl {

    public void searchAndAddWords(Trie trie, String document, int startIndex, Set<String> wordsDictionary) {
        Trie.Node curr = trie.root;
        if(curr == null) {
            return;
        }
        String documentSuffix = document.substring(startIndex, document.length());
        for(int i=0; i < documentSuffix.length(); i++) {
            int currCharLocation = documentSuffix.charAt(i) - 'a';
            if (curr.childs[currCharLocation] != null) {
                curr = curr.childs[currCharLocation];
                if (curr.isLast) {
                    wordsDictionary.add(documentSuffix.substring(0, i + 1));
                    continue;
                }
            } else {
                return;
            }
        }
    }

    public Set<String> search(Trie trie, String document) {
        int length = document.length();
        Set<String> matchedWords = new HashSet<>();
        for(int i=0; i< document.length(); i++) {
            searchAndAddWords(trie, document, i, matchedWords);
        }
        return matchedWords;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        String document = "cutelittlecatisamazing";
        String[] words = new String[]{"cute", "ttle","cat","quick", "big"};

        for(String word: words) {
            trie.addString(word);
        }

        CuteCatImpl cuteCat = new CuteCatImpl();
        Set<String> result = cuteCat.search(trie, document);

        for(String word: result) {
            System.out.println(word);
        }
    }

}
