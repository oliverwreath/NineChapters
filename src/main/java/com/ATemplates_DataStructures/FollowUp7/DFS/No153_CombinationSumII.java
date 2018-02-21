package com.ATemplates_DataStructures.FollowUp7.DFS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No153_CombinationSumII {
    private final static Logger logger = LoggerFactory.getLogger(No153_CombinationSumII.class);

    public static void main(String[] args) {
        No153_CombinationSumII No153_CombinationSumII = new No153_CombinationSumII();
        No153_CombinationSumII.testNo153_CombinationSumII();
    }

    private void testNo153_CombinationSumII() {
        MyLogger.info("result [[1,7],[1,2,5],[2,6],[1,1,6]] v.s. " + combinationSum2(new int[]{10, 1, 6, 7, 2, 1, 5}, 8));
        MyLogger.info("result [[1,1,6],[1,2,5],[1,7],[2,6]] v.s. " + combinationSum2(new int[]{7, 1, 2, 5, 1, 6, 10}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] A, int target) {
        // filter abnormal cases
        answer = new ArrayList<>();
        if (A == null || A.length == 0) {
            return answer;
        }

        Arrays.sort(A);
        this.A = A;
        combinations = new ArrayList<>();
        dfs(target, 0);

        // return the final result
        return answer;
    }

    List<List<Integer>> answer;
    int[] A;
    List<Integer> combinations;

    void dfs(int target, int start) {
        if (target == 0) {
            answer.add(new ArrayList<>(combinations));
            return;
        }

        for (int i = start; i < A.length && target >= A[i]; i++) {
            if (i != start && A[i] == A[i - 1]) {
                continue;
            }
            combinations.add(A[i]);
            dfs(target - A[i], i + 1);
            combinations.remove(combinations.size() - 1);
        }

//        if (target < 0 || start > A.length - 1) {
//            return;
//        }
//        int newIndex = start;
//        while (newIndex < A.length - 1 && A[newIndex + 1] == A[newIndex]) {
//            newIndex++;
//        }
//        dfs(target, newIndex + 1);
//        combinations.add(A[start]);
//        dfs(target - A[start], start + 1);
//        combinations.remove(combinations.size() - 1);
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
