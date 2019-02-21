package com.LintCodeContest.Weekly13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class No969_LongestRepeatingSubsequenceII {
    private static final Logger logger = LoggerFactory.getLogger(No969_LongestRepeatingSubsequenceII.class);

    public static void main(String[] args) {
        No969_LongestRepeatingSubsequenceII No969_LongestRepeatingSubsequenceII = new No969_LongestRepeatingSubsequenceII();
        No969_LongestRepeatingSubsequenceII.testNo969_LongestRepeatingSubsequenceII();
    }

    private void testNo969_LongestRepeatingSubsequenceII() {
        MyLogger.info("result 2 v.s. " + longestRepeatingSubsequenceII("aaa", 2));
        MyLogger.info("result 6 v.s. " + longestRepeatingSubsequenceII("aabcbcbcbc", 2));
    }

    int longestRepeatingSubsequenceII(String str, int k) {
        // filter abnormal cases
        if (str == null || str.length() == 0) {
            return 0;
        }//

        HashMap<String, Integer> map = new HashMap<>();
        int len = str.length();
        int maxLength = 0;
        for (int i = 0; i < len; i++) {
//            if (maxLength != 0) {
//                System.out.println("maxLength = " + maxLength);
//            }
            for (int j = len; j > Math.max(i, i + maxLength - 1); j--) {
                String key = str.substring(i, j);
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    map.put(key, map.get(key) + 1);
                }
                if(map.get(key) >= k) {
                    maxLength = Math.max(maxLength, str.length());
                }
            }
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if (stringIntegerEntry.getValue() >= k) {
                maxLength = Math.max(maxLength, stringIntegerEntry.getKey().length());
            }
        }

        // return the final result
        return maxLength;
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
