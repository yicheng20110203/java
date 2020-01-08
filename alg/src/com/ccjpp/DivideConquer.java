package com.ccjpp;

import java.util.ArrayList;

/**
 * 分治
 * 求一个数组的逆序度
 */
public class DivideConquer {
    private int[] arr;
    private int num = 0;
    private ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();

    public DivideConquer(int[] arr) {
        this.arr = arr;
    }

    public int getNum() {
        return this.num;
    }

    public ArrayList<ArrayList<Integer>> getPairs() {
        return this.pairs;
    }

    public DivideConquer process() {
        try {
            this.doDivideConquer(this.arr, 0, this.arr.length - 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return this;
    }

    public void doDivideConquer(int[] arr, int p, int q) throws Exception {
        if (p >= q) return;
        int m = (p + q) / 2;
        try {
            this.doDivideConquer(arr, p, m);
            this.doDivideConquer(arr, m + 1, q);
            this.mergeDivideConquer(arr, p, m, q);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void mergeDivideConquer(int[] arr, int p, int m, int q) {
        int i = p;
        int j = m + 1;
        int[] tmp = new int[q - p + 1];
        int k = 0;

        while (i <= m && j <= q) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                // append pairs
                for (int index = i; index <= m; index++) {
                    ArrayList<Integer> ins = new ArrayList<>();
                    ins.add(arr[index]);
                    ins.add(arr[j]);
                    this.pairs.add(ins);
                }

                this.num += m - i + 1; //p - i之间的已经拍好序了，而且i - m之间都大于等于当前i位置应的值
                tmp[k++] = arr[j++];
            }
        }

        while (i <= m) {
            tmp[k++] = arr[i++];
        }

        while (j <= q) {
            tmp[k++] = arr[j++];
        }

        for (i = 0; i <= p - q; i++) {
            arr[p + i] = tmp[i];
        }

        this.print(arr);
    }

    private void print(int[] arr) {
        StringBuilder builder = new StringBuilder("[");
        for (int i : arr) {
            String s = i + ",";
            builder.append(s);
        }
        System.out.println(builder);
    }
}
