package com.HackerRank.H101Hack42;

import java.util.ArrayList;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class JohnsSubwayCommute {

  public static void main(String[] arg) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
//        long T = scan.nextLong();
//        for (long t = 0; t < T; t++) {
    //scan.next();
    JohnsSubwayCommute johnsSubwayCommute = new JohnsSubwayCommute();
//        johnsSubwayCommute.SubwayCommute(scan.next());
    johnsSubwayCommute.SubwayCommute("EEOEE");
    johnsSubwayCommute.SubwayCommute("OEEEEO");
//        }
  }

  private void SubwayCommute(String string) {

//        if (string.equals("OEEEEO")) {
//            log.debug(2);
//            return;
//        }
    int n = string.length();
//        log.debug(string);
    if (n == 1) {
      log.debug("{}", 0);
      return;
    }
    if (string.charAt(n - 1) == 'E') {
      log.debug("{}", n - 1);
      return;
    }
    if (string.charAt(0) == 'E') {
      log.debug("{}", 0);
      return;
    }
    boolean seeEmptyYet = false;
    int currentEmptyBegin = -1;
    int currentEmptyEnd = -1;
    int currentEmptyCounter = 0;
    int maxCounter = 0;
    int maxBegin = -1;
    int maxEnd = -1;
    int totalEmptyCounter = 0;
    ArrayList<Point> emptylist = new ArrayList<Point>(n);
    for (int i = 0; i < n; i++) {
      if (string.charAt(i) == 'E') {
        seeEmptyYet = true;
        totalEmptyCounter++;
        if (currentEmptyCounter == 0) {
          currentEmptyBegin = i;
        }
        currentEmptyCounter++;
      } else {
        if (currentEmptyCounter > 0) {
          currentEmptyEnd = i - 1;
          emptylist.add(new Point(currentEmptyBegin, currentEmptyEnd));
//                    if (currentEmptyCounter > maxCounter) {
//                        maxCounter = currentEmptyCounter;
//                        maxBegin = currentEmptyBegin;
//                        maxEnd = currentEmptyEnd;
//                    }
          if (currentEmptyCounter >= 2) {
            log.debug("{}", currentEmptyBegin + 1);
            return;
//                        if (currentEmptyCounter == 2) {
//                            log.debug(currentEmptyBegin + 1);
//                            return;
//                        } else {
//                            log.debug(currentEmptyBegin + (currentEmptyCounter - 1) / 2);
//                            return;
//                        }
          }
        }
        currentEmptyBegin = -1;
        currentEmptyEnd = -1;
        currentEmptyCounter = 0;
        if (seeEmptyYet) {

        }
      }
    }
    if (currentEmptyCounter > 0) {
      currentEmptyEnd = n - 1;
      emptylist.add(new Point(currentEmptyBegin, currentEmptyEnd));
      if (currentEmptyCounter > maxCounter) {
        maxCounter = currentEmptyCounter;
        maxBegin = currentEmptyBegin;
        maxEnd = currentEmptyEnd;
      }
    }
//        log.debug(emptylist);
    log.debug("{}", emptylist.get(0).x);
    return;
//        if (totalEmptyCounter == 1) {
//            log.debug(maxBegin);
//        }
//        log.debug(new Random().nextInt(n));
  }

  private class Point {

    long x;
    long y;

    public Point() {

    }

    public Point(long x, long y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "Point{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }
  }
}
//2
//        3
//        0 0
//        0 1
//        1 0
//        4
//        0 0
//        0 2
//        2 0
//        1 1
