package com.lintcode.Advanced.TwoPointer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Author: Oliver
 */
@Slf4j
public class TwoSum {
  public static void main(String[] arg) {
    new TwoSum().testTwoSum();
  }

  private void testTwoSum() {
    log.info("{}", twoSum(new int[]{2, 7, 11, 15}, 9));
  }

  /*
   * @param numbers : An array of Integer
   * @param target : target = numbers[index1] + numbers[index2]
   * @return : [index1 + 1, index2 + 1] (index1 < index2)
   */
  public int[] twoSum(int[] numbers, int target) {

    if (numbers == null || numbers.length == 0) {
      return new int[0];
    }

    int n = numbers.length;
    ArrayList<Entry> entries = new ArrayList<Entry>(n);
    for (int i = 0; i < numbers.length; i++) {
      entries.add(new Entry(numbers[i], i));
    }
    int i = 0;
    int j = n - 1;
    Collections.sort(entries, entryComparator);
    while (i < j) {
      if (entries.get(i).val + entries.get(j).val < target) {
        i++;
      } else if (entries.get(i).val + entries.get(j).val > target) {
        j--;
      } else {
        int[] ans = {entries.get(i).x + 1, entries.get(j).x + 1};
        Arrays.sort(ans);
        return ans;
      }
    }

    return new int[0];
  }

  private Comparator<Entry> entryComparator = new Comparator<Entry>() {
    public int compare(Entry o1, Entry o2) {
      return o1.val - o2.val;
    }
  };

  private class Entry {
    int val;
    int x;

    public Entry(int val, int x) {
      this.val = val;
      this.x = x;
    }

    public Entry() {

    }

    @Override
    public String toString() {
      return "Entry{" +
              "val=" + val +
              ", x=" + x +
              '}';
    }
  }
}
