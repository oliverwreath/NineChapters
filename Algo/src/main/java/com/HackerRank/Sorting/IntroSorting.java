package com.HackerRank.Sorting;

import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class IntroSorting {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int target = scan.nextInt();
    int n = scan.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scan.nextInt();
      if (a[i] == target) {
        log.debug("{}", i);
        return;
      }
    }
  }
}
