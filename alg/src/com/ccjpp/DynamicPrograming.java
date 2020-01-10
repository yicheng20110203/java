package com.ccjpp;

/**
 * 动态规划
 */
public class DynamicPrograming {
    private int[] wights;
    private int n;
    private int w;

    public DynamicPrograming(int[] wights, int n, int w) {
        this.wights = wights;
        this.n = n;
        this.w = w;
    }

    public int getStates() {
        boolean[][] states = new boolean[n][w + 1];
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

    public int getStateV2() {
        boolean[] states = new boolean[w + 1];
        states[0] = true;
        if (wights[0] <= w) {
            states[wights[0]] = true;
        }

        for (int i = 1; i < n; i++) {
// 从小到大会重复计算
//            for (int j = 0; j <= w - wights[i]; j++) {
//                if (states[j]) {
//                    states[j + wights[i]] = true;
//                }
//            }

            for (int j = w - wights[i]; j >= 0; --j) {
                if (states[j]) {
                    states[j + wights[i]] = true;
                }
            }
        }

        for (int i = 0; i < states.length; i++) {
            System.out.printf("i = %d, v = %b\n", i, states[i]);
        }
        for (int i = w; i >= 0; i--) {
            if (states[i]) {
                return i;
            }
        }

        return 0;
    }
}
