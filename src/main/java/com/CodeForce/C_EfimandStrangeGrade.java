package com.CodeForce;

import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class C_EfimandStrangeGrade {

  public static void main(String[] arg) {

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int t = scan.nextInt();
    String num = scan.next();
    if (t < 1) {
      log.debug(num);
      return;
    }
    char[] chars = num.toCharArray();

    boolean passedDot = false;
    int fiveIndex = -1;
    int lastAdvancedIndex = -1;
    for (int i = 0; i < n; i++) {
      if (!passedDot) {
        if (chars[i] == '.') {
          passedDot = true;
        }
      } else {
        if (chars[i] >= '5') {
          fiveIndex = i;
          lastAdvancedIndex = i;
          chars[i] = '0';
          t--;
          break;
        }
      }
    }

    if (fiveIndex == -1) {
      log.debug(num);
      return;
    }

    boolean advance1 = true;
    for (int i = fiveIndex - 1; i >= 0; i--) {
      if (chars[i] == '.') {
        t = -1;
        continue;
      }
      if (advance1) {
        if (chars[i] == '9') {
          chars[i] = '0';
          advance1 = true;
        } else {
          if (chars[i] >= '4' && t-- > 0) {
            chars[i] = '0';
            lastAdvancedIndex = i;
            advance1 = true;
          } else {
            chars[i] += 1;
            advance1 = false;
          }
        }
      }
    }

    if (advance1) {
      System.out.print('1');
    }
    for (int i = lastAdvancedIndex; i >= 0; i--) {
      if (chars[i] != '0') {
        if (chars[i] == '.') {
          for (int j = 0; j < i; j++) {
            System.out.print(chars[j]);
          }
        } else {
          for (int j = 0; j <= i; j++) {
            System.out.print(chars[j]);
          }
        }
        break;
      }
    }
    log.debug("");
    return;
  }
}
