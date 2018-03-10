package com.LintCodeContest.Weekly8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No843_DigitalFlip {
    private final static Logger logger = LoggerFactory.getLogger(No843_DigitalFlip.class);

    public static void main(String[] args) {
        No843_DigitalFlip No843_DigitalFlip = new No843_DigitalFlip();
        No843_DigitalFlip.testNo843_DigitalFlip();
    }

    private void testNo843_DigitalFlip() {
        MyLogger.info("result 2 v.s. " + flipDigit(new int[]{1, 0, 0, 1, 1, 1}));
        MyLogger.info("result 2 v.s. " + flipDigit(new int[]{1, 0, 1, 0, 1, 0}));
        MyLogger.info("result 3 v.s. " + flipDigit(new int[]{0, 1, 0, 1, 0, 1, 0}));
        MyLogger.info("result 18 v.s. " + flipDigit(new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0}));
    }

    int flipDigit(int[] A) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }

        int counter1 = 0;
        int[] left = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                counter1++;
                if (i > 0) {
                    left[i] = left[i - 1];
                }
            } else {
                left[i] = counter1;
            }
        }
        int counter2 = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 1) {
                counter2++;
            } else {
                right = counter2;
            }
            min = Math.min(min, left[i] + right);
        }

        return min;
    }

//    int flipDigit(int[] A) {
//        // filter abnormal cases
//        if (A == null || A.length == 0) {
//            return 0;
//        }
//
//        PriorityQueue<Integer> onePq = new PriorityQueue<>(Comparator.reverseOrder());
//        PriorityQueue<Integer> zeroPq = new PriorityQueue<>();
//        for (int i = 0; i < A.length; i++) {
//            if (A[i] == 1) {
//                onePq.add(i);
//            } else {
//                zeroPq.add(i);
//            }
//        }
//        int answer = dfs(onePq, zeroPq);
//
//        return answer;
//    }
//
//    private int dfs(PriorityQueue<Integer> onePq, PriorityQueue<Integer> zeroPq) {
//        if (onePq.isEmpty() || zeroPq.isEmpty() || onePq.peek() < zeroPq.peek()) {
//            return 0;
//        }
//
//        Integer tmp = onePq.poll();
//        int count1 = dfs(onePq, zeroPq);
//        onePq.add(tmp);
//        Integer tmp2 = zeroPq.poll();
//        int count2 = dfs(onePq, zeroPq);
//        zeroPq.add(tmp2);
//        return 1 + Math.min(count1, count2);
//    }


//    int flipDigit(int[] A) {
//        // filter abnormal cases
//        if (A == null || A.length == 0) {
//            return 0;
//        }
//
//        int left = 0;
//        int right = A.length - 1;
//        int answer = 0;
//        while (left + 1 < right) {
//            if (A[left] == 1 && A[right] == 0) {
//                left++;
//                right--;
//            } else if (A[left] == 1 && A[right] == 1) {
//                left++;
//            } else if (A[left] == 0 && A[right] == 0) {
//                right--;
//            } else if (A[left] == 0 && A[right] == 1) {
//                left++;
//                answer += 1;
//            }
//        }
//
//        if (A[right] != 0 && A[left] != 1) {
//            answer++;
//        }
//
//        // return the final result
//        return answer;
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
