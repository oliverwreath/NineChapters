package com.HackerRank.AnalyzeTest;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Author: Oliver
 */
@Slf4j
public class AsteriskExpressions {
  private static BigInteger modder = new BigInteger("1000000007");
  private static long modderLong = 1000000007;

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    // first line
    int t = scan.nextInt();

    //
    for (int i = 0; i < t; i++) {
      String string = scan.next();
      if (invalid(string)) {
        log.debug("Syntax Error");
      } else {
//                log.debug(string);
        string = string.replaceAll("\\*\\*", "P");
//                log.debug(string);
        String[] numbers = string.split("\\*");
//                log.debug(Arrays.toString(numbers));
        long value = getValue(numbers);
        if (Long.MIN_VALUE == value) {
          log.debug("Syntax Error");
        } else {
          value %= modderLong;
          log.debug("{}", value);
        }
      }
    }
  }

  static long getValue(String[] numbers) {
    BigInteger ret = BigInteger.ONE;
    if (numbers == null || numbers.length == 0) {
      return ret.longValue();
    }

    for (String number : numbers) {
      if (number.contains("P")) {
        String[] nums = number.split("P");
        for (String num : nums) {
          if (num.startsWith("0")) {
            return Long.MIN_VALUE;
          }
        }
        BigInteger base = new BigInteger(nums[0]);
        for (int i = 1; i < nums.length; i++) {
          base = base.modPow(new BigInteger(nums[i]), modder);
        }
        ret = ret.multiply(base);
        ret = ret.mod(modder);
      } else {
        if (number.startsWith("0")) return Long.MIN_VALUE;
        ret = ret.multiply(new BigInteger(number));
        ret = ret.mod(modder);
      }
    }

    return ret.longValue();
  }

  static boolean invalid(String string) {
    if (string.startsWith("*") || string.startsWith("0") || string.endsWith("*") || string.contains("***")) {
      return true;
    }
    if (maxStarCount(string) > 2) {
      return true;
    }
    return false;
  }

  static int maxStarCount(String string) {
    int max = 0;
    int counter = 0;
    int len = string.length();
    for (int i = 0; i < len; i++) {
      if (Character.isDigit(string.charAt(i))) {
        counter = 0;
      } else {
        counter++;
        max = Math.max(max, counter);
      }
    }

    return max;
  }
}
