package com.Amazon.LeetCode.Algorithms;

import com.TreesUtil.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yanli on 2016-10-23.
 */
public class BinaryTreeRightSideView {
    private final static Logger logger = LoggerFactory.getLogger(BinaryTreeRightSideView.class);

    public static void main(String[] arg) {
        new BinaryTreeRightSideView().testBinaryTreeRightSideView();
    }

    private void testBinaryTreeRightSideView() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        logger.info("{}", rightSideView(root));
    }

    public List<Integer> rightSideView(TreeNode root) {
        // write your code here
        // handle extreme cases
        if (root == null) {
            return new LinkedList<>();
        }

        myLogger.info("root = " + root);
        List<Integer> ans = bst(root);

        return ans;
    }

    private List<Integer> bst(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        List<Integer> ans = new LinkedList<>();
        while (!deque.isEmpty()) {
            ans.add(deque.peekLast().val);
            myLogger.info("size = " + deque.size() + "; deque.peekLast().val = " + deque.peekLast().val);
            int size = deque.size();
            for (int t = 0; t < size; t++) {
                TreeNode currentNode = deque.pollFirst();
                if (currentNode == null) {
                    continue;
                } else {
                    if (currentNode.left != null) {
                        deque.addLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        deque.addLast(currentNode.right);
                    }
                }
            }
        }
        return ans;
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

//    static {
//        isLogging = true;
//    }
}
