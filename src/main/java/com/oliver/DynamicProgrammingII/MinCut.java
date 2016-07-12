package com.oliver.DynamicProgrammingII;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
public class MinCut {
    public static void main(String[] args) {
        testPalindrome();
        testMinCut();
    }

    private static void testMinCut() {
        System.out.println(minCut("aab"));
        System.out.println("- -");
        System.out.println(minCut("bb"));
        System.out.println("- -");
        System.out.println(minCut("aabb"));
        System.out.println("- -");
        System.out.println(minCut("aabbaa"));
        System.out.println("- -");
        System.out.println(minCut("aaccb"));
        System.out.println("- -");
    }

    private static void testPalindrome() {
        System.out.println(palindrome("aa"));
        System.out.println("- -");
        System.out.println(palindrome("bb"));
        System.out.println("- -");
        System.out.println(palindrome("aabb"));
        System.out.println("- -");
        System.out.println(palindrome("aabbaa"));
        System.out.println("- -");
        System.out.println(palindrome("aaccb"));
        System.out.println("- -");
    }

    public static int minCut(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int len = s.length();
        int[] f = new int[len + 1];
        for (int i = 0; i <= len; i++) {
            f[i] = i;
        }

        for (int i = 1; i <= len; i++) {
            for (int lastWordLength = 1; lastWordLength <= i; lastWordLength++) {
                if (palindrome(s.substring(i - lastWordLength, i))) {
                    f[i] = Math.min(f[i], f[i - lastWordLength] + 1);
                }
            }
        }

//        System.out.println(s + " " + Arrays.toString(f));

        return f[len] - 1;
    }

    public static boolean palindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }

        int len = s.length();
        for (int start = 0, end = len - 1; start < end; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }

        return true;
    }
}
