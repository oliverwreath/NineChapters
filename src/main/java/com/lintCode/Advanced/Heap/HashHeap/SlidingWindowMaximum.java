package com.lintCode.Advanced.Heap.HashHeap;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-02.
 */
public class SlidingWindowMaximum {
    private final static Logger logger = LoggerFactory.getLogger(SlidingWindowMaximum.class);

    public static void main(String[] arg) {
        new SlidingWindowMaximum().testSlidingWindowMaximum();
    }

    private void testSlidingWindowMaximum() {
        logger.info("{}", maxSlidingWindow(new int[]{1, 2, 7, 7, 8}, 3));
        logger.info("{}", maxSlidingWindow(new int[]{1, 2, 7, 7, 2}, 1));
    }

    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        // handle extreme cases
        if (nums == null || nums.length == 0) {
            return ans;
        }

        // use max heap
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < k - 1; i++) {
            add(deque, nums[i]);
        }
        for (int i = k - 1; i < n; i++) {
            add(deque, nums[i]);
            ans.add(deque.peek());
            remove(deque, nums[i - k + 1]);
        }

        return ans;
    }

    private void add(Deque<Integer> deque, int target) {
        while (!deque.isEmpty() && deque.peekLast() < target) {
            deque.pollLast();
        }
        deque.addLast(target);
    }

    private void remove(Deque<Integer> deque, int target) {
        if (!deque.isEmpty() && deque.peekFirst() == target) {
            deque.pollFirst();
        }
        return;
    }

//    /**
//     * @param nums: A list of integers.
//     * @return: The maximum number inside the window at each moving.
//     */
//    ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
//        // write your code here
//        ArrayList<Integer> ans = new ArrayList<Integer>();
//        // handle extreme cases
//        if (nums == null || nums.length == 0) {
//            return ans;
//        }
//
//        // use max heap
//        int n = nums.length;
//        if (k >= n) {
//            long max = Long.MIN_VALUE;
//            for (int num : nums) {
//                max = Math.max(max, num);
//            }
//            ans.add((int) max);
//            return ans;
//        }
//
//        HashHeap heap = new HashHeap("max");
//        for (int i = 0; i < k; i++) {
//            heap.add(nums[i]);
//        }
//        ans.add(heap.peek());
//        for (int t = 1; t <= n - k; t++) {
//            heap.delete(nums[t - 1]);
//            heap.add(nums[k - 1 + t]);
//            ans.add(heap.peek());
//        }
//
//        return ans;
//    }
}
