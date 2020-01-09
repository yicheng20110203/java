package com.ccjpp;

/**
 * 动态规划
 */
public class DynamicPrograming {
    private int[] wights;
    private int n;
    private int w;
    private boolean[][] states;

    public DynamicPrograming(int[] wights, int n, int w) {
        this.wights = wights;
        this.n = n;
        this.w = w;
        states = new boolean[this.n][this.w + 1];
    }

    public int getStates() {
        states[0][0] = true;
        if (wights[0] <= w) {
            states[0][wights[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            // 复制states[i - 1]的状态到第i行
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j]) {
                    states[i][j] = true;
                }
            }

            // 相加计算新的第i行状态
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j] && (j + wights[i] <= w)) {
                    states[i][j + wights[i]] = true;
                }
            }
        }

        for (int i = w; i >= 0; i--) {
            if (states[n - 1][i]) {
                return i;
            }
        }

        return 0;
    }
}
