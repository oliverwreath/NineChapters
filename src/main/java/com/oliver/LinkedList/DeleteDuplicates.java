package com.oliver.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli_000 on 16/7/10.
 */
public class DeleteDuplicates {
    private final static Logger logger = LoggerFactory.getLogger(DeleteDuplicates.class);

    public static void main(String[] args) {
        testDeleteDuplicates();
    }

    private static void testDeleteDuplicates() {
        long startTime = System.currentTimeMillis();
        deleteDuplicates();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void deleteDuplicates() {

    }
}
