package com;

public class TreesUtil {
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
                    ", left=" + ((left==null)?null:left.val) +
                    ", right=" + ((right==null)?null:right.val) +
                    '}';
        }
    }
}
