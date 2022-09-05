package com.LintCodeContest.Weekly13;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

@Slf4j
public class No972_DeliverTheMessage {
  public static void main(String[] args) {
    No972_DeliverTheMessage No972_DeliverTheMessage = new No972_DeliverTheMessage();
    No972_DeliverTheMessage.testNo972_DeliverTheMessage();
  }

  private void testNo972_DeliverTheMessage() {
    log.info("result 1 v.s. " + deliverMessage(new int[]{1, 2, 3}, new int[][]{
            {1, 2},
            {-1},
            {-1}
    }));
    log.info("result 3 v.s. " + deliverMessage(new int[]{1, 2, 1, 4, 5}, new int[][]{
            {1, 2},
            {3, 4},
            {-1},
            {-1},
            {-1}
    }));
  }

  int deliverMessage(int[] A, int[][] subordinate) {
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return 0;
    }

    int len = A.length;
    HashSet<Integer> set = new HashSet<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    set.add(0);
    map.put(0, 0);
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(0);

    while (!queue.isEmpty()) {
      Integer i = queue.poll();
//            if (set.size() == len) {
//                break;
//            }
      if (subordinate[i].length <= 1 && subordinate[i][0] == -1) {
        continue;
      }

      int subTime = map.get(i) + A[i];
      for (int sub : subordinate[i]) {
        set.add(sub);
        queue.add(sub);
        if (!map.containsKey(sub)) {
          map.put(sub, subTime);
        } else {
          map.put(sub, Math.min(map.get(sub), subTime));
        }
      }
    }

    int time = Integer.MIN_VALUE;
//        log.debug(map);
    for (int i = 0; i < len; i++) {
//            log.debug("i = " + i);
      time = Math.max(time, map.get(i));
    }

    // return the final result
    return time;
  }

}
