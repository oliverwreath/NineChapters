package com.ATemplatesDataStructures.Algorithms;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class Ladder384_LongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) {
    testLadder384_LongestSubstringWithoutRepeatingCharacters();
  }

  private static void testLadder384_LongestSubstringWithoutRepeatingCharacters() {
    Ladder384_LongestSubstringWithoutRepeatingCharacters Ladder384_LongestSubstringWithoutRepeatingCharacters = new Ladder384_LongestSubstringWithoutRepeatingCharacters();
//        log.info("result 1 v.s. " + Ladder384_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("aaaa"));
//        log.info("result 3 v.s. " + Ladder384_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));
    log.info("result 9 v.s. " + Ladder384_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("gehmbfqmozbpripibusbezagafqtypz"));
  }

  /**
   * @param s
   * @return
   */
  public int lengthOfLongestSubstring(String s) {

    if (s == null || s.length() < 1) {
      return 0;
    }

    int start = 0;
    int len = s.length();
    HashMap<Character, Integer> hashMap = new HashMap<>();
    int max = Integer.MIN_VALUE;
    for (int end = 0; end < len; end++) {
      if (hashMap.containsKey(s.charAt(end))) {
        int newStart = hashMap.get(s.charAt(end)) + 1;
        for (int i = start; i < newStart; i++) {
          hashMap.remove(s.charAt(i));
        }
        start = newStart;
      }
//            log.debug("end, start = " + end + ", " + start);
//            log.debug("hashMap = " + hashMap);
      hashMap.put(s.charAt(end), end);
//            log.debug("hashMap = " + hashMap);

      max = Math.max(max, end - start + 1);
    }

    return max;
  }

}
