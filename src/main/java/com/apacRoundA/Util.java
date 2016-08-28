package com.apacRoundA;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import com.google.common.base.Throwables;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli_000 on 16/7/8.
 */
public class Util {
    private final static Logger logger = LoggerFactory.getLogger(Util.class);

    public static void main(String[] args) {
        new Util().test1DTrappingWater();
    }

    private void test1DTrappingWater() {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        logger.info("a = {}", Arrays.toString(heights));

        int[] b = oneDTrappingWater(heights);
        logger.info("b = {}", Arrays.toString(b));
//        int diff = 0;
//        for (int i = 0; i < heights.length; i++) {
//            diff += (b[i] - heights[i]);
//        }
//        logger.info("diff = {}", diff);
    }

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

//        logger.info("oneDTrappingWater begin");
        int leftFirstPeak = findLeftFirstPeak(heights, 0, heights.length - 1);
//        logger.info("leftFirstPeak = {}, heights[{}] = {}", leftFirstPeak, leftFirstPeak, heights[leftFirstPeak]);

        int[] b = new int[heights.length];
        System.arraycopy(heights, 0, b, 0, heights.length);

        computeLeftHalf(heights, 0, leftFirstPeak, b);
        computeRightHalf(heights, leftFirstPeak, heights.length - 1, b);
        return b;
    }

    private static void computeLeftHalf(int[] a, int left, int right, int[] b) {
//        logger.info("computeLeftHalf begin");
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
//            logger.info("b = {}", Arrays.toString(b));

            if (leftFirstPeak == 0) {
                break;
            }

            right = leftFirstPeak;
        }

        return;
    }

    private static void computeRightHalf(int[] a, int left, int right, int[] b) {
//        logger.info("computeRightHalf begin");
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
//            logger.info("b = {}", Arrays.toString(b));

            if (rightFirstPeak == a.length - 1) {
                break;
            }

            left = rightFirstPeak;
        }

        return;
    }

    private static int findLeftFirstPeak(int[] a, int left, int right) {
//        logger.info("findLeftFirstPeak begin");
        int ret = right;
        int max = a[right];
        for (int i = right - 1; i >= left; i--) {
            if (a[i] > max) {
                ret = i;
                max = a[i];
            }
        }

//        logger.info("a = {}, left = {}, right = {}, ret = {}, a[{}] = {}", Arrays.toString(a), left, right, ret, ret, a[ret]);
        return ret;
    }

    private static int findRightFirstPeak(int[] a, int left, int right) {
//        logger.info("findRightFirstPeak begin");
        int ret = left;
        int max = a[left];
        for (int i = left + 1; i <= right; i++) {
            if (a[i] > max) {
                ret = i;
                max = a[i];
            }
        }

//        logger.info("a = {}, left = {}, right = {}, ret = {}, a[{}] = {}", Arrays.toString(a), left, right, ret, ret, a[ret]);
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
            System.out.println();
        }
    }

    public void testLeaderRanking() {
        ArrayList<LeaderEntry> leaderEntries = new ArrayList<LeaderEntry>();
        leaderEntries.add(new LeaderEntry("ADAM"));
        leaderEntries.add(new LeaderEntry("BOB"));
        leaderEntries.add(new LeaderEntry("JOHNSON"));
        logger.info("before sort = {}", leaderEntries);
        Collections.sort(leaderEntries);
        logger.info("after sort = {}", leaderEntries);
    }

    public void testLeaderRanking2() {
        ArrayList<LeaderEntry> leaderEntries = new ArrayList<LeaderEntry>();
        leaderEntries.add(new LeaderEntry("A AB C"));
        leaderEntries.add(new LeaderEntry("DEF"));
        logger.info("before sort = {}", leaderEntries);
        Collections.sort(leaderEntries);
        logger.info("after sort = {}", leaderEntries);
    }

    public void testLeaderRanking3() {
        ArrayList<LeaderEntry> leaderEntries = new ArrayList<LeaderEntry>();
        leaderEntries.add(new LeaderEntry("ADAM"));
        leaderEntries.add(new LeaderEntry("BOB"));
        leaderEntries.add(new LeaderEntry("JOHNSON"));
        leaderEntries.add(new LeaderEntry("A AB C"));
        leaderEntries.add(new LeaderEntry("DEF"));
        logger.info("before sort = {}", leaderEntries);
        Collections.sort(leaderEntries);
        logger.info("after sort = {}", leaderEntries);
    }

    public void testGetDistinctAlphabetCount() {
        System.out.println(new LeaderEntry("ADAM"));
        System.out.println(new LeaderEntry("BOB"));
        System.out.println(new LeaderEntry("JOHNSON"));
        System.out.println(new LeaderEntry("A AB C"));
        System.out.println(new LeaderEntry("DEF"));
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
                file.createNewFile();
            } catch (Exception ex) {
                logger.error(Throwables.getStackTraceAsString(ex));
            }
        }

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException ex) {
            logger.error(Throwables.getStackTraceAsString(ex));
        }
        return writer;
    }
}
