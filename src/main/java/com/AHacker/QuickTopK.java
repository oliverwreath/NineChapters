package com.AHacker;

import java.security.SecureRandom;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class QuickTopK {

  private static final SecureRandom random = new SecureRandom();

  public static void quickSort(int[] numbers, int k) {

    if (numbers == null || numbers.length == 0) {
      return;
    }

    int n = numbers.length;
    int start = 0;
    int end = n - 1;
    quickSortHelper(numbers, start, end, random, k);
    return;
  }

  private static void quickSortHelper(int[] numbers, int start, int end, Random random, int k) {

    if (numbers == null || start >= end || start >= k) {
      return;
    }

    // partition
    int pivot = numbers[start + random.nextInt(end - start + 1)];
    int left = start;
    int right = end;
    while (left <= right) {
      while (left <= right && numbers[left] < pivot) {
        left++;
      }
      while (left <= right && numbers[right] > pivot) {
        right--;
      }
      if (left <= right) {
        swap(numbers, left, right);
        left++;
        right--;
      }
    }

    // recursive
    quickSortHelper(numbers, start, right, random, k);
    quickSortHelper(numbers, left, end, random, k);
  }

  private static void swap(int[] numbers, int i, int j) {
    if (i != j) {
      int tmp = numbers[i];
      numbers[i] = numbers[j];
      numbers[j] = tmp;
    }
  }

}
