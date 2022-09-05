package com.util;

import lombok.extern.slf4j.Slf4j;

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
            "val=" + val +
            ", left=" + left +
            "\n, right=" + right +
            "}";
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