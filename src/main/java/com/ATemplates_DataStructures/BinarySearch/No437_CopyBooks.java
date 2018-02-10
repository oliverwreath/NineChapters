package com.ATemplates_DataStructures.BinarySearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No437_CopyBooks {
    private final static Logger logger = LoggerFactory.getLogger(No437_CopyBooks.class);

    public static void main(String[] args) {
        testNo141_SqrtX();
    }

    private static void testNo141_SqrtX() {
        No437_CopyBooks No141_SqrtX = new No437_CopyBooks();
        MyLogger.info("result 5 v.s. " + No141_SqrtX.copyBooks(new int[]{3, 2, 4}, 2));
        MyLogger.info("result 10 v.s. " + No141_SqrtX.copyBooks(new int[]{5, 5, 4, 3, 2, 1}, 2));
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
