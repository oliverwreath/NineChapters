package com.lintCode.DataStructures;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/18/2016.
 */
public class NthUglyNumber {
    private static final Logger logger = LoggerFactory.getLogger(NthUglyNumber.class);

    public static void main(String[] arg) {
        testNthUglyNumber();
    }

    private static void testNthUglyNumber() {
        logger.info("{}", nthUglyNumber(9));
    }

    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    static int nthUglyNumber(int n) {
        // Write your code here
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for (int i = 1; i < n; i++) {
            int last = list.get(i - 1);
            while (list.get(i2) * 2 <= last) {
                i2++;
            }
            while (list.get(i3) * 3 <= last) {
                i3++;
            }
            while (list.get(i5) * 5 <= last) {
                i5++;
            }
            list.add(Math.min(Math.min(list.get(i2) * 2, list.get(i3) * 3), list.get(i5) * 5));
        }

        return list.get(n - 1);
    }
}
