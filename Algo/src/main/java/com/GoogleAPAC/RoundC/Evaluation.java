package com.GoogleAPAC.RoundC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class Evaluation {

  public static void main(String[] arg) {
    testEvaluation();
  }

  private static void testEvaluation() {
    long startTime = System.currentTimeMillis();
    evaluation();
    log.info("time elapsed: {}ms", (System.currentTimeMillis() - startTime) / 1000.0);
  }

  static void evaluation() {
    Scanner scan = new Scanner(System.in);
    int T = scan.nextInt();
    for (int t = 0; t < T; t++) {
      // input
      int N = scan.nextInt();
      Map<String, List<String>> pointMap = new HashMap<String, List<String>>();
      Map<String, Integer> wantedBloodMap = new HashMap<String, Integer>();
      LinkedList<String> knownList = new LinkedList<String>();
      for (int n = 0; n < N; n++) {
        String string = scan.next();
        String left = string.substring(0, string.indexOf("="));
        String right = string.substring(string.indexOf("(") + 1, string.length() - 1);
//                log.debug(string);
//                log.debug(left);
//                log.debug(right);
        if (!right.isEmpty()) {
          String[] splits = right.split(",");
//                    log.debug(Arrays.toString(splits));
          Set<String> set = new HashSet<String>(Arrays.asList(splits));
          for (String s : set) {
            if (pointMap.containsKey(s)) {
              pointMap.get(s).add(left);
            } else {
              LinkedList<String> tmpList = new LinkedList<String>();
              tmpList.add(left);
              pointMap.put(s, tmpList);
            }
          }
          wantedBloodMap.put(left, set.size());
        } else {
          knownList.add(left);
        }
      }
//            log.debug(pointMap);
//            log.debug(wantedBloodMap);
//            log.debug(knownList);

      // process
      while (wantedBloodMap.size() > 0 && knownList.size() > 0) {
        if (pointMap.containsKey(knownList.getFirst())) {
          String first = knownList.getFirst();
          List<String> list = pointMap.get(first);
          for (String targeted : list) {
            if (wantedBloodMap.containsKey(targeted)) {
              int newBlood = wantedBloodMap.get(targeted) - 1;
              if (newBlood <= 0) {
                knownList.addLast(targeted);
                wantedBloodMap.remove(targeted);
              } else {
                wantedBloodMap.put(targeted, newBlood);
              }
            }
          }
        }
        knownList.removeFirst();
      }
//            log.debug(pointMap);
//            log.debug(wantedBloodMap);
//            log.debug(knownList);

      // result
      if (wantedBloodMap.isEmpty()) {
        System.out.format("Case #%d: %s\n", t + 1, "GOOD");
      } else {
        System.out.format("Case #%d: %s\n", t + 1, "BAD");
      }
    }
  }
}
