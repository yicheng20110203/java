package com.ccjpp;

public class TrieNode {
    public static final int MAX_SIZE = 26;
    public char data;
    public TrieNode[] children;
    public boolean isEndingChar = false;

    public TrieNode (char data) {
        this.data = data;
        this.children = new TrieNode[MAX_SIZE];
    }
}
