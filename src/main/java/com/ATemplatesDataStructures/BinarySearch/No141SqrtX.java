package com.ATemplatesDataStructures.BinarySearch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No141SqrtX {
  public int sqrt(int x) {
    // filter abnormal cases
    if (x < 0) {
      return 0;
    }

    int start = 0;
    int end = x;
    while (start + 1 < end) {
      int mid = ((end - start) >> 1) + start;
      if ((long) mid * mid > x) {
        end = mid;
      } else {
        start = mid;
      }
    }

    if ((long) end * end > x) {
      return start;
    } else {
      return end;
    }
  }

}
