package com.lintCode.BinarySearch1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yanli on 9/3/2016.
 */
public class No460_KClosestNumbers {
    private static final Logger logger = LoggerFactory.getLogger(No460_KClosestNumbers.class);

    public static void main(String[] arg) {
        testKClosestNumbers();
    }

    private static void testKClosestNumbers() {
        No460_KClosestNumbers no460_kClosestNumbers = new No460_KClosestNumbers();
        logger.info("{}", no460_kClosestNumbers.kClosestNumbers(new int[]{1, 2, 3}, 2, 3));
        logger.info("{}", no460_kClosestNumbers.kClosestNumbers(new int[]{1, 2, 4, 6, 8}, 3, 4));
    }

    public int[] kClosestNumbers(int[] nums, int target, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        List<Entry> list = new ArrayList<>();
        for (int num : nums) {
            list.add(new Entry(num, Math.abs(num - target)));
        }
        Comparator<Entry> comparatorByDiff = (o1, o2) -> {if (o1.diff == o2.diff) {return o1.original - o2.original;} else {return o1.diff - o2.diff;}};
        Collections.sort(list, comparatorByDiff);
        int[] result = new int[k];
        int i = 0;
        for (Entry entry : list) {
            if (i >= k) {break;}
            result[i++] = entry.original;
        }

        return result;
    }

    private class Entry {
        int original = 0;
        int diff = 0;

        Entry(int original, int diff) {
            this.original = original;
            this.diff = diff;
        }
    }
}
//    Given A = [], target = 2 and k = 3, return [2, 1, 3].

//        Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].
