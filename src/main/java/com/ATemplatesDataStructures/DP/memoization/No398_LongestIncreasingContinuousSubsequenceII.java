package com.ATemplatesDataStructures.DP.memoization;

import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No398_LongestIncreasingContinuousSubsequenceII {

  public static void main(String[] args) {
    testNo397_LongestIncreasingContinuousSubsequence();
  }

  private static void testNo397_LongestIncreasingContinuousSubsequence() {
    No398_LongestIncreasingContinuousSubsequenceII No397_LongestIncreasingContinuousSubsequence = new No398_LongestIncreasingContinuousSubsequenceII();
    log.info("result 1 v.s. " + No397_LongestIncreasingContinuousSubsequence.longestIncreasingContinuousSubsequenceII(
        new int[][]{
            {3}
        }));
    log.info("result 3 v.s. " + No397_LongestIncreasingContinuousSubsequence.longestIncreasingContinuousSubsequenceII(
        new int[][]{
            {1, 2},
            {3, 5}
        }));
    log.info("result 25 v.s. " + No397_LongestIncreasingContinuousSubsequence.longestIncreasingContinuousSubsequenceII(
        new int[][]{
            {1, 2, 3, 4, 5},
            {16, 17, 24, 23, 6},
            {15, 18, 25, 22, 7},
            {14, 19, 20, 21, 8},
            {13, 12, 11, 10, 9}
        }));
  }

  /**
   * @param A an array of Integer
   * @return an integer
   */
  int longestIncreasingContinuousSubsequenceII(int[][] A) {
    // filter abnormal cases
    if (A == null || A.length == 0 || A[0].length == 0) {
      return 0;
    }

    int m = A.length;
    int n = A[0].length;
    int max = 0;
    map.clear();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        max = Math.max(max, helper(i, j, A));
      }
    }
//        log.debug(map);
    return max;
  }

  HashMap<Long, Integer> map = new HashMap<>();

  long convert(int i, int j, int[][] A) {
    return (long) i * A[0].length + j;
  }

  int helper(int i, int j, int[][] A) {
    long key = convert(i, j, A);
    if (map.containsKey(key)) {
      return map.get(key);
    }

    int answer = 0;
    if (i - 1 >= 0 && A[i - 1][j] < A[i][j]) {
      answer = Math.max(answer, helper(i - 1, j, A));
    }
    if (i + 1 < A.length && A[i + 1][j] < A[i][j]) {
      answer = Math.max(answer, helper(i + 1, j, A));
    }
    if (j - 1 >= 0 && A[i][j - 1] < A[i][j]) {
      answer = Math.max(answer, helper(i, j - 1, A));
    }
    if (j + 1 < A[0].length && A[i][j + 1] < A[i][j]) {
      answer = Math.max(answer, helper(i, j + 1, A));
    }
    answer++;

    map.put(key, answer);
    return answer;
  }

  boolean isValid(int i, int j, int[][] A) {
    return i >= 0 && i < A.length && j >= 0 && j < A[0].length;
  }

}
