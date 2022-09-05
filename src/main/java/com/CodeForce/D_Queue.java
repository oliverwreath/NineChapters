package com.CodeForce;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: Oliver
 */
@Slf4j
public class D_Queue {
  public static void main(String[] arg) {

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scan.nextInt();
    }
    if (n <= 0) {
      log.debug(String.valueOf(0));
      return;
    }
    if (n == 1) {
      log.debug(String.valueOf(1));
      return;
    }

    Arrays.sort(a);
    int sum = a[0];
    int counter = 1;
    for (int i = 1; i < n; i++) {
      if (a[i] >= sum) {
        counter++;
        sum += a[i];
      }
    }

    log.debug("counter={}", counter);

    return;
  }
}
