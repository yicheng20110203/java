package com.ccjpp.algorithm;

/**
 * 基树数据结构
 */
public class TrieNode {
    public static final int MAX_SIZE = 26;
    public char data;
    public TrieNode[] children = new TrieNode[MAX_SIZE];

    // 标记一个基树节点是否是完整的期望值
    public boolean isEndingChar = false;

    public TrieNode(char data) {
        this.data = data;
    }
}
