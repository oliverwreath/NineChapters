package com.ATemplates_DataStructures.SegmentTree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No249_CountOfSmallerNumberII {
    private static final Logger logger = LoggerFactory.getLogger(No249_CountOfSmallerNumberII.class);

    public static void main(String[] args) {
        testNo249_CountOfSmallerNumberII();
    }

    private static void testNo249_CountOfSmallerNumberII() {
        No249_CountOfSmallerNumberII no249_CountOfSmallerNumberII = new No249_CountOfSmallerNumberII();
        MyLogger.info("result [0,1,2,3,2] v.s. " + no249_CountOfSmallerNumberII.countOfSmallerNumberII(new int[]{1, 2, 7, 8, 5}));
//        MyLogger.info("result 1 v.s. " + no249_CountOfSmallerNumberII.longestIncreasingContinuousSubsequence("10"));
    }

    public List<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        LinkedList<Integer> answer = new LinkedList<>();
        if (A == null || A.length < 1) {
            return answer;
        }

        SegmentTreeNode root = build(0, 10000);
//        System.out.println(printSegmentTree(root));
        for (int i : A) {
            if (i > 0) {
                answer.add(query(root, 0, i - 1));
            } else {
                answer.add(0);
            }
            modify(root, i);
        }

        return answer;
    }

    class SegmentTreeNode {
        int start, end;
        int sum;
        SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = this.right = null;
        }

        @Override
        public String toString() {
            return "SegmentTreeNode{" +
                    "start=" + start +
                    ", end=" + end +
                    ", sum=" + sum +
                    '}';
        }
    }

    public StringBuilder printSegmentTree(SegmentTreeNode root) {
        if (root == null) {
            return new StringBuilder();
        }
        Queue<Integer> queueFactors = new LinkedList<>();
        queueFactors.add(0);
        Queue<SegmentTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            Integer factor = queueFactors.poll();
            SegmentTreeNode currentNode = queue.poll();
            if (factor > currentLevel) {
                stringBuilder.append('\n');
                currentLevel = factor;
            }
            stringBuilder.append(currentNode + "; ");
        }
        return stringBuilder;
    }

    public SegmentTreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        if (start == end) {
            return root;
        }
        int mid = (root.start + root.end) / 2;
        root.left = build(start, mid);
        root.right = build(mid + 1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    public int query(SegmentTreeNode root, int start, int end) {
        if (start <= root.start && root.end <= end) {
            return root.sum;
        }
        int mid = (root.start + root.end) / 2;
        int answer = 0;
        if (start <= mid) {
            answer += query(root.left, start, end);
        }
        if (mid + 1 <= end) {
            answer += query(root.right, start, end);
        }
        return answer;
    }

    public void modify(SegmentTreeNode root, int index) {
        if (root.start == root.end && root.start == index) {
            root.sum++;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (index <= mid) {
            modify(root.left, index);
        } else {
            modify(root.right, index);
        }
        root.sum = root.left.sum + root.right.sum;
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
