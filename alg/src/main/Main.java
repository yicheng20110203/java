package main;

import com.ccjpp.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        //testTrie();
        //testAc();
        //testDivideConquer();
        //testBacktracking();
        //testBacktrackingRegexp();
        //testDynamicProgramingV1();
        testDynamicProgramingV2();
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

    // 回溯 + 正则
    public static void testBacktrackingRegexp() {
        BacktrackingRegex regex = new BacktrackingRegex("hello world java", "*llo?world.jav*");
        regex.match();
        boolean isMatch = regex.getMatch();
        if (isMatch) {
            System.out.printf("regexp = '%s' matches '%s' true\n", regex.getRegex(), regex.getSource());
        } else {
            System.out.printf("regexp = '%s' matches '%s' false\n", regex.getRegex(), regex.getSource());
        }
    }

    public static void testDynamicProgramingV1() {
        DynamicPrograming dp = new DynamicPrograming(new int[]{2, 2, 4, 6, 3}, 5, 16);
        System.out.printf("max = %d", dp.getStateV2());
    }

    public static void testDynamicProgramingV2() {
        DynamicProgramingV2 v2 = new DynamicProgramingV2(new int[][]{
                {1, 3, 5, 9},
                {2, 1, 3, 4},
                {5, 2, 6, 7},
                {16, 8, 4, 3}
        }, 4, 4);
        System.out.printf("min dist = %d\n", v2.minDist());
        System.out.printf("min num = %d\n", v2.minMoneyNum(new int[]{1,5, 3}, 9));
    }
}
