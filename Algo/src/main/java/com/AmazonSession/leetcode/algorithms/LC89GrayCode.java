package com.AmazonSession.leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC89GrayCode {

  public List<Integer> grayCode(int n) {

    if (n < 1) {
      LinkedList<Integer> ans = new LinkedList<Integer>();
      ans.add(0);
      return ans;
    }
    if (n == 1) {
      LinkedList<Integer> ans = new LinkedList<Integer>();
      ans.add(0);
      ans.add(1);
      return ans;
    }

    // fill the ans
    LinkedList<Integer> ans = new LinkedList<Integer>();
    int len = 4;
    String[] seeds = new String[]{"0", "1"};
    for (int t = 0; t < n - 1; t++) {
      String[] results = new String[len];
      int j = 0;
      for (int i = 0; i < seeds.length; i++, j++) {
        results[j] = '0' + seeds[i];
//        log.info("t = " + t + " fori: " + results[j]);
        if (t == n - 2) {
          ans.add(binaryString2Int(results[j]));
        }
      }
      for (int i = seeds.length - 1; i >= 0; i--, j++) {
        results[j] = '1' + seeds[i];
//        log.info("t = " + t + " forr: " + results[j]);
        if (t == n - 2) {
          ans.add(binaryString2Int(results[j]));
        }
      }
      len *= 2;
      seeds = results;
    }

    return ans;
  }

  public int binaryString2Int(String binaryString) {
    int n = binaryString.length();
    if (n < 1) {
      return 0;
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans *= 2;
      ans += binaryString.charAt(i) - '0';
    }
    return ans;
  }
}
