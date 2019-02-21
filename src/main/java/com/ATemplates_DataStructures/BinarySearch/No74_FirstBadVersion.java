package com.ATemplates_DataStructures.BinarySearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No74_FirstBadVersion {
    private static final Logger logger = LoggerFactory.getLogger(No74_FirstBadVersion.class);

    public static void main(String[] args) {
        testNo141_SqrtX();
    }

    private static void testNo141_SqrtX() {
        No74_FirstBadVersion No141_SqrtX = new No74_FirstBadVersion();
//        MyLogger.info("result 0 v.s. " + No141_SqrtX.sqrt(0));
//        MyLogger.info("result 1 v.s. " + No141_SqrtX.sqrt(1));
//        MyLogger.info("result 1 v.s. " + No141_SqrtX.sqrt(2));
//        MyLogger.info("result 1 v.s. " + No141_SqrtX.sqrt(3));
//        MyLogger.info("result 2 v.s. " + No141_SqrtX.sqrt(4));
//        MyLogger.info("result 2 v.s. " + No141_SqrtX.sqrt(5));
//        MyLogger.info("result 3 v.s. " + No141_SqrtX.sqrt(10));
    }

//    public int findFirstBadVersion(int n) {
//        // filter abnormal cases
//        if (n < 0) {
//            return 0;
//        }
//
//        int start = 0;
//        int end = n;
//        while (start + 1 < end) {
//            int mid = ((end - start) >> 1) + start;
//            if (SVNRepo.isBadVersion(mid)) {
//                end = mid;
//            } else {
//                start = mid;
//            }
//        }
//
//        if (SVNRepo.isBadVersion(start)) {
//            return start;
//        } else {
//            return end;
//        }
//    }

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
