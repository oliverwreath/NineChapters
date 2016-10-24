package com.AJia.LeetCode.DFS;

import com.LeetCode.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-23.
 */
public class SameTree_100 {
    private final static Logger logger = LoggerFactory.getLogger(SameTree_100.class);

    public static void main(String[] arg) {
        new SameTree_100().testSameTree_100();
    }

    private void testSameTree_100() {
        logger.info("{}", isSameTree(null, null));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // write your code here
        // handle extreme cases
        if (p == null || q == null) {
            if (p == null) {
                return q == null;
            } else {
                return q != null;
            }
        }

        if (p.val != q.val) {
            return false;
        }
        if (!isSameTree(p.left, q.left)) {
            return false;
        }
        if (!isSameTree(p.right, q.right)) {
            return false;
        }
        return true;
    }

    private MyTmpLogger myLogger = new MyTmpLogger();

    private class MyTmpLogger {
        public MyTmpLogger() {
        }

        public void info(Object o) {
            if (isLogging) {
                System.out.println(o);
            }
        }
    }

    public static boolean isLogging = false;

    static {
        isLogging = true;
    }
}
