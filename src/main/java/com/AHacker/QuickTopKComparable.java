package com.AHacker;

import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Author: Oliver
 */
@Slf4j
public class QuickTopKComparable<T extends Comparable<T>> {
  private static final SecureRandom random = new SecureRandom();

  /**
   * QuickTopK
   *
   * @param numbers
   * @param k
   */
  public void quickTopK(T[] numbers, int k) {

    if (numbers == null || numbers.length == 0)
      return;

    int n = numbers.length;
    int start = 0;
    int end = n - 1;
    quickTopKHelper(numbers, start, end, random, k);
  }

  /**
   * helper of QuickTopK
   *
   * @param numbers
   * @param start
   * @param end
   * @param random
   * @param k
   */
  private void quickTopKHelper(T[] numbers, int start, int end, Random random, int k) {

    if (numbers == null || start >= end || start >= k)
      return;

    // partition
    T pivot = numbers[start + random.nextInt(end - start + 1)];
    int left = start;
    int right = end;
    while (left <= right) {
      while (left <= right && numbers[left].compareTo(pivot) < 0) {
        left++;
      }
      while (left <= right && numbers[right].compareTo(pivot) > 0) {
        right--;
      }
      if (left <= right) {
        swap(numbers, left, right);
        left++;
        right--;
      }
    }

    // recursive
    quickTopKHelper(numbers, start, right, random, k);
    quickTopKHelper(numbers, left, end, random, k);
  }

  private void swap(T[] numbers, int i, int j) {
    if (i != j) {
      T tmp = numbers[i];
      numbers[i] = numbers[j];
      numbers[j] = tmp;
    }
  }

}
