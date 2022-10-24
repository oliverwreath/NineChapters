package com.GoogleAPAC.RoundA;

import com.google.common.base.Throwables;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by yanli_000 on 16/7/8.
 */
@Slf4j
public class Util {
//    public int trapRainWater(int[] heights) {
//        if (heights == null || heights.length < 2) {
//            return 0;
//        }
//
//        int[] b = new int[heights.length];
//        System.arraycopy(heights, 0, b, 0, heights.length);
//        oneDTrappingWater(heights, b);
//        int diff = 0;
//        for (int i = 0; i < heights.length; i++) {
//            diff += (b[i] - heights[i]);
//        }
//        return diff;
//    }

  public static int[] oneDTrappingWater(int[] heights) {
    if (heights == null || heights.length < 2) {
      return heights;
    }

//        log.info("oneDTrappingWater begin");
    int leftFirstPeak = findLeftFirstPeak(heights, 0, heights.length - 1);
//        log.info("leftFirstPeak = {}, heights[{}] = {}", leftFirstPeak, leftFirstPeak, heights[leftFirstPeak]);

    int[] b = new int[heights.length];
    System.arraycopy(heights, 0, b, 0, heights.length);

    computeLeftHalf(heights, 0, leftFirstPeak, b);
    computeRightHalf(heights, leftFirstPeak, heights.length - 1, b);
    return b;
  }

  private static void computeLeftHalf(int[] a, int left, int right, int[] b) {
//        log.info("computeLeftHalf begin");
    int leftFirstPeak;
    while (true) {
      if (left > right - 1) {
        break;
      }
      leftFirstPeak = findLeftFirstPeak(a, left, right - 1);
      int minPeak = Math.min(a[leftFirstPeak], a[right]);
      for (int i = leftFirstPeak + 1; i < right; i++) {
        b[i] = minPeak;
      }
//            log.info("b = {}", Arrays.toString(b));

      if (leftFirstPeak == 0) {
        break;
      }

      right = leftFirstPeak;
    }

    return;
  }

  private static void computeRightHalf(int[] a, int left, int right, int[] b) {
//        log.info("computeRightHalf begin");
    int rightFirstPeak;
    while (true) {
      if (left + 1 > right) {
        break;
      }
      rightFirstPeak = findRightFirstPeak(a, left + 1, right);
      int minPeak = Math.min(a[left], a[rightFirstPeak]);
      for (int i = left + 1; i < rightFirstPeak; i++) {
        b[i] = minPeak;
      }
//            log.info("b = {}", Arrays.toString(b));

      if (rightFirstPeak == a.length - 1) {
        break;
      }

      left = rightFirstPeak;
    }

    return;
  }

  private static int findLeftFirstPeak(int[] a, int left, int right) {
//        log.info("findLeftFirstPeak begin");
    int ret = right;
    int max = a[right];
    for (int i = right - 1; i >= left; i--) {
      if (a[i] > max) {
        ret = i;
        max = a[i];
      }
    }

//        log.info("a = {}, left = {}, right = {}, ret = {}, a[{}] = {}", Arrays.toString(a), left, right, ret, ret, a[ret]);
    return ret;
  }

  private static int findRightFirstPeak(int[] a, int left, int right) {
//        log.info("findRightFirstPeak begin");
    int ret = left;
    int max = a[left];
    for (int i = left + 1; i <= right; i++) {
      if (a[i] > max) {
        ret = i;
        max = a[i];
      }
    }

//        log.info("a = {}, left = {}, right = {}, ret = {}, a[{}] = {}", Arrays.toString(a), left, right, ret, ret, a[ret]);
    return ret;
  }

  public static class LeaderEntry implements Comparable {

    String name;
    int distinctCount;

    public LeaderEntry(String name) {
      this.name = name;
      this.distinctCount = getDistinctAlphabetCount(name);
    }

    public LeaderEntry(String name, int distinctCount) {
      this.name = name;
      this.distinctCount = distinctCount;
    }

    @Override
    public String toString() {
      return name;
    }

//        @Override
//        public String toString() {
//            return "LeaderEntry{" +
//                    "name='" + name + '\'' +
//                    ", distinctCount=" + distinctCount +
//                    '}';
//        }

    public int compareTo(Object o) {
      if (o == null) {
        return 0;
      }
      if (o instanceof LeaderEntry) {
        LeaderEntry anotherLeaderEntry = (LeaderEntry) o;
        if (this.distinctCount == anotherLeaderEntry.distinctCount) {
          return this.name.compareTo(anotherLeaderEntry.name);
        } else {
          return anotherLeaderEntry.distinctCount - this.distinctCount;
        }
      } else {
        return 0;
      }
    }
  }

  public static void printArray(int[][] H, int R, int C) {
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        System.out.print(H[i][j] + " ");
      }
      log.debug("");
    }
  }

  public static int getDistinctAlphabetCount(String name) {
    if (StringUtils.isBlank(name)) {
      return 0;
    }

    int len = name.length();
    HashSet<Character> tmpSet = new HashSet<Character>();
    for (int i = 0; i < len; i++) {
      char oneChar = name.charAt(i);
      if (oneChar != ' ') {
        tmpSet.add(oneChar);
      }
    }

    return tmpSet.size();
  }

  public static PrintWriter getPrintWriter(String filePath) {
    File file = new File(filePath);
    if (!file.exists() || file.isDirectory()) {
      try {
        boolean isCreated = file.createNewFile();
        if (!isCreated)
          log.error("file created fail!");
      } catch (Exception ex) {
        log.error(Throwables.getStackTraceAsString(ex));
      }
    }

    PrintWriter writer = null;
    try {
      writer = new PrintWriter(file);
    } catch (FileNotFoundException ex) {
      log.error(Throwables.getStackTraceAsString(ex));
    }
    return writer;
  }
}
