package com.lintCode.BinaryTree;

import com.TreesUtil.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-25.
 */
public class Subtree {
    private final static Logger logger = LoggerFactory.getLogger(Subtree.class);

    public static void main(String[] arg) {
        new Subtree().testSubtree();
    }

    private void testSubtree() {
        logger.info("{}", isSubtree(null, null));
    }

    /**
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // handle extreme cases
        if (T2 == null) {
            return true;
        }
        if (T1 == null) {
            return false;
        }

        if (isEqual(T1, T2)) {
            return true;
        }
        if (isSubtree(T1.left, T2) || isSubtree(T1.right, T2)) {
            return true;
        }

        return false;
    }

    private boolean isEqual(TreeNode T1, TreeNode T2) {
        // write your code here
        if (T1 == null || T2 == null) {
            return T1 == T2;
        }
        if (T1.val != T2.val) {
            return false;
        }
        return isEqual(T1.left, T2.left) && isEqual(T1.right, T2.right);
    }

    private static MyTmpLogger myLogger = new MyTmpLogger();

    private static class MyTmpLogger {
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
