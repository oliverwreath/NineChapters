package com.HackerRank.OpenBracketCodeSprint;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * Author: Oliver
 */
@Slf4j
public class ViralAdvertising {
  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int current = 2;
    long sum = current;
    for (int i = n; i > 1; i--) {
      current = current * 3 / 2;
      sum += current;
    }
    log.debug("{}", sum);
  }
}
