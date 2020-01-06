package com.ccjpp.algorithm;

/**
 * 基树添加/查找
 */
public class Trie {
    private TrieNode _root = new TrieNode('/');

    public void insert(char[] seq) {
        if (seq == null) {
            return;
        }

        TrieNode p = _root;
        for (char c : seq) {
            int index = c - 'a';
            if (p.children[index] == null) {
                p.children[index] = new TrieNode(c);
            }
            p = p.children[index];
        }

        // 标记一个完整的字符串写入trie树完毕
        p.isEndingChar = true;
    }

    /**
     * 过滤前缀, 如果是前缀则值返回false
     * @param pattern character[]
     * @return boolean
     */
    public boolean search(char[] pattern) {
        if (pattern.length > TrieNode.MAX_SIZE) {
            return false;
        }

        TrieNode p = _root;
        for (char c : pattern) {
            int index = c - 'a';
            if (p.children[index] == null) {
                return false;
            }

            p = p.children[index];
        }

        // 如果这个前缀是之前录入的过滤词，则说明
        return p.isEndingChar;
    }
}
