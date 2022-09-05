package com.ATemplatesDataStructures.FindPeak;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class No390_FindPeakElementII {
  public static void main(String[] args) {
    testNo390_FindPeakElementII();
  }

  private static void testNo390_FindPeakElementII() {
    No390_FindPeakElementII No390_FindPeakElementII = new No390_FindPeakElementII();
    log.info("result [1,1] || [2,2] v.s. " + No390_FindPeakElementII.findPeakII(new int[][]{
            {1, 2, 3, 6, 5},
            {16, 41, 23, 22, 6},
            {15, 17, 24, 21, 7},
            {14, 18, 19, 20, 10},
            {13, 14, 11, 10, 9}
    }));
  }

  public List<Integer> findPeakII(int[][] A) {

    // filter abnormal cases
    if (A == null || A.length == 0 || A[0].length == 0) {
      return Arrays.asList(-1, -1);
    }

    int m = A.length;
    int n = A[0].length;
    return findPeakIIHelper(1, m - 2, 1, n - 2, A);
  }

  public List<Integer> findPeakIIHelper(int up, int down, int left, int right, int[][] A) {
    if (up > down || left > right) {
      return Arrays.asList(-1, -1);
    }

    int midRow = (up + down) >> 1;
    int midCol = (left + right) >> 1;
    int maxX = midRow;
    int maxY = midCol;
    int max = A[midRow][midCol];
    for (int j = left; j <= right; j++) {
      if (A[midRow][j] > max) {
        maxX = midRow;
        maxY = j;
        max = A[midRow][j];
      }
    }
    for (int i = up; i <= down; i++) {
      if (A[i][midCol] > max) {
        maxX = i;
        maxY = midCol;
        max = A[i][midCol];
      }
    }

    if (isPeak(maxX, maxY, max, A)) {
      return Arrays.asList(maxX, maxY);
    } else {
      if (maxX == midRow) {
        int newLeft = (maxY < midCol) ? left : midCol + 1;
        int newRight = (maxY < midCol) ? midCol - 1 : right;
        if (maxX - 1 >= up && A[maxX - 1][maxY] > max) {
          return findPeakIIHelper(up, midRow - 1, newLeft, newRight, A);
        }
        if (maxX + 1 <= down && A[maxX + 1][maxY] > max) {
          return findPeakIIHelper(midRow + 1, down, newLeft, newRight, A);
        }
      } else {
        int newUp = (maxX < midRow) ? up : midRow + 1;
        int newDown = (maxX < midRow) ? midRow - 1 : down;
        if (maxY - 1 >= left && A[maxX][maxY - 1] > max) {
          return findPeakIIHelper(newUp, newDown, left, midCol - 1, A);
        }
        if (maxY + 1 <= right && A[maxX][maxY + 1] > max) {
          return findPeakIIHelper(newUp, newDown, midCol + 1, right, A);
        }
      }
    }

    return Arrays.asList(-1, -1);
  }

  boolean isPeak(int maxX, int maxY, int max, int[][] A) {
    return max >= A[maxX - 1][maxY] && max >= A[maxX + 1][maxY] && max >= A[maxX][maxY - 1] && max >= A[maxX][maxY + 1];
  }

}
