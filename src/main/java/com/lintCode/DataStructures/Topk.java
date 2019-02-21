package com.lintCode.DataStructures;

import java.util.Collections;
import java.util.PriorityQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/13/2016.
 */
public class Topk {
    private static final Logger logger = LoggerFactory.getLogger(Topk.class);

    public static void main(String[] arg) {
        testTopk();
    }

    private static void testTopk() {
        logger.info("{}", topk(new int[]{3, 10, 1000, -99, 4, 100}, 3));
    }

    static int[] topk(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, Collections.<Integer>reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = heap.poll();
        }
//        Arrays.sort(nums);
//        int[] ret = new int[k];
//        for (int i = 0; i < k; i++) {
//            ret[i] = nums[nums.length - 1 - i];
//        }
        return ret;
    }
}
