import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree {
    private static class TreeNode {
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

    private static class ResultType {
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

    private static class traversalSolution {
        //1 non-recursive
        public ArrayList<Integer> preorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<Integer>();
            }

            Stack<TreeNode> stack = new Stack<TreeNode>();
            ArrayList<Integer> result = new ArrayList<Integer>();
            //root left right
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode top = stack.pop();
                result.add(top.val);
                if (top.right != null) {
                    stack.add(top.right);
                }
                if (top.left != null) {
                    stack.add(top.left);
                }
            }

            return result;
        }

        public ArrayList<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<Integer>();
            }

            Stack<TreeNode> stack = new Stack<TreeNode>();
            ArrayList<Integer> result = new ArrayList<Integer>();
            //root left right
            TreeNode currentNode = root;
            while (currentNode != null || !stack.isEmpty()) {
                if (currentNode == null) {
                    currentNode = stack.pop();
                } else {
                    while (currentNode.left != null) {
                        stack.add(currentNode);
                        currentNode = currentNode.left;
                    }
                }
                result.add(currentNode.val);
                if (currentNode.right != null) {
                    currentNode = currentNode.right;
                } else {
                    currentNode = null;
                }
            }

            return result;
        }

        //2 - 参数 Traversal
        public ArrayList<Integer> preorderTraversal2(TreeNode root) {
            if (root == null) {
                return new ArrayList<Integer>();
            }

            ArrayList<Integer> result = new ArrayList<Integer>();
            preorderTraverse(root, result);

            return result;
        }

        public void preorderTraverse(TreeNode root, ArrayList<Integer> result) {
            if (root == null) {
                return;
            }

            //root left right
            result.add(root.val);
            preorderTraverse(root.left, result);
            preorderTraverse(root.right, result);
            return;
        }

        public ArrayList<Integer> inorderTraversal2(TreeNode root) {
            if (root == null) {
                return new ArrayList<Integer>();
            }

            ArrayList<Integer> inorder = new ArrayList<Integer>();
            inorderTraverse(root, inorder);

            return inorder;
        }

        public void inorderTraverse(TreeNode root, ArrayList<Integer> result) {
            if (root == null) {
                return;
            }

            //left root right
            inorderTraverse(root.left, result);
            result.add(root.val);
            inorderTraverse(root.right, result);
            return;
        }

        public ArrayList<Integer> postorderTraversal2(TreeNode root) {
            if (root == null) {
                return new ArrayList<Integer>();
            }

            ArrayList<Integer> postorder = new ArrayList<Integer>();
            postorderTraverse(root, postorder);

            return postorder;
        }

        public void postorderTraverse(TreeNode root, ArrayList<Integer> result) {
            if (root == null) {
                return;
            }

            //left root right
            postorderTraverse(root.left, result);
            postorderTraverse(root.right, result);
            result.add(root.val);
            return;
        }

        //1 - return 结果 D&Q
        public ArrayList<Integer> preorderTraversal1(TreeNode root) {
            if (root == null) {
                return new ArrayList<Integer>();
            }
            ArrayList<Integer> result = new ArrayList<Integer>();
            //root left right
            result.add(root.val);
            result.addAll(preorderTraversal1(root.left));
            result.addAll(preorderTraversal1(root.right));

            return result;
        }

        public ArrayList<Integer> inorderTraversal1(TreeNode root) {
            if (root == null) {
                return new ArrayList<Integer>();
            }
            ArrayList<Integer> inorder = new ArrayList<Integer>();
            //left root right
            inorder.addAll(inorderTraversal1(root.left));
            inorder.add(root.val);
            inorder.addAll(inorderTraversal1(root.right));

            return inorder;
        }

        public ArrayList<Integer> postorderTraversal1(TreeNode root) {
            if (root == null) {
                return new ArrayList<Integer>();
            }
            ArrayList<Integer> postorder = new ArrayList<Integer>();
            //left root right
            postorder.addAll(postorderTraversal1(root.left));
            postorder.addAll(postorderTraversal1(root.right));
            postorder.add(root.val);

            return postorder;
        }
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//
//        System.out.println("root=" + root);
//        ArrayList<Integer> result = inorderTraversal(root);
//        System.out.println("result=" + result);
//
//
//        TreeNode root2 = new TreeNode(1);
//        root2.right = new TreeNode(2);
//        root2.right.left = new TreeNode(3);
//
//        System.out.println("root2=" + root2);
//        ArrayList<Integer> result2 = inorderTraversal(root2);
//        System.out.println("result2=" + result2);

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
}

