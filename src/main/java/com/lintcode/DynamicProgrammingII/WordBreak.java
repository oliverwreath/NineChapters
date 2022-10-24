package com.lintcode.DynamicProgrammingII;

import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
@Slf4j
public class WordBreak {

  public static void main(String[] args) {
    testWordBreak();
  }

  private static void testWordBreak() {
    HashSet<String> dict = new HashSet<>();
    dict.add("lint");
    dict.add("code");
    log.debug(String.valueOf(wordBreak("lintcode", dict)));
    log.debug("- -");
  }

  public static boolean wordBreak(String s, Set<String> dict) {
    if (s == null || s.length() < 1) {
      return true;
    }
    if (dict == null || dict.isEmpty()) {
      return false;
    }

    int len = s.length();
    boolean[] f = new boolean[len + 1];
    f[0] = true;
    int maxLen = getMaxLen(dict);

    for (int i = 1; i <= len; i++) {
      for (int lastWordLength = 1; lastWordLength <= maxLen && lastWordLength <= i; lastWordLength++) {
        if (f[i - lastWordLength] && dict.contains(s.substring(i - lastWordLength, i))) {
          f[i] = true;
          break;
        }
      }
    }

    return f[len];
  }

  private static int getMaxLen(Set<String> dict) {
    if (dict == null || dict.isEmpty()) {
      return 0;
    }

    int maxLen = Integer.MIN_VALUE;
    for (String s : dict) {
      maxLen = Math.max(maxLen, s.length());
    }

    return maxLen;
  }
}
