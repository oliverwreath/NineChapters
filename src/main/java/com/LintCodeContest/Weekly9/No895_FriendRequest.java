package com.LintCodeContest.Weekly9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class No895_FriendRequest {
    private final static Logger logger = LoggerFactory.getLogger(No895_FriendRequest.class);

    public static void main(String[] args) {
        No895_FriendRequest No895_FriendRequest = new No895_FriendRequest();
        No895_FriendRequest.testNo895_FriendReques();
    }

    private void testNo895_FriendReques() {
        MyLogger.info("result 1 v.s. " + friendRequest(new int[]{10, 39, 50}));
        MyLogger.info("result 1 v.s. " + friendRequest(new int[]{101, 79, 102}));
        MyLogger.info("result 1 v.s. " + friendRequest(new int[]{110, 42, 55, 4, 29, 74, 132, 7, 148, 44, 113, 44, 41, 7}));
//        MyLogger.info("result 1 v.s. " + friendRequest(new int[]{110, 42, 55, 4, 29, 74, 132, 148, 44, 113, 44, 41, 7, 133, 119, 69, 116, 123, 51, 16, 44, 82, 76, 4, 65, 39, 108, 119, 41, 29, 145, 77, 78, 64, 76, 72, 90, 28, 11, 137, 58, 52, 61, 114, 58, 143, 120, 27, 121, 129, 92, 121, 124, 28, 40, 15, 105, 13, 46, 145, 3, 138, 12, 137, 134, 7, 98, 49, 102, 145, 84, 19, 123, 34, 106, 54, 91, 85, 77, 104, 90, 78, 135, 43, 42, 61, 56, 24, 33, 118, 130, 22, 75, 128, 57, 49, 65, 115, 127, 132, 149, 114, 119, 10, 119, 76, 144, 83, 1, 22, 74, 18, 145, 139, 134, 104, 22, 107, 16, 77, 27, 16, 101, 114, 94, 30, 19, 66, 93, 29, 138, 67, 51, 2, 132, 140, 61, 31, 62, 104, 116, 10, 62, 119, 90, 18, 126, 143, 129, 85, 75, 38, 75, 122, 79, 98, 97, 103, 87, 37, 72, 37, 59, 116, 66, 128, 34, 103, 88, 82, 116, 5, 2, 58, 130, 25, 100, 48, 124, 94, 15, 87, 48, 85, 31, 32, 99, 17, 30, 13, 5, 113, 113, 17, 36, 89, 136, 57, 10, 47, 24, 30, 65, 53, 94, 102, 99, 150, 21, 101, 34, 94, 112, 78, 27, 64, 139, 25, 54, 51, 119, 128, 134, 123, 16, 121, 141, 94, 41, 124, 113, 30, 129, 6, 20, 134, 82, 34, 50, 27, 135, 24, 109, 57, 97, 84, 135, 82, 143, 110, 66, 89, 64, 65, 127, 67, 27, 119, 73, 60, 130, 6, 83, 115, 117, 60, 100, 47, 139, 104, 41, 118, 110, 87, 81, 102, 76, 16, 73, 101, 41, 50, 35, 141, 48, 58, 132, 56, 135, 100, 60, 75, 88, 55, 62, 122, 69, 51, 67, 108, 78, 150, 78, 34, 117, 83, 75, 45, 146, 13, 133, 60, 134, 116, 22, 79, 45, 120, 110, 2, 96, 82, 108, 146, 73, 44, 16, 28, 123, 45, 33, 31, 32, 73, 76, 140, 97, 149, 60, 15, 141, 138, 106, 1, 93, 20, 68, 127, 45, 66, 49, 149, 101, 32, 2, 46, 41, 123, 89, 74, 85, 2, 149, 115, 83, 26, 46, 26, 112, 108, 2, 26, 75, 42, 124, 145, 28, 47, 8, 4, 75, 89, 82, 91, 98, 67, 39, 129, 121, 97, 105, 12, 146, 83, 150, 68, 35, 22, 58, 136, 142, 113, 28, 108, 25, 118, 54, 64, 45, 89, 120, 132, 16, 88, 52, 136, 17, 101, 23, 97, 147, 132, 134, 148, 85, 129, 111, 89, 14, 13, 131, 28, 71, 18, 41, 53, 129, 101, 115, 113, 129, 149, 28, 62, 4, 54, 83, 92, 63, 38, 109, 54, 1, 47, 2, 53, 52, 100, 86, 20, 81, 108, 26, 60, 136, 72, 9, 91, 148, 115, 111, 76, 128, 67, 86, 65, 41, 66, 108, 99, 72, 66, 92, 134, 88, 53, 101, 26, 15, 82, 143, 70, 113, 44, 149, 87, 127, 78, 75, 10, 16, 141, 105, 4, 12, 24, 56, 39, 84, 146, 105, 112, 70, 21, 132, 70, 18, 54, 86, 5, 95, 54, 44, 115, 63, 42, 50, 65, 20, 83, 144, 90, 133, 102, 55, 101, 22, 109, 14, 34, 27, 87, 83, 19, 68, 28, 46, 111, 99, 139, 68, 121, 84, 132, 91, 129, 67, 5, 60, 63, 12, 138, 118, 34, 118, 77, 32, 114, 34, 2, 30, 148, 16, 9, 93, 57, 147, 117, 135, 57, 130, 78, 90, 74, 60, 91, 122, 66, 130, 35, 20, 35, 52, 88, 142, 116, 113, 87, 81, 9, 42, 38, 18, 113, 67, 106, 13, 113, 60, 59, 139, 71, 11, 142, 22, 46, 5, 64, 65, 100, 130, 63, 131, 100, 78, 150, 55, 8, 144, 9, 46, 116, 15, 145, 138, 24, 133, 61, 52, 35, 75, 118, 80, 15, 43, 49, 79, 115, 50, 6, 74, 18, 29, 43, 90, 124, 92, 63, 143, 130, 92, 44, 116, 83, 3, 76, 12, 42, 121, 113, 147, 143, 134, 98, 73, 117, 4, 84, 53, 63, 150, 80, 71, 124, 126, 102, 21, 60, 140, 128, 34, 68, 107, 86, 4, 4, 95, 89, 88, 15, 121, 112, 76, 36, 99, 72, 63, 139, 84, 78, 16, 100, 81, 107, 135, 134, 139, 60, 78, 54, 113, 33, 21, 6, 41, 64, 136, 123, 69, 115, 10, 100, 147, 146, 2, 27, 114, 147, 21, 73, 46, 100, 68, 86, 1, 48, 57, 101, 92, 126, 78, 137, 30, 25, 105, 98, 83, 39, 137, 52, 67, 129, 83, 139, 97, 44, 76, 150, 148, 59, 129, 127, 40, 11, 120, 50, 108, 41, 72, 107, 125, 15, 44, 139, 42, 41, 135, 74, 126, 38, 138, 32, 138, 10, 10, 108, 106, 60, 112, 114, 19, 10, 133, 44, 85, 61, 142, 146, 67, 7, 30, 37, 83, 116, 99, 59, 68, 140, 117, 85, 18, 1, 1, 105, 16, 131, 116, 145, 128, 105, 23, 83, 117, 123, 73, 12, 87, 125, 52, 86, 131, 33, 37, 104, 65, 64, 39, 21, 2, 43, 57, 59, 5, 56, 14, 59, 7, 19, 41, 58, 23, 28, 77, 35, 136, 112, 66, 71, 104, 19, 113, 6, 7, 56, 100, 120, 39, 61, 144, 103, 102, 57, 37, 61, 125, 89, 46, 136, 34, 10, 21, 49, 16, 124, 45, 144, 137, 46, 8, 23, 81, 33, 30, 146, 52, 43, 98, 116, 75, 2, 136, 15, 150, 15, 65, 72, 146, 92, 8, 106, 8, 13, 85, 59, 90, 122, 50, 138, 20, 120, 105, 39, 118, 146, 71, 10, 15, 15, 44, 52, 31, 23, 79}));
    }

    public int friendRequest(int[] ages) {
        // Write your code here
        if (ages == null || ages.length == 0) {
            return 0;
        }

//        Arrays.sort(ages);
        int answer = 0;
        for (int b = 0; b < ages.length; b++) {
            int delta = 0;
            if (ages[b] >= 100) {
                for (int a = 0; a < ages.length; a++) {
                    if (a == b) {
                        continue;
                    }
//                    System.out.println("a, b = " + a + ", " + b + "; ages[a], ages[b] = " + ages[a] + ", " + ages[b]);
                    if (ages[a] < ages[b] || ages[a] / 2 + 7 >= ages[b]) {

                    } else {
                        delta++;
                    }
                }
            } else {
                for (int a = 0; a < ages.length; a++) {
                    if (a == b) {
                        continue;
                    }
//                    System.out.println("a, b = " + a + ", " + b + "; ages[a], ages[b] = " + ages[a] + ", " + ages[b]);
                    if (ages[a] > 100 || ages[a] < ages[b] || ages[a] / 2 + 7 >= ages[b]) {

                    } else {
                        delta++;
                    }
                }
            }

//            System.out.println(delta);
            answer += delta;
        }

        return answer;
    }

//    int friendRequest(int[] A) {
//        // filter abnormal cases
//        if (A == null || A.length == 0) {
//            return 0;
//        }
//
//        int count = 0;
//        Arrays.sort(A);
////        System.out.println(Arrays.toString(A));
//        int lastNumber = Integer.MIN_VALUE;
//        int rightStart = 0;
//        for (int left = 0; left < A.length - 1; left++) {
//            int b = A[left];
//            int delta = Integer.MIN_VALUE;
////            boolean isMinusOne = false;
//            if (b != lastNumber) {
//                lastNumber = b;
//                rightStart = left;
////                isMinusOne = false;
//            } else {
////                isMinusOne = true;
//            }
//
//            if (b < 100) {
//                for (int right = rightStart; right < A.length; right++) {
//                    if (A[right] > 100 || A[right] / 2 + 7 >= b) {
//                        delta = right - rightStart;
//                        break;
//                    }
//                }
//            } else {
//                for (int right = rightStart; right < A.length; right++) {
//                    if (A[right] / 2 + 7 >= b) {
//                        delta = right - rightStart;
//                        break;
//                    }
//                }
//            }
////            System.out.println("b = " + b + "; rightStart = " + rightStart + "; delta = " + delta);
//            if (delta == Integer.MIN_VALUE) {
//                delta = A.length - rightStart;
//            }
//            if (delta > 0) {//isMinusOne &&
//                delta--;
//            }
//
////            System.out.println("delta = " + delta);
//            count += delta;
//        }
//
//        // return the final result
//        return count;
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
