package com.TR;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Move {

  public static void main(String[] args) {
    testMove();
  }

  private static void testMove() {
    Move Move = new Move();
    log.info("result 1 v.s. " + Move.moves(new int[]{13, 10, 21, 20}));
    log.info("result 2 v.s. " + Move.moves(new int[]{8, 5, 11, 4, 6}));
//        log.info("result 1 v.s. " + Move.moves("10"));
  }

  static int moves(int[] a) {
    // core logic
//        log.debug(Arrays.toString(a));
    int len = a.length;
    int count = 0;
    int i = 0, j = len - 1;
    while (i < j) {
      while (a[i] % 2 == 0 && i < j) {
        i++;
      }
      if (i < j) {
        while (a[j] % 2 == 1 && i < j) {
          j--;
        }
      }
      if (i < j) {
        count++;
        i++;
        j--;
      }
    }
    return count;
  }

}
