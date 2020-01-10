package com.ccjpp;

import java.util.Arrays;

/**
 * 动态规划
 * w[n][w] 从w[0][0]走到w[n-1][w-1]需要的最小步骤
 * <p>
 * min_dist(i, j) = w[i][j] + min(min_dist(i-1, j), min_dis(i, j-1))
 */
public class DynamicProgramingV2 {
    public int[][] arr;
    public int rows;
    public int cols;
    public int[][] states;

    public DynamicProgramingV2(int[][] arr, int rows, int cols) {
        this.arr = arr;
        this.rows = rows;
        this.cols = cols;
        states = new int[rows][cols];
    }

    public int minDist() {
        states[0][0] = arr[0][0];
        for (int i = 1; i < cols; i++) {
            states[0][i] = states[0][i - 1] + arr[0][i];
        }

        for (int i = 1; i < rows; i++) {
            states[i][0] = states[i - 1][0] + arr[i][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                states[i][j] = Math.min(states[i - 1][j] + arr[i][j], states[i][j - 1] + arr[i][j]);
            }
        }

        return states[rows - 1][cols - 1];
    }

    /**
     * 一个人民币面值数组 money = [1, 3, 5],  求总金额为 target = 9 的最少纸币张数
     *
     * @param money  int[]
     * @param target int
     * @return int
     */
    public int minMoneyNum(int[] money, int target) {
        int ini = 0;
        int n = money.length;
        int[] states = new int[target + 1];

        for (int i = 0; i <= target; i++) {
            states[i] = ini;
        }

        for (int value : money) {
            if (value <= target) {
                states[value] = 1;
            }
        }

        for (int t = 1; t <= target; t++) {
            if (states[t] > ini) {
                for (int m : money) {
                    if (t + m <= target) {
                        if (states[t + m] == ini || states[t + m] > states[t] + 1) {
                            states[t + m] = states[t] + 1;
                        }
                    }
                }
            }
        }

        Tool.printKvArray(states);

        return states[target];
    }
}
