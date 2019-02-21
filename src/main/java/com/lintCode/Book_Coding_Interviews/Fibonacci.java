package com.lintCode.Book_Coding_Interviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/4/2016.
 */
public class Fibonacci {
    private static final Logger logger = LoggerFactory.getLogger(Fibonacci.class);

    public static void main(String[] arg) {
        testFibonacci();
    }

    private static void testFibonacci() {
        logger.info("{}", fibonacci(10));
    }

    static int[] fib = new int[1999];
    static int index = 1;

    static {
        fib[1] = 1;
    }

    static int fibonacci(int n) {
        // filter invalid input
        if (n < 0) {
            return -1;
        }

        // check if we need to update
        if (n - 1 > index) {
            for (int i = index + 1; i < n; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
            index = n - 1;
        }

        // get result from fib[n - 1]
        return fib[n - 1];
    }
}
