package com.LintCodeContest.Weekly;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class No792_KthPrimenumber{
    private static final Logger logger = LoggerFactory.getLogger(No792_KthPrimenumber.class);

    public static void main(String[] args) {
        testNo790_Parser();
    }

    private static void testNo790_Parser() {
        No792_KthPrimenumber No792_KthPrimenumber = new No792_KthPrimenumber();
        MyLogger.info("result 2 v.s. " + No792_KthPrimenumber.kthPrime(3));
        MyLogger.info("result 5 v.s. " + No792_KthPrimenumber.kthPrime(11));
    }

    public int kthPrime(int target) {
        // write your code here
        if (target < 2) {
            return 0;
        }

        if (map == null) {
            map = new HashMap<>();
            HashSet<Integer> setNotPrime = new HashSet<>();
            List<Integer> primes = new LinkedList<>();
            for (int i = 2; i <= 100000; i++) {
                if (!setNotPrime.contains(i)) {
                    primes.add(i);
                    int num = i + i;
                    while (num <= 100000) {
                        setNotPrime.add(num);
                        num += i;
                    }
                }
            }

            int count = 1;
            for (Integer num : primes) {
                map.put(num, count++);
            }
        }

        return map.get(target);
    }

    private HashMap<Integer, Integer> map;

//    /**
//     * @param A an array of Integer
//     * @return an integer
//     */
//    public boolean canBeGenerated(String[] generator, char startSymbol, String symbolString) {
//        // Write your code here.
//        if (A == null || A.length == 0) {
//            return 0;
//        }
//
//        // return the final result
//        return -1;
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
