package com.lintCode.ArrayAndNumbers;

import java.util.Arrays;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/8/2016.
 */
public class TwoSum {
    private final static Logger logger = LoggerFactory.getLogger(TwoSum.class);

    public static void main(String[] arg) {
        testTwoSum();
    }

    private static void testTwoSum() {
        logger.info("{}", twoSum(new int[]{2, 7, 11, 15}, 9));
        logger.info("{}", twoSum(new int[]{1, 0, -1}, -1));
    }

    static int[] twoSum(int[] numbers, int target) {
        // filter abnormal inputs
        if (numbers == null || numbers.length == 0) {
            return new int[]{};
        }

        // store the indexes for retrieval later.
        int len = numbers.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            map.put(numbers[i], i);
        }

        // find result
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - numbers[i])) {
                int[] ret = new int[]{i + 1, map.get(target - numbers[i]) + 1};
                Arrays.sort(ret);
                return ret;
            }
        }

        // return results
        return new int[]{};
    }
}
