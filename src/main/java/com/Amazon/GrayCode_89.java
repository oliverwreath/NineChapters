package com.Amazon;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-19.
 */
public class GrayCode_89 {
    private final static Logger logger = LoggerFactory.getLogger(GrayCode_89.class);

    public static void main(String[] arg) {
        new GrayCode_89().testGrayCode_89();
    }

    private void testGrayCode_89() {
        logger.info("{}", binaryString2Int("00"));
        logger.info("{}", binaryString2Int("01"));
        logger.info("{}", binaryString2Int("11"));
        logger.info("{}", binaryString2Int("10"));

        logger.info("{}", binaryString2Int("000"));
        logger.info("{}", binaryString2Int("001"));
        logger.info("{}", binaryString2Int("011"));
        logger.info("{}", binaryString2Int("010"));

        logger.info("{}", binaryString2Int("110"));
        logger.info("{}", binaryString2Int("111"));
        logger.info("{}", binaryString2Int("101"));
        logger.info("{}", binaryString2Int("100"));

        for (int i = -1; i < 6; i++) {
            logger.info("grayCode({}) = {}", i, grayCode(i));
        }
    }

    /**
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        // write your code here
        // handle extreme cases
        if (n < 1) {
            LinkedList<Integer> ans = new LinkedList<Integer>();
            ans.add(0);
            return ans;
        }
        if (n == 1) {
            LinkedList<Integer> ans = new LinkedList<Integer>();
            ans.add(0);
            ans.add(1);
            return ans;
        }

        // fill the ans
        LinkedList<Integer> ans = new LinkedList<Integer>();
        int len = 4;
        String[] seeds = new String[]{"0", "1"};
        for (int t = 0; t < n - 1; t++) {
            String[] results = new String[len];
            int j = 0;
            for (int i = 0; i < seeds.length; i++, j++) {
                results[j] = '0' + seeds[i];
                myLogger.info("t = " + t + " fori: " + results[j]);
                if (t == n - 2) {
                    ans.add(binaryString2Int(results[j]));
                }
            }
            for (int i = seeds.length - 1; i >= 0; i--, j++) {
                results[j] = '1' + seeds[i];
                myLogger.info("t = " + t + " forr: " + results[j]);
                if (t == n - 2) {
                    ans.add(binaryString2Int(results[j]));
                }
            }
            len *= 2;
            seeds = results;
        }

        return ans;
    }

    private static int binaryString2Int(String binaryString) {
        int n = binaryString.length();
        if (n < 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans *= 2;
            ans += binaryString.charAt(i) - '0';
        }
        return ans;
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
