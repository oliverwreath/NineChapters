package com.GoogleAPAC.RoundC;

import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class SafeSquares {

  public static void main(String[] arg) {
    testSafeSquares();
  }

  private static void testSafeSquares() {
    long startTime = System.currentTimeMillis();
    safeSquares();
    log.info("time elapsed: {}ms", (System.currentTimeMillis() - startTime) / 1000.0);
  }

  static void safeSquares() {
    Scanner scan = new Scanner(System.in);
    int T = scan.nextInt();
    for (int t = 0; t < T; t++) {
      int R = scan.nextInt();
      int C = scan.nextInt();
      int K = scan.nextInt();
      boolean[][] grid = new boolean[R][C];
      for (int k = 0; k < K; k++) {
        int ri = scan.nextInt();
        int ci = scan.nextInt();
        grid[ri][ci] = true;
      }

      int maxLength = Math.min(R, C);
      int len = maxLength;
      int safeCounter = 0;
      while (len > 1) {
        for (int i = 0; i <= R - len; i++) {
          for (int j = 0; j <= C - len; j++) {
            boolean isSafe = true;
            for (int r = i; r < i + len; r++) {
              for (int c = j; c < j + len; c++) {
                if (grid[r][c]) {
                  isSafe = false;
                  break;
                }
                if (!isSafe) {
                  break;
                }
              }
            }
            if (isSafe) {
              safeCounter++;
            }
          }
        }
//                log.debug("safeCounter=" + safeCounter);
        len--;
      }
      safeCounter += R * C - K;
//            log.debug("TOTAL safeCounter=" + safeCounter);
      System.out.format("Case #%d: %d\n", t + 1, safeCounter);
    }
  }
}
