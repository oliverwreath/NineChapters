package com.lintcode.BinaryTree;

import static com.lintcode.BinaryTree.BinaryTree.getTree;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Yanliang Han on 2016/6/11.
 */
@Slf4j
public class LowestCommonAncestor {

  public static void main(String[] args) {
    testLowestCommonAncestor();
  }

  public static void testLowestCommonAncestor() {
    TreeNode root = getTree();
    log.debug("result=" + lowestCommonAncestor(root, root.left, root.right));
  }

  //LCA - lowest common ancestor
  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
    if (root == null || root == A || root == B) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, A, B);
    TreeNode right = lowestCommonAncestor(root.right, A, B);

    if (left != null && right != null) {
      return root;
    } else if (left != null) {
      return left;
    } else if (right != null) {
      return right;
    }
    return null;
  }
}
