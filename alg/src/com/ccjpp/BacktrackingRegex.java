package com.ccjpp;

/**
 * 回溯
 * 求解正则表达式是否匹配
 * 1. "." 匹配任意一个
 * 2. "*" 匹配0个或者多个
 * 3. "?" 匹配0个或者一个
 */
public class BacktrackingRegex {
    private char[] source;
    private int sourceLen;
    private char[] regex;
    private int regexLen;

    private boolean isMatched = false;

    public BacktrackingRegex(String source, String regex) {
        this.source = source.toCharArray();
        this.regex = regex.toCharArray();
        this.sourceLen = this.source.length;
        this.regexLen = this.regex.length;
    }

    public String getSource() {
        StringBuilder builder = new StringBuilder();
        for (char c : this.source) {
            builder.append(c);
        }
        return builder.toString();
    }

    public String getRegex() {
        StringBuilder builder = new StringBuilder();
        for (char c : this.regex) {
            builder.append(c);
        }
        return builder.toString();
    }

    public boolean getMatch() {
        return this.isMatched;
    }

    public void match() {
        this.recursiveMatch(0, 0);
    }

    private void recursiveMatch(int sourceIndex, int regexIndex) {
        if (this.isMatched) {
            return;
        }

        if (sourceIndex > this.sourceLen || regexIndex > this.regexLen) {
            return;
        }

        if (sourceIndex == this.sourceLen) {
            if (regexIndex == this.regexLen) {
                this.isMatched = true;
                return;
            }
            return;
        }

        if (regexIndex == this.regexLen) {
            return;
        }

        char c = this.regex[regexIndex];
        if (c == '.') {
            this.recursiveMatch(sourceIndex + 1, regexIndex + 1);
        } else if (c == '*') {
            for (int k = 0 ; k <= this.regexLen - regexIndex; k++) {
                this.recursiveMatch(sourceIndex + k, regexIndex + 1);
            }
        } else if (c == '?') {
            this.recursiveMatch(sourceIndex, regexIndex + 1);
            this.recursiveMatch(sourceIndex + 1, regexIndex + 1);
        } else if (this.source[sourceIndex] == this.regex[regexIndex]) {
            this.recursiveMatch(sourceIndex + 1, regexIndex + 1);
        }
    }
}
