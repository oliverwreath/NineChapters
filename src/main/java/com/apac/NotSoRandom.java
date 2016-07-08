package com.apac;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli_000 on 16/7/9.
 */
public class NotSoRandom {
    private final static Logger logger = LoggerFactory.getLogger(NotSoRandom.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }
}
