package com.AmazonSession.leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class ValidParentheses_20 {

  public static void main(String[] arg) {
    new ValidParentheses_20().testSearchA2DMatrix_74();
  }

  private void testSearchA2DMatrix_74() {
    String[] trueArray = new String[]{"()", "()[]{}"};
    for (String string : trueArray) {
      log.info("{} true = {}", string, isValid(string));
    }

    String[] falseArray = new String[]{"(", "{", "[", "(]", "([)]"};
    for (String string : falseArray) {
      log.info("{} false = {}", string, isValid(string));
    }
  }

  /**
   * @param s
   * @return
   */
  public boolean isValid(String s) {

    if (s == null || s.length() == 0) {
      return false;
    }

    //
    int n = s.length();
    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      char nowChar = s.charAt(i);
      if (nowChar == '(' || nowChar == '{' || nowChar == '[') {
        stack.push(nowChar);
      } else if (nowChar == ')') {
        if (stack.isEmpty() || stack.pop() != '(') {
          return false;
        }
      } else if (nowChar == '}') {
        if (stack.isEmpty() || stack.pop() != '{') {
          return false;
        }
      } else if (nowChar == ']') {
        if (stack.isEmpty() || stack.pop() != '[') {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }
}
