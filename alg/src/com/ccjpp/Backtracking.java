package com.ccjpp;

/**
 * 回溯
 */
public class Backtracking {
    private int rows;
    private int cols;

    private int[] result;

    public Backtracking(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.result = new int[rows];
    }

    public void cal8queue(int row) {
        if (row == this.rows) {
            this.print(result);
            return;
        }

        for (int col = 0; col < this.cols; col++) {
            if (this.isOk(row, col)) {
                result[row] = col;
                this.cal8queue(row + 1);
            }
        }
    }

    private boolean isOk(int row, int col) {
        int left = col - 1;
        int right = col + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (this.result[i] == col) {
                return false;
            }

            if (left >= 0) {
                if (this.result[i] == left) {
                    return false;
                }
            }

            if (right < this.cols) {
                if (this.result[i] == right) {
                    return false;
                }
            }

            left--;
            right++;
        }

        return true;
    }

    private void print(int[] result) {
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.cols; c++) {
                if (result[r] == c) {
                    System.out.print("Q ");
                    continue;
                }

                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
