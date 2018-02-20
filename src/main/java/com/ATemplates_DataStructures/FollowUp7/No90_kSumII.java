package com.ATemplates_DataStructures.FollowUp7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class No90_kSumII {
    private final static Logger logger = LoggerFactory.getLogger(No90_kSumII.class);

    public static void main(String[] args) {
        No90_kSumII No90_kSumII = new No90_kSumII();
        No90_kSumII.testNo90_kSumII();
    }

    private void testNo90_kSumII() {
        MyLogger.info("result [[1,4],[2,3]] v.s. " + kSumII(new int[]{1, 2, 3, 4}, 2, 5));
        MyLogger.info("result [[4]] v.s. " + kSumII(new int[]{1, 2, 3, 4}, 1, 4));
    }

    public List<List<Integer>> kSumII(int[] A, int K, int target) {
        // filter abnormal cases
        answer = new ArrayList<>();
        if (A == null || A.length == 0) {
            return answer;
        }

        this.tans = new ArrayList<>();
        this.A = A;
        dfs(K, target, A.length - 1);

        // return the final result
        return answer;
    }

    List<List<Integer>> answer;
    List<Integer> tans;
    int A[];

    public void dfs(int K, int target, int index) {
        if (K == 0 && target == 0) {
            answer.add(new ArrayList<>(tans));
            return;
        }
        if (K < 0 || target < 0 || index < 0) {
            return;
        }

        dfs(K, target, index - 1);
        tans.add(A[index]);
        dfs(K - 1, target - A[index], index - 1);
        tans.remove(tans.size() - 1);
    }

//    public void dfs(int A[], int K, int target, int index, List<Integer> tans) {
//        if (K == 0 && target == 0) {
//            answer.add(new ArrayList<>(tans));
//            return;
//        }
//        if (K < 0 || target < 0 || index < 0)
//            return;
//        dfs(A, K, target, index - 1, tans);
//        tans.add(A[index]);
//        dfs(A, K - 1, target - A[index], index - 1, tans);
//        tans.remove(tans.size() - 1);
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
