package com.ccjpp.algorithm;

import java.util.LinkedList;
import java.util.Queue;


public class AcNode {
    private static final int MAX_LENGTH = 26;
    public char data;

    public AcNode[] children = new AcNode[MAX_LENGTH];
    public boolean isEndingChar = false;
    public int length = -1;
    public AcNode fail;

    public AcNode(char data) {
        this.data = data;
    }

    public void buildFailurePoint() {
        Queue<AcNode> queue = new LinkedList<>();
    }
}
