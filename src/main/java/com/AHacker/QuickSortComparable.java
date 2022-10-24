package com.AHacker;

import java.security.SecureRandom;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class QuickSortComparable<T extends Comparable<T>> {

  private static final SecureRandom random = new SecureRandom();

  public void quickSort(T[] numbers) {

    if (numbers == null || numbers.length == 0) {
      return;
    }

    int n = numbers.length;
    int start = 0;
    int end = n - 1;
    quickSortHelper(numbers, start, end, random);
  }

  private void quickSortHelper(T[] numbers, int start, int end, Random random) {

    if (numbers == null || start >= end) {
      return;
    }

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
    quickSortHelper(numbers, start, right, random);
    quickSortHelper(numbers, left, end, random);
  }

  private void swap(T[] numbers, int i, int j) {
    if (i != j) {
      T tmp = numbers[i];
      numbers[i] = numbers[j];
      numbers[j] = tmp;
    }
  }
}
