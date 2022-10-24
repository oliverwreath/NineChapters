package com.HackerRank.HourRank13;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class SumVsXOR {

  public static void main(String[] arg) {
    new SumVsXOR().testSumVsXOR();
  }

  private void testSumVsXOR() {
    SumVsXOR(5);
    SumVsXOR(10);
    SumVsXOR(101);
//        SumVsXOR(10100);
//        SumVsXOR(10100000);
  }

  // 5 2, 10 4
  void SumVsXOR(long n) {

//        Scanner in = new Scanner(System.in);
//        long n = in.nextLong();

    // approach 1 hashMap
//        HashMap<Long, Long> map = new HashMap<Long, Long>();
//        for (long x = 0; x <= n; x++) {
//            map.put(n + x, x);
//        }
//        long answer = 0;
//        for (long x = 0; x <= n; x++) {
//            long right = n ^ x;
//            if (map.containsKey(right) && map.get(right) == x) {
//                answer++;
//                log.debug("x = " + x);
//            }
//        }

    // approach 2 math
    long answer = 1;
    while (n > 0) {
      if ((n & 1L) == 0) {
        answer *= 2;
      }
      n = n >> 1;
    }

    log.debug("{}", answer);
  }
}
