package com.GoogleAPAC.RoundA;

import lombok.extern.slf4j.Slf4j;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import static com.GoogleAPAC.RoundA.Util.*;

/**
 * Created by yanli_000 on 16/7/10.
 */
@Slf4j
public class BRain {
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    new BRain().go();
    log.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
  }

  private void go() {
    Scanner scanner = new Scanner(System.in);
    int numOfCasesT;
    if (scanner.hasNext()) {
      numOfCasesT = scanner.nextInt();
      PrintWriter printWriter = getPrintWriter("C:\\Users\\yanli_000\\Desktop\\BRain.out");

      for (int caseI = 0; caseI < numOfCasesT; caseI++) {
        int R = scanner.nextInt();
        int C = scanner.nextInt();
        scanner.nextLine();
        log.info("M = {}, C = {}", R, C);
        if (R <= 2 || C <= 2) {
          String result = "Case #" + (caseI + 1) + ": " + 0;
          printWriter.println(result);
        } else {
          int[][] H = new int[R][C];
          for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
              H[i][j] = scanner.nextInt();
            }
          }

          String result = "Case #" + (caseI + 1) + ": " + getResult(H, R, C);
          printWriter.println(result);
        }
      }

      printWriter.flush();
    }
  }

  private long getResult(int[][] H, int R, int C) {
    int[][] W = new int[R][C];
    for (int i = 0; i < R; i++) {
      System.arraycopy(H[i], 0, W[i], 0, C);
    }

    // rows
    for (int i = 1; i < R - 1; i++) {
      int[] row = new int[C];
      System.arraycopy(H[i], 0, row, 0, C);
      int[] filledRow = oneDTrappingWater(row);
      System.arraycopy(filledRow, 1, W[i], 1, C - 1 - 1);
      log.info("row = {}, filledRow = {}", Arrays.toString(row), Arrays.toString(filledRow));
    }
    printArray(W, R, C);

    // cols
    for (int j = 1; j < C - 1; j++) {
      int[] col = new int[R];
      for (int i = 0; i < R; i++) {
        col[i] = H[i][j];
      }
      int[] filledCol = oneDTrappingWater(col);
      for (int i = 1; i < R - 1; i++) {
        W[i][j] = Math.min(W[i][j], filledCol[i]);
      }
      log.info("col = {}, filledCol = {}", Arrays.toString(col), Arrays.toString(filledCol));
    }

    printArray(W, R, C);
    printArray(H, R, C);
    long ret = 0;
    for (int i = 1; i < R - 1; i++) {
      for (int j = 1; j < C - 1; j++) {
        ret += W[i][j] - H[i][j];
      }
    }

    return ret;
  }
}
