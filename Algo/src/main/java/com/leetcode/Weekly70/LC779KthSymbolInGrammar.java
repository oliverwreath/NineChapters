package com.leetcode.Weekly70;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC779KthSymbolInGrammar {

  public static void main(String[] args) {
    testNo779_KthSymbolInGrammar();
  }

  private static void testNo779_KthSymbolInGrammar() {
    LC779KthSymbolInGrammar LC779KthSymbolInGrammar = new LC779KthSymbolInGrammar();
    log.info("result 0 v.s. " + LC779KthSymbolInGrammar.kthGrammar(1, 1));
    log.info("result 0 v.s. " + LC779KthSymbolInGrammar.kthGrammar(2, 1));
    log.info("result 1 v.s. " + LC779KthSymbolInGrammar.kthGrammar(2, 2));
    log.info("result 1 v.s. " + LC779KthSymbolInGrammar.kthGrammar(4, 5));
    log.info("result 0 v.s. " + LC779KthSymbolInGrammar.kthGrammar(4, 7));
  }

  boolean[] a = new boolean[]{false, true, true, false};

  public int kthGrammar(int N, int K) {
    // filter abnormal cases
    if (K <= 4) {
      if (a[K - 1]) {
        return 1;
      } else {
        return 0;
      }
    }

    int k = K;
    boolean isReversed = false;
    while (k > 4) {
      if (k % 2 == 1) {
        k += 1;
        isReversed = !isReversed;
        k /= 2;
        isReversed = !isReversed;
      } else {
        k /= 2;
        isReversed = !isReversed;
      }
    }
    if (a[k - 1]) {
      return isReversed ? 0 : 1;
    } else {
      return isReversed ? 1 : 0;
    }
  }

}
