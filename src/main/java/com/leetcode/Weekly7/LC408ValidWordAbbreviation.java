package com.leetcode.Weekly7;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC408ValidWordAbbreviation {
  public static void main(String[] arg) {
    testValidWordAbbreviation();
  }

  private static void testValidWordAbbreviation() {
    log.info("{}", validWordAbbreviation("a", "2"));
    log.info("{}", validWordAbbreviation("internationalization", "i12iz4n"));
    log.info("{}", validWordAbbreviation("apple", "a2e"));
    log.info("{}", validWordAbbreviation("hi", "1"));
    log.info("{}", validWordAbbreviation("abbreviation", "a10n"));
  }

  static boolean validWordAbbreviation(String word, String abr) {
    // fitler abnormal inputs
    if (word == null && abr == null) {
      return true;
    }
    if (word == null || abr == null) {
      return false;
    }

    // walk through
    int n = word.length();
    int m = abr.length();
    int i = 0;
    int j = 0;
    for (; j < m; j++) {
      if (i >= n) {
        return false;
      }
//            log.debug(i + " " + j + "; " + word.charAt(i) + " " + abr.charAt(j));
      char currentAbr = abr.charAt(j);
      if (Character.isDigit(currentAbr)) {
        if (currentAbr == '0') {
          return false;
        }
        int number = currentAbr - '0';
        while (j + 1 < m && Character.isDigit(abr.charAt(j + 1))) {
          number *= 10;
          number += abr.charAt(j + 1) - '0';
          j++;
        }
        i += number;
      } else {
        if (word.charAt(i) != currentAbr) {
          return false;
        }
        i++;
      }
    }
//        log.debug("i = " + i + "; j = " + j + "; n = " + n);
    if (i != n) {
      return false;
    }

    return true;
  }
}
