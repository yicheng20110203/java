package com.ccjpp;

public class Tool {
    public static void printKvArray(int[] arr) {
        int n = arr.length;
        String t = "";
        if (n <= 9999) {
            t = "\t";
        } else if (n > 999999999) {
            t = "\t\t\t";
        } else {
            t = "\t\t";
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.println("[");
            }
            String str = "\t" + i + t + "=>" + t + arr[i];
            if (i != arr.length - 1) {
                str += ",";
            }
            System.out.println(str);
            if (i == arr.length - 1) {
                System.out.println("]");
            }
        }
    }
}
