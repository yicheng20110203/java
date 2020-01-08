package com.ccjpp;

public class AcNode {
    public static final int MAX_CHAR_NUM = 26;
    public char data;
    public boolean isEndingChar = false;
    public int length = -1;
    public AcNode[] children;
    public AcNode fail;

    public AcNode(char data) {
        this.data = data;
        this.children = new AcNode[MAX_CHAR_NUM];
    }
}
