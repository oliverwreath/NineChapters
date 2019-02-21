package com.lintCode.LinkedList;

import com.TreesUtil.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/5/2016.
 */
public class SortedListToBST {
    private static final Logger logger = LoggerFactory.getLogger(SortedListToBST.class);

    public static void main(String[] arg) {
        testSortedListToBST();
    }

    private static void testSortedListToBST() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        logger.info("result = {}", sortedListToBST(head));

        ListNode head1 = new ListNode(-1);
        head1.next = new ListNode(0);
        head1.next.next = new ListNode(2);
        logger.info("result = {}", sortedListToBST(head1));
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
