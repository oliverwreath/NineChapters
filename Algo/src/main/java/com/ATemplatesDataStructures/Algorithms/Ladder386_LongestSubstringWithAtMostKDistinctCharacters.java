package com.ATemplatesDataStructures.Algorithms;

import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ladder386_LongestSubstringWithAtMostKDistinctCharacters {

  public static void main(String[] args) {
    testLadder386_LongestSubstringWithAtMostKDistinctCharacters();
  }

  private static void testLadder386_LongestSubstringWithAtMostKDistinctCharacters() {
    Ladder386_LongestSubstringWithAtMostKDistinctCharacters Ladder386_LongestSubstringWithAtMostKDistinctCharacters = new Ladder386_LongestSubstringWithAtMostKDistinctCharacters();
//        log.info("result 4 v.s. " + Ladder386_LongestSubstringWithAtMostKDistinctCharacters.lengthOfLongestSubstringKDistinct("eceba", 3));
    log.info(
        "result 0 v.s. " + Ladder386_LongestSubstringWithAtMostKDistinctCharacters.lengthOfLongestSubstringKDistinct(
            "onykowalsrolughyufhxigqkwalvfo", 0));
  }

  /**
   * @param s
   * @param k
   * @return
   */
  public int lengthOfLongestSubstringKDistinct(String s, int k) {

    if (s == null || s.length() < 1 || k < 1) {
      return 0;
    }

    int start = 0;
    int len = s.length();
    HashMap<Character, Integer> hashMap = new HashMap<>();
    int max = Integer.MIN_VALUE;
    for (int end = 0; end < len; end++) {
      if (hashMap.size() == k && !hashMap.containsKey(s.charAt(end))) {
        // find the smallest value in map
        int min = Integer.MAX_VALUE;
        for (int value : hashMap.values()) {
          min = Math.min(min, value);
        }
        // remove
//                log.debug("hashMap = " + hashMap);
//                log.debug("start, min = " + start + ", " + min);
        hashMap.remove(s.charAt(min));
        // start
        start = min + 1;
      }
      hashMap.put(s.charAt(end), end);

      max = Math.max(max, end - start + 1);
    }

    return max;
  }

}
