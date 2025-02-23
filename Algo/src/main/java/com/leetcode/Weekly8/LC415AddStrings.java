package com.leetcode.Weekly8;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC415AddStrings {

  public static void main(String[] arg) {
    new LC415AddStrings().testLongestPalindrome_409();
  }

  private void testLongestPalindrome_409() {
    log.info("1 = {}", addStrings("0", "1"));
    log.info("18 = {}", addStrings("9", "9"));
    log.info("20 = {}", addStrings("19", "1"));
    log.info("118 = {}", addStrings("19", "99"));
    log.info("1198 = {}", addStrings("199", "999"));
    log.info("107 = {}", addStrings("98", "9"));
  }

  public String addStrings(String num1, String num2) {
    // handle extreme inputs
    if (num1 == null || num1.length() == 0) {
      return num2;
    }
    if (num2 == null || num2.length() == 0) {
      return num1;
    }

    // normal process, with carry, num1 must be equal or larger
    if (num1.length() < num2.length()) {
      String tmp = num1;
      num1 = num2;
      num2 = tmp;
    }
    int n = num1.length();
    int m = num2.length();
    StringBuilder stringBuilder = new StringBuilder();
    int carry = 0;
    for (int i = n - 1, j = m - 1; j >= 0; i--, j--) {
      int currentDigit = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + carry;
//            log.debug("currentDigit = " + currentDigit);
      if (currentDigit > 9) {
        carry = 1;
        currentDigit -= 10;
      } else {
        carry = 0;
      }
//            log.debug("currentDigit = " + currentDigit + "; carry = " + carry);
      stringBuilder.append(currentDigit);
    }
//        log.debug(stringBuilder.toString());
    for (int i = n - m - 1; i >= 0; i--) {
//            log.debug("Souldn't enter!");
      if (carry == 0) {
        stringBuilder.append(num1.charAt(i));
      } else {
        int currentDigit = (num1.charAt(i) - '0') + carry;
        if (currentDigit > 9) {
          carry = 1;
          currentDigit -= 10;
        } else {
          carry = 0;
        }
        stringBuilder.append(currentDigit);
      }
    }
    if (carry == 1) {
//            log.debug("Sould add one!");
      stringBuilder.append('1');
//            log.debug(stringBuilder.toString());
    }

    // return the answer
    return stringBuilder.reverse().toString();
  }
}
