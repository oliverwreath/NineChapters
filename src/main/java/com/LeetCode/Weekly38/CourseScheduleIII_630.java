package com.LeetCode.Weekly38;

/**
 * Created by yanli on 2017-06-24.
 */
public class CourseScheduleIII_630 {
    public static void main(String[] args) {
        CourseScheduleIII_630 courseScheduleIII_630 = new CourseScheduleIII_630();
        int[][] ints = {
                {100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}
        };
        MyLogger.debug("result = " + courseScheduleIII_630.scheduleCourse(ints));


    }

    public int scheduleCourse(int[][] courses) {
        return -1;
    }


    private static class MyLogger {
        static boolean isDebugging = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
