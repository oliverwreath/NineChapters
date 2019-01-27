package com.NineChapters.TwoPointers.MustHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class Two_sum_iii_data_structure_design_607 {
    private final static Logger logger = LoggerFactory.getLogger(Two_sum_iii_data_structure_design_607.class);

    public static void main(String[] args) {
        testtwo_sum_iii_data_structure_design_607();
    }

    private static void testtwo_sum_iii_data_structure_design_607() {
        TwoSum twoSum = new TwoSum();
        twoSum.add(1);
        twoSum.add(3);
        twoSum.add(5);
        logger.info("result true v.s. {}", twoSum.find(4));
        logger.info("result false v.s. {}", twoSum.find(7));

        twoSum = new TwoSum();
        twoSum.add(2);
        twoSum.add(3);
        logger.info("result false v.s. {}", twoSum.find(4));
        logger.info("result true v.s. {}", twoSum.find(5));
        logger.info("result false v.s. {}", twoSum.find(6));
        twoSum.add(3);
        logger.info("result true v.s. {}", twoSum.find(6));
    }

    public static class TwoSum {
        //        private LinkedList<Long> list = new LinkedList<>();
        private HashMap<Integer, Boolean> hashMap;

        public TwoSum() {
            hashMap = new HashMap<>();
        }

        /**
         * @param key: An integer
         * @return: nothing
         */
        public void add(int key) {
            // write your code here
            if (hashMap.containsKey(key)) {
                hashMap.put(key, true);
            } else {
                hashMap.put(key, false);
            }
        }

        /**
         * @param sum: An integer
         * @return: Find if there exists any pair of numbers which sum is equal to the sum.
         */
        public boolean find(int sum) {
            // write your code here
            for (Integer key : hashMap.keySet()) {
                if (hashMap.containsKey(sum - key) && (sum != (key + key) || hashMap.get(key))) {
                    return true;
                }
            }
            return false;
        }
    }

    private static class MyLogger {
        private static final boolean isDebugging = false;
        private static final boolean isInfoing = true;
        private static final String DEBUG = "[DEBUG]";
        private static final String INFO = "[INFO]";

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println(DEBUG + " = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println(INFO + " = " + message);
            }
        }
    }
}
