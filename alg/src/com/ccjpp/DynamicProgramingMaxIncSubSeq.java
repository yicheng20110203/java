package com.ccjpp;

public class DynamicProgramingMaxIncSubSeq {

    /**
     * 动态规划求最长递增子序列
     * @param arr int[]
     * @return int
     */
    public int getMaxIncSeqNum(int[] arr) {
        int n = arr.length;
        int[] states = new int[n];

        states[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    max = Math.max(states[j], max);
                }
            }
            states[i] = max + 1;
        }

        int max = 0;
        for (int i = n - 1; i >= 1; i--) {
            max = Math.max(states[i], max);
        }
        return max;
    }
}
