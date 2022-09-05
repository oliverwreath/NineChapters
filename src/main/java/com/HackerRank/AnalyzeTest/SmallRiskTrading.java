package com.HackerRank.AnalyzeTest;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: Oliver
 */
@Slf4j
public class SmallRiskTrading {
  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int k = scan.nextInt();
    double[] P = new double[n];
    for (int i = 0; i < n; i++) {
      P[i] = scan.nextDouble();
    }
    double[] X = new double[n];
    for (int i = 0; i < n; i++) {
      X[i] = scan.nextDouble();
    }
    double[] profit = new double[n];
    for (int i = 0; i < n; i++) {
      double tmpY = scan.nextDouble();
      profit[i] = P[i] * X[i] - (1 - P[i]) * tmpY;
    }
    Arrays.sort(profit);

    // check before committing
//        log.debug("P = " + Arrays.toString(P));
//        log.debug("X = " + Arrays.toString(X));
//        log.debug("profit = " + Arrays.toString(profit));

    double globalMax = 0.0;
    for (int i = n - 1; i >= n - 1 - k + 1; i--) {
      if (profit[i] > 0) {
        globalMax += profit[i];
      } else {
        break;
      }
    }
    System.out.format("%.2f", globalMax);
  }
}

//4 2
//        0.5 0.5 0.5 0.5
//        4.0 1.0 2.0 3.0
//        4.0 0.5 1.0 1.0
