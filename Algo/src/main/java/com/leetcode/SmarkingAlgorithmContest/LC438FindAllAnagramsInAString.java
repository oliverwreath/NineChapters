package com.leetcode.SmarkingAlgorithmContest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC438FindAllAnagramsInAString {

  public static void main(String[] arg) {
    new LC438FindAllAnagramsInAString().testFindAllAnagramsInAString_438();
  }

  private void testFindAllAnagramsInAString_438() {
    log.info("[0, 6] = {}", findAnagrams("cbaebabacd", "abc"));
    log.info("[0, 1, 2] = {}", findAnagrams("abab", "ab"));
  }

  public List<Integer> findAnagrams(String s, String p) {

    LinkedList<Integer> ans = new LinkedList<>();
    if (s == null || s.length() == 0 || s.length() < p.length()) {
      return ans;
    }

    int pn = p.length();
    int[] targetCode = getCode(p);
    HashSet<int[]> ints = new HashSet<>();

    // first
    int n = s.length();
    int[] dynamicCode = new int[27];
    for (int i = 0; i < pn; i++) {
      dynamicCode[s.charAt(i) - 'a']++;
    }
    if (same(dynamicCode, targetCode)) {
      ans.add(0);
    }
    log.info("first targetCode = " + Arrays.toString(targetCode));
    log.info("first dynamicCode = " + Arrays.toString(dynamicCode));

    // rest
    for (int i = pn; i < n; i++) {
      dynamicCode[s.charAt(i) - 'a']++;
      dynamicCode[s.charAt(i - pn) - 'a']--;
      if (same(dynamicCode, targetCode)) {
        ans.add(i - pn + 1);
      }
    }
    log.info("rest dynamicCode = " + Arrays.toString(dynamicCode));

    return ans;
  }

  private boolean same(int[] dynamicCode, int[] targetCode) {
    if (dynamicCode.length == targetCode.length) {
      for (int i = 0; i < dynamicCode.length; i++) {
        if (dynamicCode[i] != targetCode[i]) {
          return false;
        }
      }
      return true;
    }
    return false;
  }

  private int[] getCode(String string) {
    int[] code = new int[27];
    int n = string.length();
    for (int i = 0; i < n; i++) {
      code[string.charAt(i) - 'a']++;
    }
    return code;
  }

}
