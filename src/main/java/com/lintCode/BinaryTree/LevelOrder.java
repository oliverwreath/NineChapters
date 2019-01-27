package com.lintCode.BinaryTree;

import com.TreesUtil.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static com.lintCode.BinaryTree.BinaryTree.getSmallTree;

/**
 * Created by Yanliang Han on 2016/6/11.
 */
public class LevelOrder {
    private final static Logger logger = LoggerFactory.getLogger(LevelOrder.class);

    public static void main(String[] args) {
        testLevelOrder();
    }

    public static TreeNode getBST() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);

        logger.trace("root = {}", root);
        return root;
    }

    public static void testLevelOrder() {
        TreeNode root = getSmallTree();
        System.out.println("result=" + levelOrder1Queue(root));
        System.out.println("result=" + levelOrder1Queue(getBST()));
        System.out.println("result=" + levelOrder1Queue(null));
    }

    public static ArrayList<ArrayList<Integer>> levelOrder2Queue(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.add(root);
        while (!queue1.isEmpty()) {
            ArrayList<Integer> levelList = new ArrayList<Integer>();
            while (!queue1.isEmpty()) {
                TreeNode remove = queue1.remove();
                levelList.add(remove.val);
                if (remove.left != null) {
                    queue2.add(remove.left);
                }
                if (remove.right != null) {
                    queue2.add(remove.right);
                }
            }
            ret.add(levelList);
            queue1.clear();
            Queue<TreeNode> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }

        return ret;
    }

    public static ArrayList<ArrayList<Integer>> levelOrder1Queue(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return ret;
        }

        LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
        queue1.add(root);
        while (!queue1.isEmpty()) {
            ArrayList<Integer> levelList = new ArrayList<Integer>();
            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue1.remove();
                levelList.add(head.val);
                if (head.left != null) {
                    queue1.add(head.left);
                }
                if (head.right != null) {
                    queue1.add(head.right);
                }
            }
            ret.add(levelList);
        }

        return ret;
    }
}
