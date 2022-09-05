package com.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC125ValidPalindrome {
  public boolean isPalindrome(String s) {
    if (s == null || s.isEmpty()) return true;

    int left = 0, right = s.length() - 1;
    char[] chars = s.toCharArray();
    while (left < right) {
      if (!Character.isLetterOrDigit(chars[left]))
        left++;
      else if (!Character.isLetterOrDigit(chars[right]))
        right--;
      else if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right]))
        return false;
      else {
        left++;
        right--;
      }
    }
    return true;
  }
}
