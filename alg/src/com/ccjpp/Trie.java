package com.ccjpp;

public class Trie {
    private String[] sources;
    private TrieNode root = new TrieNode('/');

    public Trie (String[] sources) {
        this.sources = sources;
    }

    public void multiInset() {
        for (String s : this.sources) {
            this.insert(s);
        }
    }

    public void insert(String s) {
        if (s == null) {
            return;
        }

        TrieNode p = this.root;
        char[] cs = s.toCharArray();
        for (char c : cs) {
            int index = c - 'a';
            if (p.children[index] == null) {
                p.children[index] = new TrieNode(c);
            }
            p = p.children[index];
        }

        p.isEndingChar = true;
    }

    public boolean search(String pattern) {
        TrieNode p = this.root;
        char[] cs = pattern.toCharArray();
        for (char c : cs) {
            int index = c - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }

        return p.isEndingChar;
    }
}
