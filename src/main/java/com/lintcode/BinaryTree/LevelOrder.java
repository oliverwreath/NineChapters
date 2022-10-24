package com.lintcode.BinaryTree;

import static com.lintcode.BinaryTree.BinaryTree.getSmallTree;

import com.util.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Yanliang Han on 2016/6/11.
 */
@Slf4j
public class LevelOrder {

  public static void main(String[] args) {
    testLevelOrder();
  }

  public static TreeNode getBST() {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(1);

    log.trace("root = {}", root);
    return root;
  }

  public static void testLevelOrder() {
    TreeNode root = getSmallTree();
    log.debug("result=" + levelOrder1Queue(root));
    log.debug("result=" + levelOrder1Queue(getBST()));
    log.debug("result=" + levelOrder1Queue(null));
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
