package com.lintcode.LinkedList;

import com.util.ListNode;
import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class SortedListToBST {
  public static void main(String[] arg) {
    testSortedListToBST();
  }

  private static void testSortedListToBST() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    log.info("result = {}", sortedListToBST(head));

    ListNode head1 = new ListNode(-1);
    head1.next = new ListNode(0);
    head1.next.next = new ListNode(2);
    log.info("result = {}", sortedListToBST(head1));
  }

  private static ListNode nodeIterator = null;

  static TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }

    // recursively build tree
    nodeIterator = head;
    int len = getLength(nodeIterator);
    nodeIterator = head;
    TreeNode root = sortedListToBSTHelper(len);

    // return root
    return root;
  }

  static int getLength(ListNode nodeIterator) {
    int counter = 0;
    while (nodeIterator != null) {
      counter++;
      nodeIterator = nodeIterator.next;
    }
    return counter;
  }

  static TreeNode sortedListToBSTHelper(int len) {
    if (len <= 0) {
      return null;
    }

    TreeNode root = new TreeNode(0);
    root.left = sortedListToBSTHelper(len / 2);
    root.val = nodeIterator.val;
    nodeIterator = nodeIterator.next;
    root.right = sortedListToBSTHelper(len - 1 - len / 2);

    return root;
  }
}
