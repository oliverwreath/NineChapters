package com.HackerRank.CrackingTheCodingInterviewChallenges;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunningMedian {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] a = new int[n];
    for (int a_i = 0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
    }

    int len = a.length;
    if (len < 1) {
      return;
    }
    PriorityQueue<Integer> left = new PriorityQueue<>(5, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });
    PriorityQueue<Integer> right = new PriorityQueue<>(5, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1 - o2;
      }
    });
    for (int i = 0; i < len; i++) {
      int newInt = a[i];
      if (left.size() == right.size()) {
        if (left.isEmpty() || left.peek() < newInt) {
          right.add(newInt);
        } else {
          right.add(left.poll());
          left.add(newInt);
        }
        log.debug("{}", right.peek() * 1.0);
      } else {
        if (newInt < right.peek()) {
          left.add(newInt);
        } else {
          left.add(right.poll());
          right.add(newInt);
        }
        log.debug("{}", (left.peek() + right.peek()) / 2.0);
      }
    }
  }

//    private static void testRunningMedian() {
//        RunningMedian RunningMedian = new RunningMedian();
//        log.info("result 2 v.s. " + RunningMedian.longestIncreasingContinuousSubsequence("12"));
//        log.info("result 1 v.s. " + RunningMedian.longestIncreasingContinuousSubsequence("10"));
//    }

  /**
   * @param A an array of Integer
   * @return an integer
   */
  int longestIncreasingContinuousSubsequence(int[] A) {
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return 0;
    }

    // return the final result
    return -1;
  }

}
