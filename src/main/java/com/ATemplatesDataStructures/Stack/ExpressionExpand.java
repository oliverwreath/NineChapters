package com.ATemplatesDataStructures.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExpressionExpand {

  public static void main(String[] args) {
    testExpressionExpand();
  }

  private static void testExpressionExpand() {
    ExpressionExpand ExpressionExpand = new ExpressionExpand();
    log.info("result dabbbcabbbc v.s. " + ExpressionExpand.expressionExpand("d2[a3[b]c]"));
    log.info("result abcaaa v.s. " + ExpressionExpand.expressionExpand("abc3[a]"));
  }

  /*
   * @param s: an expression includes numbers, letters and brackets
   * @return: a string
   */
  public String expressionExpand(String s) {

    if (s == null || s.length() < 2) {
      return s;
    }

    Deque<StringBuilder> stack = new ArrayDeque<>();
    Deque<Integer> factorStack = new ArrayDeque<>();
    stack.add(new StringBuilder());
    factorStack.add(1);
    int number = 0;
    for (char c : s.toCharArray()) {
      if (c == '[') {
        factorStack.add(number);
        number = 0;
        stack.add(new StringBuilder());
      } else if (c == ']') {
        StringBuilder tmp = stack.pop();
        int factor = factorStack.pop();
        for (int i = 0; i < factor; i++) {
          stack.peek().append(tmp);
        }
      } else if (Character.isDigit(c)) {
        number = number * 10 + c - '0';
      } else {
        stack.peek().append(c);
      }
    }

    return stack.peek().toString();
  }

}
