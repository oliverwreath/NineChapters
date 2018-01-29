package com.ATemplates_DataStructures.Heap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, (o1, o2) -> o2 - o1);

        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            if (maxHeap.size() <= minHeap.size()) {
                minHeap.add(nums[i]);
                maxHeap.add(minHeap.poll());
            } else {
                maxHeap.add(nums[i]);
                minHeap.add(maxHeap.poll());
            }
            answer[i] = maxHeap.peek();
        }

        return answer;
    }
}
