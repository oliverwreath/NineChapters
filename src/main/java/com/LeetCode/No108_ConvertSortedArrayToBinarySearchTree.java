package com.LeetCode;

import com.TreesUtil.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No108_ConvertSortedArrayToBinarySearchTree {
    private static final Logger logger = LoggerFactory.getLogger(No108_ConvertSortedArrayToBinarySearchTree.class);

    public static void main(String[] args) {
        testNo108_ConvertSortedArrayToBinarySearchTree();
    }

    private static void testNo108_ConvertSortedArrayToBinarySearchTree() {
        No108_ConvertSortedArrayToBinarySearchTree No108_ConvertSortedArrayToBinarySearchTree = new No108_ConvertSortedArrayToBinarySearchTree();
//        MyLogger.info("result 2 v.s. " + No108_ConvertSortedArrayToBinarySearchTree.sortedArrayToBST("12"));
//        MyLogger.info("result 1 v.s. " + No108_ConvertSortedArrayToBinarySearchTree.sortedArrayToBST("10"));
    }

    /**
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        if (nums.length < 2) {
            return new TreeNode(nums[0]);
        }

        // core logic
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (start <= mid - 1) {
            root.left = new TreeNode(-1);
            bstHelper(root.left, nums, start, mid - 1);
        }
        if (mid + 1 <= end) {
            root.right = new TreeNode(-1);
            bstHelper(root.right, nums, mid + 1, end);
        }

        // wrap up
        return root;
    }

    public void bstHelper(TreeNode node, int[] nums, int start, int end) {
        if (start == end) {
            node.val = nums[start];
        } else {
            int mid = (start + end + 1) / 2;
            node.val = nums[mid];
            if (start <= mid - 1) {
                node.left = new TreeNode(-1);
                bstHelper(node.left, nums, start, mid - 1);
            }
            if (mid + 1 <= end) {
                node.right = new TreeNode(-1);
                bstHelper(node.right, nums, mid + 1, end);
            }
        }
    }

    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
