package com.leetcode.Weekly65;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC756PyramidTransitionMatrix {

  public static void main(String[] args) {
    testNo756_PyramidTransitionMatrix();
  }

  private static void testNo756_PyramidTransitionMatrix() {
    LC756PyramidTransitionMatrix lc756PyramidTransitionMatrix = new LC756PyramidTransitionMatrix();
    log.info("result 2 v.s. " + lc756PyramidTransitionMatrix.pyramidTransition("XYZ",
        Arrays.asList("XYD", "YZE", "DEA", "FFF")));
    log.info("result 1 v.s. " + lc756PyramidTransitionMatrix.pyramidTransition("XXYX",
        Arrays.asList("XXX", "XXY", "XYX", "XYY", "YXZ")));
  }

  /**
   * @param bottom
   * @param allowed
   * @return
   */
  public boolean pyramidTransition(String bottom, List<String> allowed) {
    // filter abnormal inputs
    if (bottom == null || bottom.length() < 2) {
      return true;
    }
    if (allowed == null || allowed.size() < 1) {
      return false;
    }

    // core logic
    HashMap<String, LinkedList<Character>> hashMap = new HashMap<>();

    // preprocess
    for (String s : allowed) {
      String key = s.substring(0, 2);
      if (!hashMap.containsKey(key)) {
        hashMap.put(key, new LinkedList<>());
      }
      hashMap.get(key).add(s.charAt(2));
    }

    int len = bottom.length();
    for (int t = 0; t < len - 1; t++) {
      int currentLen = bottom.length();
      String[] newBottom = new String[currentLen - 1];
      for (int i = 0; i < currentLen - 1; i++) {
        String key = bottom.substring(i, i + 2);
        if (!hashMap.containsKey(key)) {
          return false;
        } else {
          LinkedList<Character> characterLinkedList = hashMap.get(key);
        }
      }
    }

    return false;
  }

}
