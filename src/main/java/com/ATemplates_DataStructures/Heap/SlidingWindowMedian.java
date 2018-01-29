package com.ATemplates_DataStructures.Heap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by yanli on 2016-10-02.
 */
public class SlidingWindowMedian {
    private final static Logger logger = LoggerFactory.getLogger(SlidingWindowMedian.class);

    public static void main(String[] arg) {
        new SlidingWindowMedian().testMedianSlidingWindow();
    }

    private void testMedianSlidingWindow() {
        logger.info("2, 7, 7 == {}", medianSlidingWindow(new int[]{1, 2, 7, 8, 5}, 3));
        logger.info("1,2,7,2,2,3,3,4 == {}", medianSlidingWindow(new int[]{1, 2, 7, 7, 2, 10, 3, 4, 5}, 2));
//        logger.info("4, 4, 4, 3, 3, 3, 3 = {}", medianSlidingWindow(new int[]{4, 5, 1, 3, 2, 6, 0}));
//        logger.info("2, 2, 20 = {}", medianSlidingWindow(new int[]{2, 20, 100}));
    }

    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0 || nums.length < k) {
            return new ArrayList<>();
        }
        ArrayList<Integer> answer = new ArrayList<>();
        if (k == 1) {
            for (int num : nums) {
                answer.add(num);
            }
            return answer;
        }

        // Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            add(maxHeap, minHeap, nums[i]);
            if (i >= k - 1) {
                answer.add(maxHeap.peek());
            }
        }
        for (int i = k; i < len; i++) {
            deleteAdd(maxHeap, minHeap, nums[i], nums[i - k]);
            if (i >= k - 1) {
                answer.add(maxHeap.peek());
            }
        }

        // return
        return answer;
    }

    private void add(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int input) {
        if (maxHeap.size() <= minHeap.size()) {
            if (minHeap.isEmpty() || minHeap.peek() > input) {
                maxHeap.add(input);
            } else {
                maxHeap.add(minHeap.poll());
                minHeap.add(input);
            }
        } else {
            if (maxHeap.isEmpty() || maxHeap.peek() < input) {
                minHeap.add(input);
            } else {
                minHeap.add(maxHeap.poll());
                maxHeap.add(input);
            }
        }
    }

    private void deleteAdd(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int input, int target) {
        if (target <= maxHeap.peek()) {
            maxHeap.remove(target);
        } else {
            minHeap.remove(target);
        }
//        if (maxHeap.size() < minHeap.size()) {
//            maxHeap.add(minHeap.poll());
//        }
        if (maxHeap.size() <= minHeap.size()) {
            if (minHeap.isEmpty() || minHeap.peek() > input) {
                maxHeap.add(input);
            } else {
                maxHeap.add(minHeap.poll());
                minHeap.add(input);
            }
        } else {
            if (maxHeap.isEmpty() || maxHeap.peek() < input) {
                minHeap.add(input);
            } else {
                minHeap.add(maxHeap.poll());
                maxHeap.add(input);
            }
        }
    }
}
