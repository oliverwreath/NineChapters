package com.NineChapters.IntervalArrayMatrixAndBinaryIndexedTree;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Merge_two_sorted_arrays_6 {

  public static void main(String[] args) {
    testMerge_two_sorted_arrays_6();
  }

  private static void testMerge_two_sorted_arrays_6() {
    log.info("result [1,1] v.s. {}", mergeSortedArray(new int[]{1}, new int[]{1}));
    log.info("result [1,2,2,3,4,4,5,6] v.s. {}", mergeSortedArray(new int[]{1, 2, 3, 4}, new int[]{2, 4, 5, 6}));
  }

  public static int[] mergeSortedArray(int[] A, int[] B) {
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return B;
    }
    if (B == null || B.length == 0) {
      return A;
    }

    int[] result = new int[A.length + B.length];
    int i = 0, j = 0, k = 0;
    while (i < A.length && j < B.length) {
      if (A[i] < B[j]) {
        result[k++] = A[i++];
      } else {
        result[k++] = B[j++];
      }
    }
    if (i < A.length) {
      while (i < A.length) {
        result[k++] = A[i++];
      }
    } else {
      while (j < B.length) {
        result[k++] = B[j++];
      }
    }

    // return the final result
    return result;
  }

}
