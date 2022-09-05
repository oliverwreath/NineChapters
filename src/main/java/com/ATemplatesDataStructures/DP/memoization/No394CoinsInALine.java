package com.ATemplatesDataStructures.DP.memoization;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class No394CoinsInALine {
  public boolean firstWillWin(int n) {
    // filter abnormal cases
    if (n <= 0) {
      return false;
    }

    map.clear();
    map.put(0, false);
    map.put(1, true);
    map.put(2, true);
    map.put(3, false);
    return helper(n);
  }

  private static final HashMap<Integer, Boolean> map = new HashMap<>();

  static boolean helper(int key) {
    if (map.containsKey(key)) {
      return map.get(key);
    }

    boolean answer = helper(key - 2) && helper(key - 3) || (helper(key - 3) && helper(key - 4));

    map.put(key, answer);
    return answer;
  }

}
