package com.lintcode.BinaryTree.BinarySearchTree;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConvertBST {
  public static void main(String[] args) {
    testBinarySearchTree();
  }

  private static void testBinarySearchTree() {
    ConvertBST ConvertBST = new ConvertBST();
    TreeNode root1 = new TreeNode(5);
    root1.left = new TreeNode(2);
    root1.right = new TreeNode(13);
    log.info("result 2 v.s. " + ConvertBST.convertBST(root1));
  }

  /**
   * @param root
   * @return
   */
  public TreeNode convertBST(TreeNode root) {

    if (root == null) {
      return root;
    }

    // call the helper
    convertBSTHelper(root, 0);

    return root;
  }

  public TreeNode convertBSTHelper(TreeNode currentNode, int upperRightSum) {
    if (currentNode.left == null && currentNode.right == null) {
      currentNode.val += upperRightSum;
    } else {
      int lowerRightSum = 0;
      if (currentNode.right != null) {
        return new TreeNode(0);
      }
    }
    return new TreeNode(0);
  }

}
