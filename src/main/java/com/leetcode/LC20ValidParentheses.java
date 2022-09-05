package com.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Author: Oliver
 */
@Slf4j
public class LC20ValidParentheses {
  public boolean isValid(String s) {
    if (s == null || s.isEmpty()) return true;

    char[] chars = s.toCharArray();
    Deque<Character> stack = new ArrayDeque<>();
    for (char aChar : chars) {
      if (aChar == '(')
        stack.add(')');
      else if (aChar == '{')
        stack.add('}');
      else if (aChar == '[')
        stack.add(']');
      else if (stack.isEmpty() || stack.pollLast() != aChar)
        return false;
    }
    return stack.isEmpty();
  }
}
