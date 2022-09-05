package com.HackerRank.OpenBracketCodeSprint;

import com.lintcode.Advanced.Heap.HashHeap.HashHeap;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Author: Oliver
 */
@Slf4j
public class FraudulentActivityNotifications {
  private static HashHeap maxHeap;
  private static HashHeap minHeap;

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int d = scan.nextInt();
    // d
    // minHeap, maxHeap
    maxHeap = new HashHeap("max");
    minHeap = new HashHeap("min");
    int lastMedX2 = 0;
    int warningCount = 0;
    ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
    for (int i = 0; i < n; i++) {
      int current = scan.nextInt();
      deque.addLast(current);
      minHeap.add(current);
      maxHeap.add(minHeap.poll());
      if (maxHeap.size() > minHeap.size() + 1) {
        minHeap.add(maxHeap.poll());
      }
//            log.debug((i + 1) + " day; current = " + current + "\nmaxHeap = " + maxHeap + "\nminHeap = " + minHeap + "\ngetMedX2(maxHeap, minHeap) = " + getMedX2(maxHeap, minHeap));

//            log.debug("flag2");
      if (i >= d) {
        Integer poll = deque.pollFirst();
//                log.debug(deque + "; poll = " + poll);
//                assert deque.size() == d;
        if (maxHeap.size() == minHeap.size()) {
//                    minHeap.poll();
          if (!minHeap.delete(poll)) {
            maxHeap.delete(poll);
            maxHeap.add(minHeap.poll());
          }
        } else {
//                    maxHeap.poll();
          if (!maxHeap.delete(poll)) {
            minHeap.delete(poll);
            minHeap.add(maxHeap.poll());
          }
        }
        if (current >= lastMedX2) {
          warningCount++;
//                    log.debug((i + 1) + " day; Warn current = " + current + "; lastMedX2 = " + lastMedX2);
        }
//                else {
//                    log.debug((i + 1) + " day; NO warn current = " + current + "; lastMedX2 = " + lastMedX2);
//                }
      }
      if (i >= d - 1) {
//                log.debug("d = " + d + "; i = " + i);
//                log.debug((i + 1) + " day; current = " + current + "\nmaxHeap = " + maxHeap + "\nminHeap = " + minHeap);
        lastMedX2 = getMedX2(maxHeap, minHeap);
      }
    }

    log.debug("{}", warningCount);
  }

  private static int getMedX2(HashHeap maxHeap, HashHeap minHeap) {
    if (maxHeap.size() == minHeap.size()) {
      return maxHeap.peek() + minHeap.peek();
    } else {
      return 2 * maxHeap.peek();
    }
  }

  private static Comparator<Integer> maxComparator = new Comparator<Integer>() {
    public int compare(Integer o1, Integer o2) {
      return o2 - o1;
    }
  };
}
