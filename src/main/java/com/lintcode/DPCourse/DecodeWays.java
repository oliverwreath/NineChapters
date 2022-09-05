package com.lintcode.DPCourse;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Author: Oliver
 */
@Slf4j
public class DecodeWays {
  public static void main(String[] args) {
    DecodeWays decodeWays = new DecodeWays();
    log.debug("result 2 = " + decodeWays.numDecodings("12"));
    log.debug("result 1 = " + decodeWays.numDecodings("10"));
    log.debug("result 0 = " + decodeWays.numDecodings("19261001"));
    log.debug("result 0 = " + decodeWays.numDecodings("0"));
  }

  public int numDecodings(String s) {

    if (s == null || s.length() < 1) {
      return 0;
    }

    // initialization
    int n = s.length();
    char[] chars = s.toCharArray();
    int[] dp = new int[n];

    for (int i = 0; i < n; i++) {
      if (chars[i] > '0') {
        dp[i] += i - 1 >= 0 ? dp[i - 1] : 1;
      }
      if (i - 1 >= 0 && isValid(chars[i - 1], chars[i])) {
        dp[i] += i - 2 >= 0 ? dp[i - 2] : 1;
      }
    }

    log.debug(Arrays.toString(dp));
    return dp[n - 1];
  }

  private boolean isValid(int x, int y) {
    log.debug("x = " + x + " y = " + y);
    if (x != '1' && x != '2') {
      return false;
    }
    int number = (x - '0') * 10 + (y - '0');
    log.debug("number = " + number);
    return (number > 0 && number < 27);
  }
}
