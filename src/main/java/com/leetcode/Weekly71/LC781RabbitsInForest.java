package com.leetcode.Weekly71;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LC781RabbitsInForest {
  public static void main(String[] args) {
    LC781RabbitsInForest LC781_RabbitsInForest = new LC781RabbitsInForest();
    LC781_RabbitsInForest.testNo781_RabbitsInForest();
  }

  private void testNo781_RabbitsInForest() {
    log.info("result 5 v.s. " + numRabbits(new int[]{1, 1, 2}));
    log.info("result 11 v.s. " + numRabbits(new int[]{10, 10, 10}));
    log.info("result 0 v.s. " + numRabbits(new int[]{}));
  }

  public int numRabbits(int[] answers) {
    // filter abnormal cases
    if (answers == null || answers.length == 0) {
      return 0;
    }
    if (answers.length == 1) {
      return answers[0] + 1;
    }

    int answer = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int key : answers) {
      if (!map.containsKey(key)) {
        map.put(key, 1);
      } else {
        map.put(key, map.get(key) + 1);
      }
    }
    for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
      int key = integerIntegerEntry.getKey();
      int val = integerIntegerEntry.getValue();
      if (val % (key + 1) == 0) {
        answer += val;
      } else {
        answer += (val / (key + 1) + 1) * (key + 1);
      }
    }

    // return the final result
    return answer;
  }

}
