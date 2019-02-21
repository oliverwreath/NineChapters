package com.LeetCode.SmarkingAlgorithmContest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-22.
 */
public class FindAllAnagramsInAString_438 {
    private static final Logger logger = LoggerFactory.getLogger(FindAllAnagramsInAString_438.class);

    public static void main(String[] arg) {
        new FindAllAnagramsInAString_438().testFindAllAnagramsInAString_438();
    }

    private void testFindAllAnagramsInAString_438() {
        logger.info("[0, 6] = {}", findAnagrams("cbaebabacd", "abc"));
        logger.info("[0, 1, 2] = {}", findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        // write your code here
        // handle extreme cases
        LinkedList<Integer> ans = new LinkedList<>();
        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return ans;
        }

        int pn = p.length();
        int[] targetCode = getCode(p);
        HashSet<int[]> ints = new HashSet<>();

        // first
        int n = s.length();
        int[] dynamicCode = new int[27];
        for (int i = 0; i < pn; i++) {
            dynamicCode[s.charAt(i) - 'a']++;
        }
        if (same(dynamicCode, targetCode)) {
            ans.add(0);
        }
        myLogger.info("first targetCode = " + Arrays.toString(targetCode));
        myLogger.info("first dynamicCode = " + Arrays.toString(dynamicCode));

        // rest
        for (int i = pn; i < n; i++) {
            dynamicCode[s.charAt(i) - 'a']++;
            dynamicCode[s.charAt(i - pn) - 'a']--;
            if (same(dynamicCode, targetCode)) {
                ans.add(i - pn + 1);
            }
        }
        myLogger.info("rest dynamicCode = " + Arrays.toString(dynamicCode));

        return ans;
    }

    private boolean same(int[] dynamicCode, int[] targetCode) {
        if (dynamicCode.length == targetCode.length) {
            for (int i = 0; i < dynamicCode.length; i++) {
                if (dynamicCode[i] != targetCode[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private int[] getCode(String string) {
        int[] code = new int[27];
        int n = string.length();
        for (int i = 0; i < n; i++) {
            code[string.charAt(i) - 'a']++;
        }
        return code;
    }

    private MyTmpLogger myLogger = new MyTmpLogger();

    private class MyTmpLogger {
        public MyTmpLogger() {
        }

        public void info(Object o) {
            if (isLogging) {
                System.out.println(o);
            }
        }
    }

    public static boolean isLogging = false;

    static {
        isLogging = true;
    }
}
