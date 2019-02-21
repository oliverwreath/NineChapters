package com.LintCodeContest.Weekly6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No826_ComputerMaintenance {
    private static final Logger logger = LoggerFactory.getLogger(No826_ComputerMaintenance.class);

    public static void main(String[] args) {
        No826_ComputerMaintenance No826_ComputerMaintenance = new No826_ComputerMaintenance();
        No826_ComputerMaintenance.testNo826_ComputerMaintenance();
    }

    private void testNo826_ComputerMaintenance() {//n = 3, m = 10, List = [[0,0],[0,9],[1,7]]
        MyLogger.info("result 9 v.s. " + maintenance(3, 10, new Point[]{
                new Point(0, 3), new Point(0, 9)
        }));
        MyLogger.info("result 8 v.s. " + maintenance(3, 10, new Point[]{
                new Point(0, 0), new Point(0, 8)
        }));
        MyLogger.info("result 15 v.s. " + maintenance(3, 10, new Point[]{
                new Point(0, 0), new Point(0, 9), new Point(1, 7)
        }));
        MyLogger.info("result 17 v.s. " + maintenance(3, 10, new Point[]{
                new Point(0, 3), new Point(1, 7), new Point(1, 2)
        }));
    }

    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    int maintenance(int m, int n, Point[] A) {
        // filter abnormal cases
        if (n == 0 || m == 0) {
            return 0;
        }
        if (A == null || A.length == 0) {
            return 0;
        }

        ArrayList<List<Integer>> list = new ArrayList<>(A.length);
        for (int i = 0; i < m; i++) {
            list.add(new LinkedList<>());
        }
        for (Point point : A) {
            list.get(point.x).add(point.y);
        }

//        int lastRowNeedRepair = m - 1;
//        for (int i = m - 1; i >= 0; i--) {
//            if (list.get(i).isEmpty()) {
//                lastRowNeedRepair--;
//            } else {
//                break;
//            }
//        }
//        System.out.println("lastRowNeedRepair = " + lastRowNeedRepair);

        int[][] dp = new int[m][2];
        // step 1: when i == 0;
        if (list.get(0).isEmpty()) {
            dp[0][0] = 0;
            dp[0][1] = n - 1;
        } else {
            int max = 0;
            for (Integer index : list.get(0)) {
                max = Math.max(max, index);
            }
            dp[0][0] = max << 1;
            dp[0][1] = n - 1;
        }

        // step 2: when i = 1 -> lastRowNeedRepair - 1;
        for (int i = 1; i < m; i++) {
            if (list.get(i).isEmpty()) {
                dp[i][0] = Math.min(1 + dp[i - 1][0], 1 + dp[i - 1][1] + n - 1);
                dp[i][1] = Math.min(1 + dp[i - 1][0] + n - 1, 1 + dp[i - 1][1]);
            } else {
                int min = n - 1;
                int max = 0;
                for (Integer index : list.get(i)) {
                    min = Math.min(min, index);
                    max = Math.max(max, index);
                }
                dp[i][0] = Math.min(1 + dp[i - 1][0] + max + max, 1 + dp[i - 1][1] + n - 1);
                dp[i][1] = Math.min(1 + dp[i - 1][0] + n - 1, 1 + dp[i - 1][1] + n - 1 - min + n - 1 - min);
            }
        }

//        for (int i = 0; i < m; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        return Math.min(dp[m - 1][0], dp[m - 1][1]);
//            }
//        }
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
