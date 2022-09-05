package com.HackerRank.Greedy;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: Oliver
 */
@Slf4j
public class PriyankaAndToys {
  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scan.nextInt();
    }
    Arrays.sort(a);

    int begin = -1;
    int end = -1;
    int costCounter = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] >= begin && a[i] <= end) {
        continue;
      } else {
        costCounter++;
        begin = a[i];
        end = a[i] + 4;
      }
    }

    log.debug("{}", costCounter);
  }
}
