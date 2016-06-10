package com.oliver;

/**
 * Created by Yanliang Han on 2016/6/10.
 */
public class BinaryTree {
    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static class ResultType {
        private int singleMax;
        private int fullMax;

        public ResultType(int singleMax, int fullMax) {
            this.singleMax = singleMax;
            this.fullMax = fullMax;
        }
    }
}
