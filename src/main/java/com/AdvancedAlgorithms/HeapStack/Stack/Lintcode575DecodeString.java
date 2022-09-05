package com.AdvancedAlgorithms.HeapStack.Stack;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Some say it's medium, I say it's tricky.
 */
@Slf4j
public class Lintcode575DecodeString {
  public String expressionExpand(String s) {
    // filter abnormal cases
    if (s == null || s.length() == 0) {
      return "";
    }

    Deque<Object> stack = new ArrayDeque<>();
    int number = 0;
    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        number = number * 10 + c - '0';
      } else if (c == '[') {
        stack.push(number);
        number = 0;
      } else if (c == ']') {
        String newString = popStack(stack);
        int count = (int) stack.pop();
        for (int t = 0; t < count; t++) {
          stack.push(newString);
        }
      } else {
        stack.push(String.valueOf(c));
      }
    }

    // return the final result
    return popStack(stack);
  }

  private String popStack(Deque<Object> stack) {
    Deque<String> buffer = new ArrayDeque<>();
    while (!stack.isEmpty() && (stack.peek() instanceof String)) {
      buffer.push((String) stack.pop());
    }

    StringBuilder stringBuilder = new StringBuilder();
    while (!buffer.isEmpty()) {
      stringBuilder.append(buffer.pop());
    }
    return stringBuilder.toString();
  }

}
