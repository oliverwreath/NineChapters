package com.leetcode.Weekly42;

import java.util.ArrayList;
import java.util.Comparator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC646MaximumLengthOfPairChain {

  public static void main(String[] args) {
    testMaximumLengthOfPairChain_646();
  }

  private static void testMaximumLengthOfPairChain_646() {
    LC646MaximumLengthOfPairChain LC646MaximumLengthOfPairChain = new LC646MaximumLengthOfPairChain();
    log.info("result 2 = " + LC646MaximumLengthOfPairChain.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    log.info(
        "result 3 = " + LC646MaximumLengthOfPairChain.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}, {5, 6}}));
    log.info(
        "result 2 = " + LC646MaximumLengthOfPairChain.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 6}}));
  }

  /**
   * @param pairs
   * @return
   */
  public int findLongestChain(int[][] pairs) {
    if (pairs == null || pairs.length < 1 || pairs[0] == null || pairs[0].length < 1) {
      return 0;
    }

    int len = pairs.length;
    ArrayList<Pair> pairs1 = new ArrayList<Pair>(len);
    for (int i = 0; i < len; i++) {
      pairs1.add(new Pair(pairs[i][0], pairs[i][1]));
    }
    pairs1.sort(Comparator.comparingInt(o -> o.x));

    int counter = 0;
    int[] dp = new int[len];
    dp[0] = 1;
    int maxLength = dp[0];
    for (int i = 1; i < len; i++) {
      dp[i] = 1;
      for (int i1 = 0; i1 < i; i1++) {
        if (pairs1.get(i1).y < pairs1.get(i).x) {
          dp[i] = Math.max(dp[i], dp[i1] + 1);
        }
      }
      maxLength = Math.max(maxLength, dp[i]);
    }

    return maxLength;
  }

  class Pair {

    int x;
    int y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

}
