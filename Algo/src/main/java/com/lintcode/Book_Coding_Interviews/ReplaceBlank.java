package com.lintcode.Book_Coding_Interviews;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class ReplaceBlank {

  public static void main(String[] arg) {
    testReplaceBlank();
  }

  private static void testReplaceBlank() {
    char[] a = new char[19];
    int i = 0;
    a[i++] = 'M';
    a[i++] = 'r';
    a[i++] = ' ';
    a[i++] = 'J';
    a[i++] = 'o';
    a[i++] = 'h';
    a[i++] = 'n';
    a[i++] = ' ';
    a[i++] = 'S';
    a[i++] = 'm';
    a[i++] = 'i';
    a[i++] = 't';
    a[i++] = 'h';
    log.info("{}", print(a, 13));
    log.info("{}", replaceBlank(a, 13));
    log.info("{}", print(a, 17));
  }

  static String print(char[] string, int length) {
    String s = new String(string);
    return s;
  }

  static int replaceBlank(char[] string, int length) {
    if (string == null || string.length == 0) {
      return 0;
    }

    int blankCounter = 0;
    for (int i = 0; i < length; i++) {
      if (string[i] == ' ') {
        blankCounter++;
      }
    }

    int resultLength = length + 2 * blankCounter;
    int end = length - 1;
    for (int i = resultLength - 1; i >= 0; i--) {
      if (string[end] == ' ') {
        string[i--] = '0';
        string[i--] = '2';
        string[i] = '%';
      } else {
        string[i] = string[end];
      }
      end--;
    }

    return resultLength;
  }
}
