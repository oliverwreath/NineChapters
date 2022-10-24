package com.HackerRank;

import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class TreasureHunting {

  public static void main(String[] arg) {
    testTreasureHunting();
  }

  private static void testTreasureHunting() {
    treasureHunting();
  }

  static void treasureHunting() {
    Scanner scan = new Scanner(System.in);
    long x = scan.nextLong();
    long y = scan.nextLong();
    long a = scan.nextLong();
    long b = scan.nextLong();
    long numerator = a * x + y * b;
    long denominator = a * a + b * b;
    double k = numerator * 1.0 / denominator;
    numerator = a * y - x * b;
    double n = numerator * 1.0 / denominator;
//        double k = (a * x + y * b) / (a * a + b * b);
//        double n = (a * y - x * b) / (a * a + b * b);
    log.debug("{}", k);
    log.debug("{}", n);
  }
}
