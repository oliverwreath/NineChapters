package com.ATemplates_DataStructures.Heap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;

/**
 * Created by yanli on 2016-10-02.
 */
public class DataStreamMedian {
    private static final Logger logger = LoggerFactory.getLogger(DataStreamMedian.class);

    public static void main(String[] arg) {
        new DataStreamMedian().testTrappingRainWater();
    }

    private void testTrappingRainWater() {
        logger.info("1, 1, 2, 2, 3 = {}", medianII(new int[]{1, 2, 3, 4, 5}));
        logger.info("4, 4, 4, 3, 3, 3, 3 = {}", medianII(new int[]{4, 5, 1, 3, 2, 6, 0}));
        logger.info("2, 2, 20 = {}", medianII(new int[]{2, 20, 100}));
    }

    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        // handle extreme inputs
        if (nums == null || nums.length < 1) {
            return new int[0];
        }

        int len = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, (o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len);

        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            if (maxHeap.size() <= minHeap.size()) {
                if (minHeap.isEmpty() || minHeap.peek() > nums[i]) {
                    maxHeap.add(nums[i]);
                } else {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(nums[i]);
                }
            } else {
                if (maxHeap.isEmpty() || maxHeap.peek() < nums[i]) {
                    minHeap.add(nums[i]);
                } else {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(nums[i]);
                }
            }

            answer[i] = maxHeap.peek();
        }

        return answer;
    }
}
