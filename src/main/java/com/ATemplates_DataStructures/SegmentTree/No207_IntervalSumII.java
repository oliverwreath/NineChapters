package com.ATemplates_DataStructures.SegmentTree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No207_IntervalSumII {
    private static final Logger logger = LoggerFactory.getLogger(No207_IntervalSumII.class);

    public static void main(String[] args) {
        testNo207_IntervalSumII();
    }

    private static void testNo207_IntervalSumII() {
        No207_IntervalSumII No207_IntervalSumII = new No207_IntervalSumII();
//        MyLogger.info("result 2 v.s. " + No207_IntervalSumII.longestIncreasingContinuousSubsequence("12"));
//        MyLogger.info("result 1 v.s. " + No207_IntervalSumII.longestIncreasingContinuousSubsequence("10"));
    }


    /* you may need to use some attributes here */
    SegmentTreeNode root;

    class SegmentTreeNode {
        int start, end;
        long sum;
        SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = this.right = null;
        }
    }

    public SegmentTreeNode build(int start, int end, int[] A) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, A[start]);
        if (start == end) {
            return root;
        }
        int mid = (root.start + root.end) / 2;
        root.left = build(start, mid, A);
        root.right = build(mid + 1, end, A);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    public long query(SegmentTreeNode root, int start, int end) {
        if (start <= root.start && root.end <= end) {
            return root.sum;
        }
        int mid = (root.start + root.end) / 2;
        long answer = 0;
        if (start <= mid) {
            answer += query(root.left, start, end);
        }
        if (mid + 1 <= end) {
            answer += query(root.right, start, end);
        }
        return answer;
    }

    public void modify(SegmentTreeNode root, int index, int value) {
        if (root.start == root.end && root.start == index) {
            root.sum = value;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (index <= mid) {
            modify(root.left, index, value);
        } else {
            modify(root.right, index, value);
        }
        root.sum = root.left.sum + root.right.sum;
    }


    /*
     * @param A: An integer array
     */
//    public Solution(int[] A) {
//        // do intialization if necessary
//        root = build(0, A.length - 1, A);
//    }

    /*
     * @param start: An integer
     * @param end: An integer
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        // write your code here
        return query(root, start, end);
    }

    /*
     * @param index: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void modify(int index, int value) {
        // write your code here
        modify(root, index, value);
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
