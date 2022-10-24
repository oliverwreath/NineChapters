package com.lintcode.BinarySearch1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class Lintcode460KClosestNumbers {

  public int[] kClosestNumbers(int[] nums, int target, int k) {

    if (nums == null || nums.length == 0) {
      return new int[0];
    }

    List<Entry> list = new ArrayList<>();
    for (int num : nums) {
      list.add(new Entry(num, Math.abs(num - target)));
    }
    Comparator<Entry> comparatorByDiff = (o1, o2) -> {
      if (o1.diff == o2.diff) {
        return o1.original - o2.original;
      } else {
        return o1.diff - o2.diff;
      }
    };
    list.sort(comparatorByDiff);
    int[] result = new int[k];
    int i = 0;
    for (Entry entry : list) {
      if (i >= k) {
        break;
      }
      result[i++] = entry.original;
    }

    return result;
  }

  private class Entry {

    int original = 0;
    int diff = 0;

    Entry(int original, int diff) {
      this.original = original;
      this.diff = diff;
    }
  }
}
//    Given A = [], target = 2 and k = 3, return [2, 1, 3].

//        Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].
