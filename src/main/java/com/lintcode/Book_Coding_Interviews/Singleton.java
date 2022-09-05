package com.lintcode.Book_Coding_Interviews;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class Singleton {
  private static final Singleton solution = new Singleton();

  public static void main(String[] arg) {
    testSingleton();
  }

  private static void testSingleton() {
    log.info("{}", getInstance());
  }

  static Singleton getInstance() {
    return solution;
  }
}
