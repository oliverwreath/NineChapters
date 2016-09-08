package com.lintCode.ArrayAndNumbers;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/8/2016.
 */
public class SubarraySum {
    private final static Logger logger = LoggerFactory.getLogger(SubarraySum.class);

    public static void main(String[] arg) {
        testSubarraySum();
    }

    private static void testSubarraySum() {
//        logger.info("{}", subarraySum(new int[]{-3, 1, 2, -3, 4}));
        logger.info("{}", subarraySum(new int[]{1, -1}));
    }

    static ArrayList<Integer> subarraySum(int[] nums) {
        // handle unhealthy inputs
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }

        // speed up with a hashmap
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            sum += nums[i];
            map.put(i, sum);
        }
        map.put(len, 0);

        // loop through
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int subSum = map.get(i) - map.get(j + 1);
                if (subSum == 0) {
                    ArrayList<Integer> ret = new ArrayList<Integer>();
                    ret.add(i);
                    ret.add(j);
                    return ret;
                }
            }
        }

        // return result
        return new ArrayList<Integer>();
    }
}
