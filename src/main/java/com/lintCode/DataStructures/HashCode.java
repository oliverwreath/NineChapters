package com.lintCode.DataStructures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/11/2016.
 */
public class HashCode {
    private final static Logger logger = LoggerFactory.getLogger(HashCode.class);

    public static void main(String[] arg) {
        testHashCode();
    }

    private static void testHashCode() {
        logger.info("{}", hashCode(new char[]{'a', 'b', 'c', 'd'}, 100));//78
        logger.info("{}", hashCode(new char[]{'d'}, 97));//3
        logger.info("{}", hashCode(new char[]{'u', 'b', 'u', 'n', 't', 'u'}, 1007));//549
    }

    static int hashCode(char[] key, int HASH_SIZE) {
        // filter abnormal inputs
        if (key == null || key.length == 0) {
            return 0;
        }

        // compute
        int len = key.length;
        long ret = key[0];
        for (int i = 1; i < len; i++) {
            ret = ret * 33 + key[i];
            ret %= HASH_SIZE;
        }

        // return result
        return (int) ret;
    }
}
