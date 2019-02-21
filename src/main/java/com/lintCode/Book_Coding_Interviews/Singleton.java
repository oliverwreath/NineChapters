package com.lintCode.Book_Coding_Interviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/4/2016.
 */
public class Singleton {
    private static final Logger logger = LoggerFactory.getLogger(Singleton.class);

    private static final Singleton solution = new Singleton();

    public static void main(String[] arg) {
        testSingleton();
    }

    private static void testSingleton() {
        logger.info("{}", getInstance());
    }

    static Singleton getInstance() {
        return solution;
    }
}
