package com.oliver.DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
public class WordBreak {
    public static void main(String[] args) {
        testWordBreak();
    }

    private static void testWordBreak() {
        HashSet<String> dict = new HashSet<String>() {{
            add("lint");
            add("code");
        }};
        System.out.println(wordBreak("lintcode", dict));
        System.out.println("- -");
    }

    public static boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() < 1) {
            return true;
        }
        if (dict == null || dict.size() < 1) {
            return false;
        }
        int maxLen = getMaxLen(dict);

        int len = s.length();
        boolean[] f = new boolean[len + 1];
        f[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = Math.max(0, i - maxLen); j < i; j++) {
                if (f[j]) {
//                    System.out.print("; " + i + ": " + j + " " + s.substring(j, i));
                    if (dict.contains(s.substring(j, i))) {
                        f[i] = true;
                        break;
                    }
                }
            }
//            System.out.println();
        }
//        System.out.println(Arrays.toString(f));
        return f[len];
    }

    private static int getMaxLen(Set<String> dict) {
        if (dict == null || dict.size() < 1) {
            return 0;
        }

        int maxLen = Integer.MIN_VALUE;
        for (String s : dict) {
            maxLen = Math.max(maxLen, s.length());
        }

        return maxLen;
    }
}
