package com.ATemplates_DataStructures.DP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;

public class No622_FrogJump {
    private final static Logger logger = LoggerFactory.getLogger(No622_FrogJump.class);

    public static void main(String[] args) {
        No622_FrogJump No622_FrogJump = new No622_FrogJump();
        No622_FrogJump.testNo622_FrogJump();
    }

    private void testNo622_FrogJump() {
        MyLogger.info("result true v.s. " + canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        MyLogger.info("result false v.s. " + canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
    }

    boolean canCross(int[] stones) {
        // filter abnormal cases
        if (stones == null || stones.length == 0) {
            return true;
        }

        int len = stones.length;
        boolean[] dp = new boolean[len];
        ArrayList<HashSet<Integer>> ksList = new ArrayList<>(len + 1);
        for (int i = 0; i < len; i++) {
            ksList.add(new HashSet<>());
        }
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                dp[0] = true;
            } else {
                if (i == 1) {
                    if (stones[1] - stones[0] == 1) {
                        dp[1] = true;
                        ksList.get(1).add(1);
                    } else {
                        return false;
                    }
                }

                for (int to = i + 1; to < len; to++) {
                    int require = stones[to] - stones[i];
                    if (ksList.get(i).contains(require - 1) || ksList.get(i).contains(require) || ksList.get(i).contains(require + 1)) {
//                        System.out.println(i + " -> " + to + "; require = " + require);
                        dp[to] = true;
                        ksList.get(to).add(require);
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
//        for (int i = 0; i < len; i++) {
//            if (!ksList.get(i).isEmpty()) {
//                System.out.println("i = " + i + "; ksList.get(i) = " + ksList.get(i));
//            }
//        }

        // return the final result
        return dp[len - 1];
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
