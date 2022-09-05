package com.lintcode.DataStructures;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Author: Oliver
 */
@Slf4j
public class MergekSortedArrays {
  public static void main(String[] arg) {
    new MergekSortedArrays().testMergekSortedArrays();
  }

  private void testMergekSortedArrays() {
    int[][] arrays = new int[][]{{1, 3, 5, 7},
            {2, 4, 6},
            {0, 8, 9, 10, 11}};
    log.info("{}", mergekSortedArrays(arrays));
  }

  private Comparator<Element> elementComparator = new Comparator<Element>() {
    public int compare(Element o1, Element o2) {
      return o1.val - o2.val;
    }
  };

  /**
   * @param arrays k sorted integer arrays
   * @return a sorted array
   */
  List<Integer> mergekSortedArrays(int[][] arrays) {

    if (arrays == null || arrays.length == 0) {
      return new ArrayList<Integer>(0);
    }
    int K = arrays.length;
    PriorityQueue<Element> queue = new PriorityQueue<Element>(K, elementComparator);
    int totalLength = 0;
    for (int i = 0; i < K; i++) {
      if (arrays[i] != null && arrays[i].length > 0) {
        queue.add(new Element(i, 0, arrays[i][0]));
        totalLength += arrays[i].length;
      }
    }
    List<Integer> resultList = new ArrayList<Integer>(totalLength);
    int i = 0;
    while (!queue.isEmpty()) {
      Element tmp = queue.poll();
      resultList.add(tmp.val);
      if (tmp.col < arrays[tmp.row].length - 1) {
        tmp.col++;
        tmp.val = arrays[tmp.row][tmp.col];
        queue.add(tmp);
      }
    }

    return resultList;
  }

  private class Element {
    int row;
    int col;
    int val;

    public Element(int row, int col, int val) {
      this.row = row;
      this.col = col;
      this.val = val;
    }

    @Override
    public String toString() {
      return "Element{" +
              "row=" + row +
              ", col=" + col +
              ", val=" + val +
              '}';
    }
  }
}
