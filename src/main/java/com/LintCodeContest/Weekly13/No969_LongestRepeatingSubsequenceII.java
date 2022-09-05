package com.LintCodeContest.Weekly13;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class No969_LongestRepeatingSubsequenceII {
  public static void main(String[] args) {
    No969_LongestRepeatingSubsequenceII No969_LongestRepeatingSubsequenceII = new No969_LongestRepeatingSubsequenceII();
    No969_LongestRepeatingSubsequenceII.testNo969_LongestRepeatingSubsequenceII();
  }

  private void testNo969_LongestRepeatingSubsequenceII() {
    log.info("result 2 v.s. " + longestRepeatingSubsequenceII("aaa", 2));
    log.info("result 6 v.s. " + longestRepeatingSubsequenceII("aabcbcbcbc", 2));
  }

  int longestRepeatingSubsequenceII(String str, int k) {
    // filter abnormal cases
    if (str == null || str.length() == 0) {
      return 0;
    }//

    HashMap<String, Integer> map = new HashMap<>();
    int len = str.length();
    int maxLength = 0;
    for (int i = 0; i < len; i++) {
//            if (maxLength != 0) {
//                log.debug("maxLength = " + maxLength);
//            }
      for (int j = len; j > Math.max(i, i + maxLength - 1); j--) {
        String key = str.substring(i, j);
        if (!map.containsKey(key)) {
          map.put(key, 1);
        } else {
          map.put(key, map.get(key) + 1);
        }
        if (map.get(key) >= k) {
          maxLength = Math.max(maxLength, str.length());
        }
      }
    }

    for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
      if (stringIntegerEntry.getValue() >= k) {
        maxLength = Math.max(maxLength, stringIntegerEntry.getKey().length());
      }
    }

    // return the final result
    return maxLength;
  }

}
