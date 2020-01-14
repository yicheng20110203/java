package com.ccjpp;

public class BitMap {
    private static int charToBitNum = 16;
    public char[] bytes;
    public int nBites;

    public BitMap(int nBites) {
        this.nBites = nBites;
        this.bytes = new char[nBites / charToBitNum + 1];
    }

    public BitMap set(int k) {
        if (k > nBites) {
            return this;
        }

        int index = k / charToBitNum;
        int left = k % charToBitNum;
        bytes[index] |= (1 << left);

        return this;
    }

    public boolean get(int k) {
        if (k > nBites) {
            return false;
        }

        int index = k / charToBitNum;
        int left = k % charToBitNum;

        return (bytes[index] & (1 << left)) != 0;
    }
}
