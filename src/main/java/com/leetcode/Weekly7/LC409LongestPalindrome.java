package com.leetcode.Weekly7;

import java.util.HashMap;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC409LongestPalindrome {

  public static void main(String[] arg) {
    testLongestPalindrome_409();
  }

  private static void testLongestPalindrome_409() {
    log.info("{}", longestPalindrome(""));
    log.info("{}", longestPalindrome("abccccdd"));
    log.info("{}", longestPalindrome("abc"));
  }

  static int longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    if (s.length() == 1) {
      return 1;
    }

    // map
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      if (map.containsKey(s.charAt(i))) {
        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
      } else {
        map.put(s.charAt(i), 1);
      }
    }

    Set<Character> keys = map.keySet();
    boolean hasOdd = false;
    long answer = 0;
    for (Character key : keys) {
      int number = map.get(key);
      if (number % 2 == 1) {
        hasOdd = true;
      }
      answer += number / 2;
    }

    return (int) answer * 2 + (hasOdd ? 1 : 0);
  }
}
