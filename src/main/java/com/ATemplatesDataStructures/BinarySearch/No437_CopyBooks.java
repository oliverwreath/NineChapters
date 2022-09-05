package com.ATemplatesDataStructures.BinarySearch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No437_CopyBooks {
  public static void main(String[] args) {
    testNo141_SqrtX();
  }

  private static void testNo141_SqrtX() {
    No437_CopyBooks No141_SqrtX = new No437_CopyBooks();
    log.info("result 5 v.s. " + No141_SqrtX.copyBooks(new int[]{3, 2, 4}, 2));
    log.info("result 10 v.s. " + No141_SqrtX.copyBooks(new int[]{5, 5, 4, 3, 2, 1}, 2));
  }

  public int copyBooks(int[] pages, int k) {
    if (pages == null || pages.length == 0) {
      return 0;
    }

    int start = pages[0];
    int end = 0;
    for (int page : pages) {
      start = Math.max(start, page);
      end += page;
    }

    while (start + 1 < end) {
      int mid = ((end - start) >> 1) + start;
      if (!isValid(mid, pages, k)) {
        start = mid;
      } else {
        end = mid;
      }
    }

    if (isValid(start, pages, k)) {
      return start;
    }
    if (isValid(end, pages, k)) {
      return end;
    }
    return 0;
  }

  boolean isValid(int quota, int[] pages, int k) {
    int remain = quota;
    for (int page : pages) {
      if (remain < page) {
        remain = quota;
        k--;
        if (k < 1) {
          return false;
        }
      }
      remain -= page;
    }
    return k >= 1;
  }

}
