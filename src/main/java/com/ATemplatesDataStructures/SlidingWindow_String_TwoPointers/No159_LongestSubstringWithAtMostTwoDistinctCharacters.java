package com.ATemplatesDataStructures.SlidingWindow_String_TwoPointers;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class No159_LongestSubstringWithAtMostTwoDistinctCharacters {
  public static void main(String[] args) {
    testNo159_LongestSubstringWithAtMostTwoDistinctCharacters();
  }

  private static void testNo159_LongestSubstringWithAtMostTwoDistinctCharacters() {
    No159_LongestSubstringWithAtMostTwoDistinctCharacters No159_LongestSubstringWithAtMostTwoDistinctCharacters = new No159_LongestSubstringWithAtMostTwoDistinctCharacters();
    log.info("result 3 v.s. " + No159_LongestSubstringWithAtMostTwoDistinctCharacters.lengthOfLongestSubstringTwoDistinct("eceba"));
    log.info("result 0 v.s. " + No159_LongestSubstringWithAtMostTwoDistinctCharacters.lengthOfLongestSubstringTwoDistinct(""));
  }

  /**
   * @param s
   * @return
   */
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    // filter abnormal inputs
    if (s == null) {
      return 0;
    }
    if (s.length() < 3) {
      return s.length();
    }

    // core logic
    int start = 0;
    int end = 0;
    int maxLength = Integer.MIN_VALUE;
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      Character key = s.charAt(i);
      if (!map.containsKey(key) && map.size() == 2) {
        // situation 3
        int leftMost = Integer.MAX_VALUE;
        for (int value : map.values()) {
          leftMost = Math.min(leftMost, value);
        }
        start = leftMost + 1;
        map.remove(s.charAt(leftMost));
      }
      map.put(key, end);
      maxLength = Math.max(maxLength, end - start + 1);
      end++;
    }

    return maxLength;
  }

}
