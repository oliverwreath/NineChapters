package com.NineChapters.TwoPointers.Reverse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidPalindrome_415 {

  public static void main(String[] args) {
    testValidPalindrome_415();
  }

  private static void testValidPalindrome_415() {
    log.info("result true v.s. {}", isPalindrome("A man, a plan, a canal: Panama"));
    log.info("result false v.s. {}", isPalindrome("race a car"));
  }

  public static boolean isPalindrome(String s) {
    // filter abnormal cases
    if (s == null || s.length() == 0) {
      return true;
    }

    int left = 0, right = s.length() - 1;
    while (left < right) {
      if (!isValid(s.charAt(left))) {
        left++;
        continue;
      }
      if (!isValid(s.charAt(right))) {
        right--;
        continue;
      }

      if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
        return false;
      } else {
        left++;
        right--;
        continue;
      }
    }

    // return the final result
    return true;
  }

  private static boolean isValid(char c) {
    return Character.isDigit(c) || Character.isLetter(c);
  }

}
