package com.ATemplatesDataStructures.Stack;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

@Slf4j
public class Lintcode423ValidParentheses {
  public boolean isValidParentheses(String s) {
    // filter abnormal cases
    if (s == null || s.isEmpty()) {
      return true;
    }

    Deque<Character> stack = new ArrayDeque<>();
    int len = s.length();
    for (int i = 0; i < len; i++) {
      char c = s.charAt(i);
      if (isOpening(c)) {
        stack.push(c);
      } else if (isClosing(c)) {
        if (stack.isEmpty() || !isMatching(stack.peek(), c)) {
          return false;
        } else {
          stack.pop();
        }
      }
    }

    // return the final result
    return stack.isEmpty();
  }

  private boolean isMatching(Character opening, Character closing) {
    return (opening.equals('(') && closing.equals(')')) ||
            (opening.equals('{') && closing.equals('}')) ||
            (opening.equals('[') && closing.equals(']'));
  }

  boolean isOpening(Character c) {
    return c.equals('(') || c.equals('{') || c.equals('[');
  }

  boolean isClosing(Character c) {
    return c.equals(')') || c.equals('}') || c.equals(']');
  }
}
