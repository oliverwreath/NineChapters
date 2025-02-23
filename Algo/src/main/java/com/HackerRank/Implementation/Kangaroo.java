package com.HackerRank.Implementation;

import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class Kangaroo {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int x1 = in.nextInt();
    int v1 = in.nextInt();
    int x2 = in.nextInt();
    int v2 = in.nextInt();
    if (x1 == x2) {
      log.debug("YES");
    } else {
      if (v1 == v2) {
        log.debug("NO");
      }
    }

    long c = (x1 - x2) / (v2 - v1);
    long res = (x1 - x2) % (v2 - v1);
    if (c >= 0 && res == 0) {
      log.debug("YES");
    } else {
      log.debug("NO");
    }
  }
}
