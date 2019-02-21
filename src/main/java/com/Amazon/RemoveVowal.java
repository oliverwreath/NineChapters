package com.Amazon;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-19.
 */
public class RemoveVowal {
    private static final Logger logger = LoggerFactory.getLogger(RemoveVowal.class);

    public static void main(String[] arg) {
        new RemoveVowal().testGrayCode_89();
    }

    private void testGrayCode_89() {
//        logger.info("{}", binaryString2Int("00"));
//        logger.info("{}", binaryString2Int("01"));
//        logger.info("{}", binaryString2Int("11"));
//        logger.info("{}", binaryString2Int("10"));
//
//        logger.info("{}", binaryString2Int("000"));
//        logger.info("{}", binaryString2Int("001"));
//        logger.info("{}", binaryString2Int("011"));
//        logger.info("{}", binaryString2Int("010"));
//
//        logger.info("{}", binaryString2Int("110"));
//        logger.info("{}", binaryString2Int("111"));
//        logger.info("{}", binaryString2Int("101"));
//        logger.info("{}", binaryString2Int("100"));
//
//        for (int i = -1; i < 6; i++) {
//
//        }
        String string = "abdhfgebsa";
        logger.info("removeVowal({}) = {}", string, removeVowal(string));

    }

    private static String v = "aeiouAEIOU";
    private static HashSet<Character> set = new HashSet<Character>();

    static {
        int n = v.length();
        for (int i = 0; i < n; i++) {
            set.add(v.charAt(i));
        }
    }

    /**
     * @param string
     * @return
     */
    public String removeVowal(String string) {
        // write your code here
        // handle extreme cases
        if (string == null || string.length() == 0) {
            return string;
        }

        // fill the ans
        StringBuilder stringBuilder = new StringBuilder();
        int n = string.length();
        for (int i = 0; i < n; i++) {
            if (!set.contains(string.charAt(i))) {
                stringBuilder.append(string.charAt(i));
            }
        }

        return stringBuilder.toString();
    }

    private static MyTmpLogger myLogger = new MyTmpLogger();

    private static class MyTmpLogger {
        public boolean isLogging = false;

        public MyTmpLogger() {
        }

        public void info(Object o) {
            if (isLogging) {
                System.out.println(o);
            }
        }
    }
}
