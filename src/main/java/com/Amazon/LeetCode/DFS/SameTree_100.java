package com.Amazon.LeetCode.DFS;

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
            return p == q;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
