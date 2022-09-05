package com.leetcode.Weekly67;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;

@Slf4j
public class LC762PrimeNumberOfSetBitsInBinaryRepresentation {
  public static void main(String[] args) {
    testNo762();
  }

  private static void testNo762() {
    LC762PrimeNumberOfSetBitsInBinaryRepresentation LC762PrimeNumberOfSetBitsInBinaryRepresentation = new LC762PrimeNumberOfSetBitsInBinaryRepresentation();
    log.info("result 4 v.s. " + LC762PrimeNumberOfSetBitsInBinaryRepresentation.countPrimeSetBits(6, 10));
    log.info("result 5 v.s. " + LC762PrimeNumberOfSetBitsInBinaryRepresentation.countPrimeSetBits(10, 15));
    log.info("result 23 v.s. " + LC762PrimeNumberOfSetBitsInBinaryRepresentation.countPrimeSetBits(842, 888));
  }

  /**
   * @param L
   * @param R
   * @return
   */
  public int countPrimeSetBits(int L, int R) {
    if (L > R) {
      return 0;
    }

    // core logic
    int counter = 0;
    for (int i = L; i <= R; i++) {
      if (isPrime(numberOfBits(i))) {
        counter++;
      }
    }

    return counter;
  }

  private int numberOfBits(int i) {
    int counter = 0;
    while (i > 0) {
      counter += i % 2;
      i /= 2;
    }
    return counter;
  }

  private static HashSet<Integer> primeSet = new HashSet<>();

  static {
    {
      primeSet.add(2);
      primeSet.add(3);
      primeSet.add(5);
      primeSet.add(7);
      primeSet.add(11);
      primeSet.add(13);
      primeSet.add(17);
      primeSet.add(19);
      primeSet.add(23);
      primeSet.add(29);
      primeSet.add(31);
    }
  }

  private boolean isPrime(int i) {
    return primeSet.contains(i);
  }

}
