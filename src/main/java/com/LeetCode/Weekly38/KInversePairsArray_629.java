package com.LeetCode.Weekly38;

/**
 * Created by yanli on 2017-06-24.
 */
public class KInversePairsArray_629 {
    public static void main(String[] args) {
        KInversePairsArray_629 kInversePairsArray_629 = new KInversePairsArray_629();
        MyLogger.debug("result = 1 = " + kInversePairsArray_629.kInversePairs(3, 0));
        MyLogger.debug("result = 1 = " + kInversePairsArray_629.kInversePairs(3, 1));
    }

    public int kInversePairs(int n, int k) {
        if (n == 1) {
            if (k == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (n == 2) {
            if (k == 0) {
                return 1;
            } else if (k == 1) {
                return 1;
            } else {
                return 0;
            }
        }
//        3
//        0 1
//        1 2
//        2 2
//        3 1

//        4 4 * 3 * 2
//        0 1
//        1 3
//        2
//        3
//        4
//        5 3
//        6 1

        return -1;
    }


    private static class MyLogger {
        static boolean isDebugging = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
//109 + 7