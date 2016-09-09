package com.lintCode.ArrayAndNumbers;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/8/2016.
 */
public class SortColors {
    private final static Logger logger = LoggerFactory.getLogger(SortColors.class);

    public static void main(String[] arg) {
        testSortColors();
    }

    private static void testSortColors() {
        int[] ints = {1, 0, 1, 2};
        sortColors(ints);
        logger.info("{}", ints);
    }

    static void sortColors(int[] nums) {
        // filter abnormal inputs
        if (nums == null || nums.length == 0) {
            return;
        }

        // counting sort
        int[] counter = new int[3];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            counter[nums[i]]++;
        }
//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(counter));

        for (int i = 0; i < counter[0]; i++) {
            nums[i] = 0;
        }
        for (int i = counter[0]; i < counter[0] + counter[1]; i++) {
            nums[i] = 1;
        }
        for (int i = counter[0] + counter[1]; i < len; i++) {
            nums[i] = 2;
        }

        // return
        return;
    }
}
