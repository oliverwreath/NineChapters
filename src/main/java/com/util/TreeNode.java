package com.util;

import lombok.extern.slf4j.Slf4j;

import static com.util.TreesUtil.printWholeTreeByLevel;

/**
 * Author: Oliver
 */
@Slf4j
public class TreeNode {
  public int val;
  public TreeNode left, right;

  public TreeNode(int x) {
    val = x;
  }

  @Override
  public String toString() {
    return "TreeNode{" +
            val + ";\n" +
            (left==null?null:left.val) + "," + (right==null?null:right.val) +
            "}";
  }

  public String printTree() {
    return printWholeTreeByLevel(this);
  }

  public TreeNode addLeft(int x) {
    left = new TreeNode(x);
    return left;
  }

  public TreeNode addRight(int x) {
    right = new TreeNode(x);
    return right;
  }
}
