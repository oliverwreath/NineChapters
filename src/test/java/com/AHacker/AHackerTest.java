package com.AHacker;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Author: Oliver
 */
@Slf4j
class AHackerTest {
  private static final SecureRandom random = new SecureRandom();

  @Test void testQuickTopK() {
//        log.info("{}", QuickTopK());
    int n = 300;
    int[] numsQuickSorted = new int[n];
    int[] expected = new int[n];
    for (int i = 0; i < n; i++) {
      numsQuickSorted[i] = random.nextInt(99);
      expected[i] = numsQuickSorted[i];
    }

    int k = 99;
    QuickTopK.quickSort(numsQuickSorted, k);
//    log.debug(Arrays.toString(numsQuickSorted));
    Arrays.sort(expected);
//    log.debug(Arrays.toString(expected));
    Assertions.assertNotEquals(expected, numsQuickSorted);
    for (int i = 0; i < Math.min(k, numsQuickSorted.length); i++) {
      Assertions.assertEquals(expected[i], numsQuickSorted[i]);
    }
//    for (int i = 0; i < numsQuickSorted.length; i++) {
//        if (numsQuickSorted[i] != expected[i]) {
//          log.debug("index {} false: expected[i]={}, numsQuickSorted[i]={}", i, expected[i], numsQuickSorted[i]);
//        }
//    }
  }

  @Test void testQuickTopKComparable() {
    int n = 300;
    Integer[] numsQuickSorted = new Integer[n];
    int[] expected = new int[n];
    for (int i = 0; i < n; i++) {
      numsQuickSorted[i] = random.nextInt(99);
      expected[i] = numsQuickSorted[i];
    }

    int k = 99;
    QuickTopKComparable<Integer> quickTopKComparable = new QuickTopKComparable<>();
    quickTopKComparable.quickTopK(numsQuickSorted, k);
//    log.debug(Arrays.toString(numsQuickSorted));
    Arrays.sort(expected);
//    log.debug(Arrays.toString(expected));
    for (int i = 0; i < Math.min(k, numsQuickSorted.length); i++) {
      Assertions.assertEquals(expected[i], numsQuickSorted[i]);
    }
  }

  @Test void testQuickSortInt() {
//        log.info("{}", QuickTopK());
    int n = 300;
    int[] numsQuickSorted = new int[n];
    int[] expected = new int[n];
    for (int i = 0; i < n; i++) {
      numsQuickSorted[i] = random.nextInt(99);
      expected[i] = numsQuickSorted[i];
    }
//        int goodCounter = 0;
//        int badCounter = 0;
//        for (int i = 0; i < 999999999; i++) {
//            int num = random.nextInt(n);
//            if (0 <= num && num < n) {
//                goodCounter++;
//            } else {
//                badCounter++;
//            }
//        }
//        log.debug("goodCounter = " + goodCounter + "; badCounter = " + badCounter);


    QuickSortInt.quickSort(numsQuickSorted);
//    log.debug(Arrays.toString(numsQuickSorted));
    Arrays.sort(expected);
    Assertions.assertNotEquals(expected, numsQuickSorted);
    for (int i = 0; i < numsQuickSorted.length; i++) {
      Assertions.assertEquals(expected[i], numsQuickSorted[i]);
    }
  }

  @Test void testQuickSortComparable() {
//        log.info("{}", QuickTopK());
    int n = 300;
    Integer[] numsQuickSorted = new Integer[n];
    int[] expected = new int[n];
    for (int i = 0; i < n; i++) {
      numsQuickSorted[i] = random.nextInt(99);
      expected[i] = numsQuickSorted[i];
    }

    QuickSortComparable<Integer> quickSortComparable = new QuickSortComparable<>();
    quickSortComparable.quickSort(numsQuickSorted);
    log.info(Arrays.toString(numsQuickSorted));
    Arrays.sort(expected);
    for (int i = 0; i < numsQuickSorted.length; i++) {
      Assertions.assertEquals(expected[i], numsQuickSorted[i]);
    }
  }
}
