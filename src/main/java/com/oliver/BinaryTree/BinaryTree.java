package com.oliver.BinaryTree;

/**
 * Created by Yanliang Han on 2016/6/10.
 */
public class BinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
//        System.out.println("maxPathSum(root)=" + maxPathSum(root));
        MaxPathSumSolution maxPathSumSolution = new MaxPathSumSolution();
        System.out.println("result=" + maxPathSumSolution.maxPathSum(root.right));
//        System.out.println("result=" + maxPathSum(root.left));
//        System.out.println("result=" + maxPathSum(root.right.left));
//        System.out.println("result=" + maxPathSum(root.right.right));
    }

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

    private static class MaxPathSumSolution {
        //最大路径和
        class ResultType {
            private int singleMax;
            private int fullMax;

            public ResultType(int singleMax, int fullMax) {
                this.singleMax = singleMax;
                this.fullMax = fullMax;
            }
        }

        //version1
        public int maxPathSum(TreeNode root) {
            ResultType resultType = maxPathSumHelper(root);
            return resultType.fullMax;
        }

        public ResultType maxPathSumHelper(TreeNode root) {
            // write your code here
            if (root == null) {
                return new ResultType(0, Integer.MIN_VALUE);
            }

            //Divide
            ResultType left = maxPathSumHelper(root.left);
            ResultType right = maxPathSumHelper(root.right);

            //Conquer
            int singleMax = Math.max(0, root.val + Math.max(left.singleMax, right.singleMax));

            int fullMax = Math.max(left.fullMax, right.fullMax);
            fullMax = Math.max(fullMax, left.singleMax + root.val + right.singleMax);

            return new ResultType(singleMax, fullMax);
        }

        //version2
        public int maxPathSum2(TreeNode root) {
            ResultType resultType = maxPathSumHelper(root);
            return resultType.fullMax;
        }

        public ResultType maxPathSumHelper2(TreeNode root) {
            // write your code here
            if (root == null) {
                return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
            }

            //Divide
            ResultType left = maxPathSumHelper2(root.left);
            ResultType right = maxPathSumHelper2(root.right);

            //Conquer
            int singleMax = root.val + Math.max(0, Math.max(left.singleMax, right.singleMax));

            int fullMax = Math.max(left.fullMax, right.fullMax);
            fullMax = Math.max(fullMax, Math.max(0, left.singleMax) + root.val + Math.max(0, right.singleMax));

            return new ResultType(singleMax, fullMax);
        }
    }


    //LCA - lowest common ancestor
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || root == A || root == B) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }

    private static class IsBalancedSolution {
        //isBalanced
        private class ResultType {
            private boolean isBalanced;
            private int depth;

            public ResultType(int depth, boolean isBalanced) {
                this.depth = depth;
                this.isBalanced = isBalanced;
            }
        }

        public boolean isBalanced(TreeNode root) {
            // write your code here
            if (root == null) {
                return true;
            }

            return isBalancedHelper(root).isBalanced;
        }

        public ResultType isBalancedHelper(TreeNode root) {
            // write your code here
            if (root == null) {
                return new ResultType(0, true);
            }

            ResultType leftResult = isBalancedHelper(root.left);
            ResultType rightResult = isBalancedHelper(root.right);

            int depth = 1 + Math.max(leftResult.depth, rightResult.depth);
            boolean isBalanced = leftResult.isBalanced && rightResult.isBalanced && Math.abs(leftResult.depth - rightResult.depth) <= 1;
            return new ResultType(depth, isBalanced);
        }

        public boolean isBalanced2(TreeNode root) {
            // write your code here
            if (root == null) {
                return true;
            }

            return maxDepth(root) != -1;
        }

        public int maxDepth(TreeNode root) {
            // write your code here
            if (root == null) {
                return 0;
            }

            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
                return -1;
            } else {
                return 1 + Math.max(left, right);
            }
        }
    }

    private static class MaxDepthSolution {
        //maxDepth
        public int maxDepth(TreeNode root) {
            // write your code here
            if (root == null) {
                return 0;
            }
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }

        private int maxDepth = Integer.MIN_VALUE;

        public int maxDepth2(TreeNode root) {
            // write your code here
            if (root == null) {
                return 0;
            }
            int currentDepth = 1;
            maxDepthHelper(root, currentDepth);
            return maxDepth;
        }

        private void maxDepthHelper(TreeNode root, int currentDepth) {
            if (root == null) {
                return;
            }
            if (currentDepth > maxDepth) {
                maxDepth = currentDepth;
            }
            maxDepthHelper(root.left, currentDepth + 1);
            maxDepthHelper(root.right, currentDepth + 1);
            return;
        }
    }
}
