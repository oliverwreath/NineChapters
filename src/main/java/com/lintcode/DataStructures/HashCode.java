package com.lintcode.DataStructures;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class HashCode {
  public static void main(String[] arg) {
    testHashCode();
  }

  private static void testHashCode() {
    log.info("{}", hashCode(new char[]{'a', 'b', 'c', 'd'}, 100));//78
    log.info("{}", hashCode(new char[]{'d'}, 97));//3
    log.info("{}", hashCode(new char[]{'u', 'b', 'u', 'n', 't', 'u'}, 1007));//549
  }

  static int hashCode(char[] key, int HASH_SIZE) {
    // filter abnormal inputs
    if (key == null || key.length == 0) {
      return 0;
    }

    // compute
    int len = key.length;
    long ret = key[0];
    for (int i = 1; i < len; i++) {
      ret = ret * 33 + key[i];
      ret %= HASH_SIZE;
    }

    // return result
    return (int) ret;
  }
}
