package main;

import com.ccjpp.Trie;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        testTrie();
    }

    public static void testTrie()
    {
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
}
