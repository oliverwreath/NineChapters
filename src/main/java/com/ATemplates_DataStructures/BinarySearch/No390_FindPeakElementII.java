package com.ATemplates_DataStructures.BinarySearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class No390_FindPeakElementII {
    private final static Logger logger = LoggerFactory.getLogger(No390_FindPeakElementII.class);

    public static void main(String[] args) {
        testNo390_FindPeakElementII();
    }

    private static void testNo390_FindPeakElementII() {
        No390_FindPeakElementII No390_FindPeakElementII = new No390_FindPeakElementII();
        MyLogger.info("result [1,1] || [2,2] v.s. " + No390_FindPeakElementII.findPeakII(new int[][]{
                {1, 2, 3, 6, 5},
                {16, 41, 23, 22, 6},
                {15, 17, 24, 21, 7},
                {14, 18, 19, 20, 10},
                {13, 14, 11, 10, 9}
        }));
    }

    public List<Integer> findPeakII(int[][] A) {
        // write your code here
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
        int max = A[midRow][left];
        int maxX = midRow;
        int maxY = left;
        for (int j = left + 1; j <= right; j++) {
            if (A[midRow][j] > max) {
                max = A[midRow][j];
                maxX = midRow;
                maxY = j;
            }
        }

        int midCol = (left + right) >> 1;
        for (int i = up; i <= down; i++) {
            if (A[i][midCol] > max) {
                max = A[i][midCol];
                maxX = i;
                maxY = midCol;
            }
        }

        if (maxX == midRow && maxY == midCol) {
            return Arrays.asList(maxX, maxY);
        } else if (isPeak(maxX, maxY, A)) {
            return Arrays.asList(maxX, maxY);
        } else {
            int newUp = maxX < midRow ? up : midRow + 1;
            int newDown = maxX < midRow ? midRow - 1 : down;
            int newLeft = maxY < midCol ? left : midCol + 1;
            int newRight = maxY < midCol ? midCol - 1 : right;
            if (maxX == midRow) {
                int x = maxX + 1;
                int y = maxY;
                if (x <= down && A[x][y] > A[maxX][maxY]) {
                    return findPeakIIHelper(newUp, newDown, newLeft, newRight, A);
                }
                x = maxX - 1;
                if (x >= up && A[x][y] > A[maxX][maxY]) {
                    return findPeakIIHelper(newUp, newDown, newLeft, newRight, A);
                }
            } else {
                int x = maxX;
                int y = maxY + 1;
                if (y <= right && A[x][y] > A[maxX][maxY]) {
                    return findPeakIIHelper(newUp, newDown, newLeft, newRight, A);
                }
                y = maxY - 1;
                if (y >= left && A[x][y] > A[maxX][maxY]) {
                    return findPeakIIHelper(newUp, newDown, newLeft, newRight, A);
                }
            }
        }

        return Arrays.asList(-1, -1);
    }

    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0,};

    public boolean isPeak(int x, int y, int[][] A) {
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (A[x][y] < A[xx][yy]) {
                return false;
            }
        }

        return true;
    }

    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
