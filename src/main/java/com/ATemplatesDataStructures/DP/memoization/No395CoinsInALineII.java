package com.ATemplatesDataStructures.DP.memoization;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class No395CoinsInALineII {
  boolean firstWillWin(int[] values) {
    // filter abnormal cases
    if (values == null || values.length <= 0) {
      return false;
    }
    if (values.length <= 2) {
      return true;
    }

    int len = values.length - 1;
    map.clear();
    map.put(-1, 0);
    map.put(0, values[len]);
    map.put(1, values[len] + values[len - 1]);
    map.put(2, values[len - 1] + values[len - 2]);
    boolean answer = helper(len, values) > Math.min(helper(len - 1, values), helper(len - 2, values));
//        log.debug(map);
    return answer;
  }

  HashMap<Integer, Integer> map = new HashMap<>();

  int helper(int key, int[] values) {
    if (map.containsKey(key)) {
      return map.get(key);
    }

    int answer = Math.max(values[values.length - 1 - key] + Math.min(helper(key - 2, values), helper(key - 3, values)),
            values[values.length - 1 - key] + values[values.length - 1 - key + 1] + Math.min(helper(key - 3, values), helper(key - 4, values)));
    map.put(key, answer);
    return answer;
  }

}
