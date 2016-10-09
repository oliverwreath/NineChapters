package com.LeetCode.Weekly8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-01.
 */
public class AddStrings_415 {
    private final static Logger logger = LoggerFactory.getLogger(AddStrings_415.class);

    public static void main(String[] arg) {
        new AddStrings_415().testLongestPalindrome_409();
    }

    private void testLongestPalindrome_409() {
        logger.info("1 = {}", addStrings("0", "1"));
        logger.info("18 = {}", addStrings("9", "9"));
        logger.info("20 = {}", addStrings("19", "1"));
        logger.info("118 = {}", addStrings("19", "99"));
        logger.info("1198 = {}", addStrings("199", "999"));
        logger.info("107 = {}", addStrings("98", "9"));
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
//            System.out.println("currentDigit = " + currentDigit);
            if (currentDigit > 9) {
                carry = 1;
                currentDigit -= 10;
            } else {
                carry = 0;
            }
//            System.out.println("currentDigit = " + currentDigit + "; carry = " + carry);
            stringBuilder.append(currentDigit);
        }
//        System.out.println(stringBuilder.toString());
        for (int i = n - m - 1; i >= 0; i--) {
//            System.out.println("Souldn't enter!");
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
//            System.out.println("Sould add one!");
            stringBuilder.append('1');
//            System.out.println(stringBuilder.toString());
        }

        // return the answer
        return stringBuilder.reverse().toString();
    }
}
