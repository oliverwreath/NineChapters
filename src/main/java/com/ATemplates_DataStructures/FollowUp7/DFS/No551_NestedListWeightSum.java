package com.ATemplates_DataStructures.FollowUp7.DFS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * plain old dfs, nice practice
 */
public class No551_NestedListWeightSum {
    private final static Logger logger = LoggerFactory.getLogger(No551_NestedListWeightSum.class);

    public static void main(String[] args) {
        No551_NestedListWeightSum No551_NestedListWeightSum = new No551_NestedListWeightSum();
        No551_NestedListWeightSum.testNo551_NestedListWeightSum();
    }

    private void testNo551_NestedListWeightSum() {
        MyLogger.info("result 2 v.s. " + depthSum(null));
    }

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public int depthSum(List<NestedInteger> nestedList) {
        // filter abnormal cases
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }

        this.sum = 0;
        dfs(1, nestedList);


        // return the final result
        return sum;
    }

    int sum;

    void dfs(int depth, List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                sum += depth * nestedInteger.getInteger();
            } else {
                dfs(depth + 1, nestedInteger.getList());
            }
        }
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
