package com.ccjpp;

import com.ccjpp.algorithm.Trie;

public class Main {

    public static void main(String[] args) {
        testTrieNode();
    }

    public static void testTrieNode() {
        Trie t = new Trie();
        t.insert(new char[]{'h', 'e', 'l', 'l', 'o'});
        t.insert(new char[]{'j', 'a', 'v', 'a'});
        t.insert(new char[]{'h', 'o', 'w'});
        t.insert(new char[]{'o', 'l', 'd'});
        t.insert(new char[]{'a', 'r', 'e'});
        t.insert(new char[]{'y', 'o', 'u'});

        String[] ss = new String[]{"how", "old", "when"};
        for (int i = 0; i < ss.length; i++) {
            char[] s = ss[i].toCharArray();
            if (t.search(s)) {
                System.out.printf("search %s is true\n", ss[i]);
                continue;
            }
            System.out.printf("search %s is false\n", ss[i]);
        }
    }
}

