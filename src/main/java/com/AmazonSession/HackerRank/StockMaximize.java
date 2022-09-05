package com.AmazonSession.HackerRank;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * Author: Oliver
 */
@Slf4j
public class StockMaximize {
  public static void main(String[] arg) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

    Scanner scan = new Scanner(System.in);
    int T = scan.nextInt();
    for (int t = 0; t < T; t++) {
      int n = scan.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
      }

      int[] maxSelling = new int[n];
      int max = Integer.MIN_VALUE;
      for (int i = n - 1; i > 0; i--) {
        max = Math.max(max, a[i]);
        maxSelling[i] = max;
      }
      long profit = 0;
      for (int i = 0; i < n - 1; i++) {
        if (maxSelling[i + 1] > a[i]) {
          profit += maxSelling[i + 1] - a[i];
        }
      }
      log.debug(String.valueOf(profit));
    }
  }
}
