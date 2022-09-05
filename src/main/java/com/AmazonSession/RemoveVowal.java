package com.AmazonSession;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;

/**
 * Author: Oliver
 */
@Slf4j
public class RemoveVowal {
  public static void main(String[] arg) {
    new RemoveVowal().testGrayCode_89();
  }

  private void testGrayCode_89() {
//        log.info("{}", binaryString2Int("00"));
//        log.info("{}", binaryString2Int("01"));
//        log.info("{}", binaryString2Int("11"));
//        log.info("{}", binaryString2Int("10"));
//
//        log.info("{}", binaryString2Int("000"));
//        log.info("{}", binaryString2Int("001"));
//        log.info("{}", binaryString2Int("011"));
//        log.info("{}", binaryString2Int("010"));
//
//        log.info("{}", binaryString2Int("110"));
//        log.info("{}", binaryString2Int("111"));
//        log.info("{}", binaryString2Int("101"));
//        log.info("{}", binaryString2Int("100"));
//
//        for (int i = -1; i < 6; i++) {
//
//        }
    String string = "abdhfgebsa";
    log.info("removeVowal({}) = {}", string, removeVowal(string));

  }

  private static String v = "aeiouAEIOU";
  private static HashSet<Character> set = new HashSet<Character>();

  static {
    int n = v.length();
    for (int i = 0; i < n; i++) {
      set.add(v.charAt(i));
    }
  }

  /**
   * @param string
   * @return
   */
  public String removeVowal(String string) {

    if (string == null || string.length() == 0) {
      return string;
    }

    // fill the ans
    StringBuilder stringBuilder = new StringBuilder();
    int n = string.length();
    for (int i = 0; i < n; i++) {
      if (!set.contains(string.charAt(i))) {
        stringBuilder.append(string.charAt(i));
      }
    }

    return stringBuilder.toString();
  }
}
