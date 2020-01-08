package com.ccjpp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Ac自动机
 */
public class Ac {
    AcNode root = new AcNode('/');
    public String[] filters;

    public Ac(String[] filters) {
        this.filters = filters;
        this.buildTrie();
    }

    /**
     * 根据多个过滤词，逐一构建trie树
     */
    private void buildTrie() {
        for (String filter : filters) {
            this.insertTrie(filter);
        }
    }

    /**
     * 构建trie树
     * @param s String
     */
    public void insertTrie(String s) {
        if (s == null) {
            return;
        }

        char[] cs = s.toCharArray();
        AcNode p = this.root;
        for (char c : cs) {
            int index = c - 'a';
            if (p.children[index] == null) {
                p.children[index] = new AcNode(c);
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
        p.length = cs.length;
    }

    /**
     * 构造Ac自动机fail指针
     */
    public void buildAc () {
        this.root.fail = null;
        Queue<AcNode> queue = new LinkedList<>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            AcNode p = queue.remove();
            for (int i = 0; i < AcNode.MAX_CHAR_NUM; i++) {
                AcNode pc = p.children[i];
                if (pc == null) {
                    continue;
                }

                if (p == root) {
                    pc.fail = root;
                    continue;
                }

                AcNode q = p.fail;
                while (q != null) {
                    AcNode qc = q.children[pc.data - 'a'];
                    if (qc != null) {
                        q.fail = qc;
                        break;
                    }

                    q = q.fail;
                }
                if (q == null) {
                    pc.fail = root;
                }

                queue.add(pc);
            }
        }
    }

    /**
     * AC自动机多字符串匹配搜索
     * @param s String
     * @return ArrayList<String>
     */
    public ArrayList<String> search(String s) {
        ArrayList<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        char[] cs = s.toCharArray();
        AcNode p = this.root;
        for (int i = 0; i < cs.length; i++) {
            int index = cs[i] - 'a';
            if (p != null && p.children[index] == null && p != this.root) {
                p = p.fail;
            }

            if (p == null) {
                p = this.root;
            }

            p = p.children[index];
            AcNode t = p;
            while (t != root && t != null) {
                if (t.isEndingChar) {
                    int pos = i - t.length + 1;
                    result.add(s.substring(pos, pos + t.length));
                }
                t = t.fail;
            }
        }

        return result;
    }
}
