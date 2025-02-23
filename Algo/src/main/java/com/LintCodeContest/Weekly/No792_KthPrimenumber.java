package com.LintCodeContest.Weekly;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No792_KthPrimenumber {

  public static void main(String[] args) {
    testNo790_Parser();
  }

  private static void testNo790_Parser() {
    No792_KthPrimenumber No792_KthPrimenumber = new No792_KthPrimenumber();
    log.info("result 2 v.s. " + No792_KthPrimenumber.kthPrime(3));
    log.info("result 5 v.s. " + No792_KthPrimenumber.kthPrime(11));
  }

  public int kthPrime(int target) {

    if (target < 2) {
      return 0;
    }

    if (map == null) {
      map = new HashMap<>();
      HashSet<Integer> setNotPrime = new HashSet<>();
      List<Integer> primes = new LinkedList<>();
      for (int i = 2; i <= 100000; i++) {
        if (!setNotPrime.contains(i)) {
          primes.add(i);
          int num = i + i;
          while (num <= 100000) {
            setNotPrime.add(num);
            num += i;
          }
        }
      }

      int count = 1;
      for (Integer num : primes) {
        map.put(num, count++);
      }
    }

    return map.get(target);
  }

  private HashMap<Integer, Integer> map;

//    /**
//     * @param A an array of Integer
//     * @return an integer
//     */
//    public boolean canBeGenerated(String[] generator, char startSymbol, String symbolString) {
//    .
//        if (A == null || A.length == 0) {
//            return 0;
//        }
//
//        // return the final result
//        return -1;
//    }

}
