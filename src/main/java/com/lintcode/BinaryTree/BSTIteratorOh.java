package com.lintcode.BinaryTree;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

import static com.lintcode.BinaryTree.BinaryTree.getTree;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
@Slf4j
public class BSTIteratorOh {
  private TreeNode currentNode = null;
  private Deque<TreeNode> st = new ArrayDeque<TreeNode>();

  public static void main(String[] args) {
    testBSTIterator();
  }

  public static void testBSTIterator() {
    TreeNode root = getTree();
    BSTIteratorOh iterator = new BSTIteratorOh(root);
    while (iterator.hasNext()) {
      TreeNode node = iterator.next();
      log.debug(String.valueOf(node.val));
    }
  }

  //@param root: The root of binary tree.
  public BSTIteratorOh(TreeNode root) {
    this.currentNode = root;
  }

  //@return: True if there has next node, or false
  public boolean hasNext() {
    return (!st.isEmpty() || currentNode != null);
  }

  //@return: return next node
  public TreeNode next() {
    while (currentNode != null) {
      st.push(currentNode);
      currentNode = currentNode.left;
    }

    currentNode = st.pop();
    TreeNode ret = currentNode;
    currentNode = currentNode.right;
    return ret;
  }
}
