package com.AJia.LeetCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-23.
 */
public class RotateFunction {
    private final static Logger logger = LoggerFactory.getLogger(RotateFunction.class);

    public static void main(String[] arg) {
        new RotateFunction().testRotateFunction();
    }

    private void testRotateFunction() {
        logger.info("{}", maxRotateFunction(new int[]{
                4, 3, 2, 6
        }));
    }

    public int maxRotateFunction(int[] A) {
        // write your code here
        // handle extreme cases
        if (A == null || A.length < 2) {
            return 0;
        }

        int n = A.length;
        // first
        int last = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            last += i * A[i];
            sum += A[i];
        }
        int maxF = last;
        myLogger.info(last);
        // rest
        for (int i = 1; i < n; i++) {
            int current = last + sum - n * A[n - i];
            maxF = Math.max(maxF, current);
            last = current;
            myLogger.info(current);
        }
        return maxF;
    }

    private MyTmpLogger myLogger = new MyTmpLogger();

    private class MyTmpLogger {
        public MyTmpLogger() {
        }

        public void info(Object o) {
            if (isLogging) {
                System.out.println(o);
            }
        }
    }

    public static boolean isLogging = false;

//    static {
//        isLogging = true;
//    }
}
