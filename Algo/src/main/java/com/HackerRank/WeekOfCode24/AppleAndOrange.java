package com.HackerRank.WeekOfCode24;

import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class AppleAndOrange {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    int t = in.nextInt();
    int a = in.nextInt();
    int b = in.nextInt();
    int m = in.nextInt();
    int n = in.nextInt();
    int appleCounter = 0;
    for (int apple_i = 0; apple_i < m; apple_i++) {
      int tmp = a + in.nextInt();
      if (tmp >= s && tmp <= t) {
        appleCounter++;
      }
    }
    int orangeCounter = 0;
    for (int orange_i = 0; orange_i < n; orange_i++) {
      int tmp = b + in.nextInt();
      if (tmp >= s && tmp <= t) {
        orangeCounter++;
      }
    }

    log.debug(String.valueOf(appleCounter));
    log.debug(String.valueOf(orangeCounter));

    return;
  }
}
