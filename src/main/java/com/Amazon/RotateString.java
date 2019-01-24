package com.Amazon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-19.
 */
public class RotateString {
    private final static Logger logger = LoggerFactory.getLogger(RotateString.class);

    public static void main(String[] arg) {
        new RotateString().testRotateString();
    }

    private void testRotateString() {
        logger.info("{}", isRotation("abc", "abc"));
        logger.info("{}", isRotation("abc", "cab"));
        logger.info("{}", isRotation("abc", "bca"));
        logger.info("{}", isRotation("ab", "aa"));
    }

    public static boolean isRotation(String s1, String s2) {
        // write your code here
        // handle extreme cases
        if (s1 == null || s1.length() == 0) {
            if (s2 == null || s2.length() == 0) {
                return true;
            } else {
                return false;
            }
        }

        int len = s1.length();
        myLogger.info("len = " + len);
        for (int offset = 1; offset <= len; offset++) {
            boolean isRotated = true;
            for (int i = 0; i < len; i++) {
                if (s1.charAt(i) != s2.charAt((i + offset) % len)) {
                    isRotated = false;
                    break;
                }
            }
            myLogger.info("offset = " + offset + "; isRotated = " + isRotated);
//            if (isRotated) {
//                return true;
//            }
        }

        return false;
    }

    private static MyTmpLogger myLogger = new MyTmpLogger();

    private static class MyTmpLogger {
        public boolean isLogging = true;

        public MyTmpLogger() {
        }

        public void info(Object o) {
            if (isLogging) {
                System.out.println(o);
            }
        }
    }
}
