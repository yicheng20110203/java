package main;

import com.ccjpp.Ac;
import com.ccjpp.Backtracking;
import com.ccjpp.DivideConquer;
import com.ccjpp.Trie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        //testTrie();
        //testAc();
        //testDivideConquer();
        //testBacktracking();
    }

    // Trie树
    public static void testTrie() {
        Trie t = new Trie(new String[]{"hello", "world", "java", "case", "well"});
        t.multiInset();
        String[] patterns = new String[]{"word", "java", "well"};
        for (String pattern : patterns) {
            if (t.search(pattern)) {
                System.out.printf("Trie搜索结果: pattern = %s, result = %s\n", pattern, "true");
                continue;
            }
            System.out.printf("Trie搜索结果: pattern = %s, result = %s\n", pattern, "false");
        }
    }

    // Ac自动机
    public static void testAc() {
        Ac ac = new Ac(new String[]{"hello", "world", "java", "case", "well"});
        ac.buildAc();
        ArrayList<String> result = ac.search("helloworldjava");
        System.out.println(result);
    }

    // 分治
    public static void testDivideConquer() {
        DivideConquer dc = new DivideConquer(new int[]{2, 1, 3, 5, 4, 2, 7, 8, 6, 8});
        int num = dc.process().getNum();
        System.out.printf("total num = %d\n", num);
        System.out.println("pairs is :");
        ArrayList<ArrayList<Integer>> pairs = dc.getPairs();
        for (ArrayList<Integer> pair : pairs) {
            System.out.println(pair);
        }
    }

    // 回溯
    public static void testBacktracking() {
        Backtracking b = new Backtracking(8, 8);
        b.cal8queue(0);
    }
}
