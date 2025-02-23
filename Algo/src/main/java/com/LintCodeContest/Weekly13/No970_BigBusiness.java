package com.LintCodeContest.Weekly13;

import java.util.PriorityQueue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No970_BigBusiness {

  public static void main(String[] args) {
    No970_BigBusiness No970_BigBusiness = new No970_BigBusiness();
    No970_BigBusiness.testNo970_BigBusiness();
  }

  private void testNo970_BigBusiness() {
    log.info("result 4 v.s. " + bigBusiness(new int[]{3, 1, 5}, new int[]{4, 3, 100}, 1));
    log.info("result 108 v.s. " + bigBusiness(new int[]{3, 1, 5}, new int[]{4, 3, 100}, 10));
  }

  int bigBusiness(int[] A, int[] B, int k) {
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return 0;
    }

    int len = A.length;
    PriorityQueue<Entry> minHeap = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
    for (int i = 0; i < len; i++) {
      if (A[i] >= B[i]) {
        continue;
      }
//            log.debug("i = " + i + "; A[i] = " + A[i]);
      if (k > A[i]) {
        k += B[i] - A[i];
      } else {
        minHeap.add(new Entry(A[i], B[i] - A[i]));
      }
    }

    while (!minHeap.isEmpty()) {
      if (minHeap.peek().cost > k) {
        break;
      }
      Entry entry = minHeap.poll();
      k += entry.profit;
    }

    // return the final result
    return k;
  }

  private class Entry {

    int cost;
    int profit;

    public Entry(int cost, int profit) {
      this.cost = cost;
      this.profit = profit;
    }


    @Override
    public String toString() {
      return "Entry{" +
          "cost=" + cost +
          ", profit=" + profit +
          '}';
    }
  }

}
