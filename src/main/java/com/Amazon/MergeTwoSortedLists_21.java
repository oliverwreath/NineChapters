package com.Amazon;

import com.lintCode.DataStructures.ListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-19.
 */
public class MergeTwoSortedLists_21 {
    private final static Logger logger = LoggerFactory.getLogger(MergeTwoSortedLists_21.class);

    public static void main(String[] arg) {
        new MergeTwoSortedLists_21().testSearchA2DMatrix_74();
    }

    private void testSearchA2DMatrix_74() {
//        String[] trueArray = new String[]{"()", "()[]{}"};
//        for (String string : trueArray) {
//            logger.info("{} true = {}", string, mergeTwoLists(string));
//        }
//
//        String[] falseArray = new String[]{"(", "{", "[", "(]", "([)]"};
//        for (String string : falseArray) {
//            logger.info("{} false = {}", string, mergeTwoLists(string));
//        }
        logger.info("list = {}", mergeTwoLists(null, null));
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        logger.info("list = {}", mergeTwoLists(l1, l2));
    }

    /**
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        // handle extreme cases
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        //
        ListNode pre = new ListNode(0);
        ListNode now = pre;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                now.next = l2;
                now = now.next;
                l2 = l2.next;
            } else if (l2 == null) {
                now.next = l1;
                now = now.next;
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    now.next = l1;
                    now = now.next;
                    l1 = l1.next;
                } else {
                    now.next = l2;
                    now = now.next;
                    l2 = l2.next;
                }
            }
        }

        return pre.next;
    }
}
