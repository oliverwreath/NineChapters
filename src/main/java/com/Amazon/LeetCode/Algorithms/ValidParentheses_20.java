package com.Amazon.LeetCode.Algorithms;

import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-19.
 */
public class ValidParentheses_20 {
    private static final Logger logger = LoggerFactory.getLogger(ValidParentheses_20.class);

    public static void main(String[] arg) {
        new ValidParentheses_20().testSearchA2DMatrix_74();
    }

    private void testSearchA2DMatrix_74() {
        String[] trueArray = new String[]{"()", "()[]{}"};
        for (String string : trueArray) {
            logger.info("{} true = {}", string, isValid(string));
        }

        String[] falseArray = new String[]{"(", "{", "[", "(]", "([)]"};
        for (String string : falseArray) {
            logger.info("{} false = {}", string, isValid(string));
        }
    }

    /**
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        // write your code here
        // handle extreme cases
        if (s == null || s.length() == 0) {
            return false;
        }

        //
        int n = s.length();
        Stack<Character> stack = new Stack<Character>();
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
