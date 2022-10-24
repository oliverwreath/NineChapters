package com.CodeForce;

import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class B_AnatolyandCockroaches {

  public static void main(String[] arg) {

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    String string = scan.next();
    int w1 = 0, w2 = 0, w3 = 0, w4 = 0;
    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) {
        if (string.charAt(i) == 'b') {
          w1++;
        } else {
          w3++;
        }
      } else {
        if (string.charAt(i) == 'r') {
          w2++;
        } else {
          w4++;
        }
      }
    }

    log.debug(String.valueOf(Math.min(Math.abs(w1 - w2) + Math.min(w1, w2), Math.abs(w3 - w4) + Math.min(w3, w4))));
  }
}
