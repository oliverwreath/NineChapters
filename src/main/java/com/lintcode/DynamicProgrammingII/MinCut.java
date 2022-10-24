package com.lintcode.DynamicProgrammingII;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
@Slf4j
public class MinCut {

  public static void main(String[] args) {
    testPalindrome();
    testMinCut();
  }

  private static void testMinCut() {
    log.debug("{}", minCut("aab"));
    log.debug("- -");
    log.debug("{}", minCut("bb"));
    log.debug("- -");
    log.debug("{}", minCut("aabb"));
    log.debug("- -");
    log.debug("{}", minCut("aabbaa"));
    log.debug("- -");
    log.debug("{}", minCut("aaccb"));
    log.debug("- -");
  }

  private static void testPalindrome() {
    log.debug("{}", palindrome("aa"));
    log.debug("- -");
    log.debug("{}", palindrome("bb"));
    log.debug("- -");
    log.debug("{}", palindrome("aabb"));
    log.debug("- -");
    log.debug("{}", palindrome("aabbaa"));
    log.debug("- -");
    log.debug("{}", palindrome("aaccb"));
    log.debug("- -");
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

//        log.debug(s + " " + Arrays.toString(f));

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
