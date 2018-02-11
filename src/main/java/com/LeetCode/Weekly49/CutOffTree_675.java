package com.LeetCode.Weekly49;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CutOffTree_675 {
    private final static Logger logger = LoggerFactory.getLogger(CutOffTree_675.class);

    public static void main(String[] args) {
        testCutOffTree_675();
    }

    private static void testCutOffTree_675() {
        CutOffTree_675 CutOffTree_675 = new CutOffTree_675();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 2, 3));
        list.add(Arrays.asList(0, 0, 4));
        list.add(Arrays.asList(7, 6, 5));
        MyLogger.info("result 6 = " + CutOffTree_675.cutOffTree(list));
        list.clear();
        list.add(Arrays.asList(1, 2, 3));
        list.add(Arrays.asList(0, 0, 0));
        list.add(Arrays.asList(7, 6, 5));
        MyLogger.info("result -1 = " + CutOffTree_675.cutOffTree(list));
        list.clear();
        list.add(Arrays.asList(2, 3, 4));
        list.add(Arrays.asList(0, 0, 5));
        list.add(Arrays.asList(8, 7, 6));
        MyLogger.info("result 6 = " + CutOffTree_675.cutOffTree(list));
    }

    /**
     * @param forest
     * @return
     */
    public int cutOffTree(List<List<Integer>> forest) {
        // filter abnormal inputs
        if (forest == null || forest.size() < 1 || forest.get(0) == null || forest.get(0).size() < 1) {
            return 0;
        }

        int length = forest.size();
        return -1;
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
