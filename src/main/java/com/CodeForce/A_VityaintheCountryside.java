package com.CodeForce;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * Author: Oliver
 */
@Slf4j
public class A_VityaintheCountryside {
  public static void main(String[] arg) {

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scan.nextInt();
    }
    if (n <= 0) {
      log.debug(String.valueOf(-1));
      return;
    }
    if (n == 1) {
      if (a[0] == 0) {
        log.debug("UP");
      } else if (a[0] == 15) {
        log.debug("DOWN");
      } else {
        log.debug(String.valueOf(-1));
      }
      return;
    }

    if (a[n - 1] == 0) {
      log.debug("UP");
    } else if (a[n - 1] == 15) {
      log.debug("DOWN");
    } else {
      if (a[n - 2] < a[n - 1]) {
        log.debug("UP");
      } else {
        log.debug("DOWN");
      }
    }
    return;
  }
}
