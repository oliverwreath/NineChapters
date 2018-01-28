package com.ATemplates_DataStructures.Heap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yanli on 2016-10-02.
 */
public class DataStreamMedian {
    private final static Logger logger = LoggerFactory.getLogger(DataStreamMedian.class);

    public static void main(String[] arg) {
        new DataStreamMedian().testTrappingRainWater();
    }

    private void testTrappingRainWater() {
        logger.info("1, 1, 2, 2, 3 = {}", medianII(new int[]{1, 2, 3, 4, 5}));
        logger.info("4, 4, 4, 3, 3, 3, 3 = {}", medianII(new int[]{4, 5, 1, 3, 2, 6, 0}));
        logger.info("2, 2, 20 = {}", medianII(new int[]{2, 20, 100}));
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
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        // handle extreme inputs
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        maxHeap = new PriorityQueue<Integer>(n, maxComparator);
        minHeap = new PriorityQueue<Integer>(n);

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            minHeap.add(nums[i]);
            maxHeap.add(minHeap.poll());
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }
            if (maxHeap.size() == minHeap.size()) {
                ans[i] = maxHeap.peek();
            } else {
                ans[i] = maxHeap.peek();
            }
//            System.out.println(maxHeap);
//            System.out.println(minHeap);
//            System.out.println(ans[i]);
        }

        return ans;
    }
}
