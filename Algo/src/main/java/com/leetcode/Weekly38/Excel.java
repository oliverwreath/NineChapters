package com.leetcode.Weekly38;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class Excel {

  public static void main(String[] args) {
    Excel excel = new Excel(3, 'C');
  }

  boolean[][] isSum = new boolean[26][26];
  Entry[][] table = new Entry[26][26];
  int maxX = 0;
  int maxY = 0;

  class Entry {

    int val = 0;
    String[] strings;

    public Entry(int val) {
      this.val = val;
    }

    public Entry(String[] strings) {
      this.strings = strings;
    }
  }

  public Excel(int H, char W) {
    table = new Entry[26][26];
    maxX = H - 1;
    maxY = W - 'A';
  }

  public boolean isValid(int x, int y) {
    return x >= 0 && y >= 0 && x <= maxX && y <= maxY;
  }

  public void set(int r, char c, int v) {
    int x = r - 1;
    int y = c - 'A';
    if (isValid(x, y)) {
      isSum[x][y] = false;
      table[x][y].val = v;
    }
  }

  public int get(int r, char c) {
    int x = r - 1;
    int y = c - 'A';
    if (isSum[x][y]) {
      String[] strings = table[x][y].strings;

    } else {
      return table[x][y].val;
    }

    return -1;
  }

  public int getSum(String[] strings) {
    int sum = 0;
    for (int i = 0; i < strings.length; i++) {
      if (strings[i].contains(":")) {
        String[] split = strings[i].split(":");
        int xx = split[0].charAt(1) - 1;
        int yy = split[0].charAt(0) - 'A';
        int xxx = split[1].charAt(1) - 1;
        int yyy = split[1].charAt(0) - 'A';
        for (int ii = xx; ii <= xxx; ii++) {
          for (int jj = yy; jj <= yyy; jj++) {

          }
        }
      } else {
        int xx = strings[i].charAt(1) - 1;
        int yy = strings[i].charAt(0) - 'A';
        if (isValid(xx, yy)) {
          if (isSum[xx][yy]) {
            sum += getSum(Arrays.copyOfRange(strings, i + 1, strings.length));
          } else {
            sum += table[xx][yy].val;
          }
        }
      }
    }

    return -1;
  }

//    public int getSingleSum(String string) {
//        int sum = 0;
//        if (string.contains(":")) {
//            // area
//
//        } else {
//            // single cell
//            int xx = string.charAt(1) - 1;
//            int yy = string.charAt(0) - 'A';
//            if (isValid(xx, yy)) {
//                if (isSum[xx][yy]) {
//                    sum += getSingleSum(strings);
//                } else {
//                    sum += table[xx][yy].val;
//                }
//            }
//        }
//    }

  public int sum(int r, char c, String[] strs) {
    int x = r - 1;
    int y = c - 'A';
    if (isValid(x, y)) {
      isSum[x][y] = true;
//            table[x][y].val = ;
      table[x][y].strings = strs;
    }

    return -1;
  }

}
