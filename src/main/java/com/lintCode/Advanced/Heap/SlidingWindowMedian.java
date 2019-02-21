package com.lintCode.Advanced.Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-02.
 */
public class SlidingWindowMedian {
    private static final Logger logger = LoggerFactory.getLogger(SlidingWindowMedian.class);

    public static void main(String[] arg) {
        new SlidingWindowMedian().testMedianSlidingWindow();
    }

    private void testMedianSlidingWindow() {
        logger.info("2, 7, 7 = {}", medianSlidingWindow(new int[]{1, 2, 7, 8, 5}, 3));
//        logger.info("4, 4, 4, 3, 3, 3, 3 = {}", medianSlidingWindow(new int[]{4, 5, 1, 3, 2, 6, 0}));
//        logger.info("2, 2, 20 = {}", medianSlidingWindow(new int[]{2, 20, 100}));
    }

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    private static Comparator<Integer> maxComparator = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    };

    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0 || k < 1) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (k == 1) {
            for (int num : nums) {
                ans.add(num);
            }
            return ans;
        }

        // Heap
        maxHeap = new PriorityQueue<Integer>(k, maxComparator);
        minHeap = new PriorityQueue<Integer>(k);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // maxHeap <= minHeap
            minHeap.add(nums[i]);
            maxHeap.add(minHeap.poll());
            // delete if too much
            if (i >= k) {
                if (!maxHeap.remove(nums[i - k])) {
                    minHeap.remove(nums[i - k]);
                }
            }
            // balance
            while (minHeap.size() + 1 < maxHeap.size()) {
                minHeap.add(maxHeap.poll());
            }
            while (maxHeap.size() + 1 < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            if (i >= k - 1) {
                ans.add(getMed(maxHeap, minHeap));
            }
        }

        // return
        return ans;
    }

    private int getMed(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() == minHeap.size()) {
            return maxHeap.peek();
        } else if (minHeap.size() + 1 == maxHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }
}
