package com.lintCode.Naive;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-03.
 */
public class SortIntegers {
    private final static Logger logger = LoggerFactory.getLogger(SortIntegers.class);

    public static void main(String[] arg) {
        new SortIntegers().testSortIntegers();
    }

    private void testSortIntegers() {
        int[] ints = {3, 2, 1, 4, 5};
        sortIntegers(ints);
        logger.info("{}", Arrays.toString(ints));
    }

    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers(int[] A) {
        // write your code here
        // handle extreme cases
        if (A == null || A.length == 0) {
            return;
        }

        Arrays.sort(A);

        return;
    }
}
