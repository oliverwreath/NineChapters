package com.lintCode.DataStructures;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/18/2016.
 */
public class HappyNumber {
    private final static Logger logger = LoggerFactory.getLogger(HappyNumber.class);

    public static void main(String[] arg) {
        testHappyNumber();
    }

    private static void testHappyNumber() {
        logger.info("{}", isHappy(19));
    }

    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    static boolean isHappy(int n) {
        // Write your code here
        Set<Integer> set = new HashSet<Integer>();

        while (!set.contains(n)) {
            set.add(n);
            long sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            if (sum == 1) {
                return true;
            }
            n = (int) sum;
//            System.out.println(n);
        }

        return false;
    }
}
