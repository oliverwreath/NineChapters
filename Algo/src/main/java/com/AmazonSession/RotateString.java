package com.AmazonSession;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class RotateString {

  public static void main(String[] arg) {
    new RotateString().testRotateString();
  }

  private void testRotateString() {
    log.info("{}", isRotation("abc", "abc"));
    log.info("{}", isRotation("abc", "cab"));
    log.info("{}", isRotation("abc", "bca"));
    log.info("{}", isRotation("ab", "aa"));
  }

  public static boolean isRotation(String s1, String s2) {

    if (s1 == null || s1.length() == 0) {
      if (s2 == null || s2.length() == 0) {
        return true;
      } else {
        return false;
      }
    }

    int len = s1.length();
    log.info("len = " + len);
    for (int offset = 1; offset <= len; offset++) {
      boolean isRotated = true;
      for (int i = 0; i < len; i++) {
        if (s1.charAt(i) != s2.charAt((i + offset) % len)) {
          isRotated = false;
          break;
        }
      }
      log.info("offset = " + offset + "; isRotated = " + isRotated);
//            if (isRotated) {
//                return true;
//            }
    }

    return false;
  }
}
